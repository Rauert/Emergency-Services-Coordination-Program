import java.util.Scanner;

public class ResponseTeamUI {
	
	private ResponseTeamObserver RTObserver = null;
	private SimpleComm simpleComm = null; //Not part of final program. Used for testing/demonstration.
	private int newReportCount = 0; //Not part of final program. Used for testing/demonstration.
	private int newAlertCount = 0; //Not part of final program. Used for testing/demonstration.
	private int newRecordCount = 0; //Not part of final program. Used for testing/demonstration.

	public ResponseTeamUI(){}
	
	public void setRTObserver(ResponseTeamObserver inObs) {
		RTObserver = inObs;
	}

	public void setComm(SimpleComm inComm) {
		simpleComm = inComm;
	}

	public void menu() {
		if (RTObserver != null){
			
			System.out.println("***************************************************************");
			System.out.println("Emergency Coordination Program");
			System.out.println("------------------------------\n");
			System.out.println("1. New Incident Report");
			System.out.println("2. View Incident Report");
			System.out.println("3. View Incident Record");
			System.out.println("4. View All Response Teams");
			System.out.println("5. View All Incident Reports");
			System.out.println("6. View All Incident Records");
			System.out.println("7. Simulate new Report from CC");
			System.out.println("8. Simulate new Alert from CC");
			System.out.println("9. Simulate new Record from CC");
			System.out.println("10. Exit");
			System.out.println("***************************************************************");
			getInput();
		}
		else{
			System.out.println("Controller not connected!!");
			System.exit(0);
		}
	}

	private void getInput(){
		System.out.println("Please select an option by entering the number from the menu\n");
		int input;
		Scanner sc = new Scanner(System.in);
		int temp;
		
		input = sc.nextInt();
		
		switch (input) {
			case 1:
				newIncRep(sc);
				break;
			case 2:
				System.out.println("Please enter report id");
				temp = sc.nextInt();
				RTObserver.displayIncReport(temp);
				System.out.println("\n");
				getInput();
				break;
			case 3:
				System.out.println("Please enter record id");
				temp = sc.nextInt();
				RTObserver.displayIncRecord(temp);
				System.out.println("\n");
				getInput();
				break;
			case 4:
				RTObserver.displayAllTeams();
				menu();
				break;
			case 5:
				RTObserver.displayAllReports();
				menu();
				break;
			case 6:
				RTObserver.displayAllRecords();
				menu();
				break;
			case 7:
				newReport();
				break;
			case 8:
				newAlert();
				break;
			case 9:
				newRecord();
				break;
			case 10:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
				getInput();
				break;
		}
	}

	private void newIncRep(Scanner sc){

		String[] newRep = new String[5];
		String newReceive;
		newRep[0] = "addIncRep";
		newRep[1] = "null";
		System.out.println("\n" + "Please enter the street Address");
		newRep[2] = inputString(sc);
		System.out.println("\n" + "Please enter the suburb");
		newRep[3] = inputString(sc);
		System.out.println("\n" + "Please enter the incident description");
		newRep[4] = inputString(sc);
		RTObserver.addIncReport(newRep);
		newReceive = (newRep[0] + "|" + Integer.toString(Storage.getInstance().getIncReportCount()+1) + "|" + newRep[2]
					  + "|" + newRep[3] + "|" + newRep[4]);
		simpleComm.receive("CC",newReceive);
		menu();
	}

	private String inputString(Scanner sc){
		boolean invalidInput = true;
		String tempString = "";
		while (invalidInput){
			if (sc.hasNext()){
				tempString = sc.next();
				invalidInput = false;
			}
			else{
				System.out.println("Please enter something");
				//				sc.next();
			}
		}
		return tempString;
	}
	
	private void newReport(){
		newReportCount++;
		switch (newReportCount) {
			case 1:
				simpleComm.receive("CC", "addIncRep|0|20 Yolholande Ave|Penrith|Alien Abduction|Johno|0812345678|me@hotmail.com");
				break;
			case 2:
				simpleComm.receive("CC", "addIncRep|0|Harvey Norman|Osbourne Park|werewolf attack");
				break;
			case 3:
				simpleComm.receive("CC", "addIncRep|0|5 Callaway Dr|Joondalup|Ghostbusters needed urgently|Steve Perry|0412345678|sp@yahoo.com");
				break;
			case 4:
				simpleComm.receive("CC", "addIncRep|0|Warwick Shopping Centre|Warwick|Sale on Capri pants!!");
				break;
			default:
				System.out.println("All out of reports");
				break;
		}
		getInput();
	}

	private void newAlert(){
		newAlertCount++;
		switch (newAlertCount) {
			case 1:
				simpleComm.receive("CC", "alert|1|false");
				break;
			case 2:
				simpleComm.receive("CC", "alert|2|true");
				break;
			case 3:
				simpleComm.receive("CC", "alert|3|false");
				break;
			case 4:
				simpleComm.receive("CC", "alert|4|true");
				break;
			default:
				System.out.println("All out of alerts");
				break;
		}
		getInput();
	}

	private void newRecord(){
		newRecordCount++;
		switch (newRecordCount) {
			case 1:
				simpleComm.receive("CC", "addIncRec|2|F|1|FIRMUR|1|5|20 Yolholande Ave|Penrith|true|Some danger");
				break;
			case 2:
				simpleComm.receive("CC", "addIncRec|3|PM|2|HOSRP|POLCS|2|2|3|Harvey Norman|Osbourne Park|false|1|Mittens|1|Dying of laughter");
				break;
			case 3:
				simpleComm.receive("CC", "addIncRec|4|P|1|POLKS|1|7|5 Callaway Dr|Joondalup|false|3|Water Pistols");
				break;
			case 4:
				simpleComm.receive("CC", "addIncRec|5|PMF|1|HOSSCG|2|1|8|Warwick Shopping Centre|Warwick|true|3|Freeze Ray|1|Frostbite|Some danger");
				break;
			default:
				System.out.println("All out of records");
				break;
		}
		getInput();
	}
}