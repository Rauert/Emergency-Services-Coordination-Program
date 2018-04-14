import java.util.Scanner;
import java.util.ArrayList;

public class CoordCentUI {

	private ResponseTeamObserver CCRTObserver = null;
	private CoordCentObserver CCObserver = null;
	private SimpleComm simpleComm = null; //Not part of final program. Used for testing/demonstration.
	private int newReportCount = 0; //Not part of final program. Used for testing/demonstration.

	public CoordCentUI(){
	}

	public void setCCRTObserver(ResponseTeamObserver inObs) {
		CCRTObserver = inObs;
	}

	public void setCCObserver(CoordCentObserver inObs) {
		CCObserver = inObs;
	}

	public void setComm(SimpleComm inComm) {
		simpleComm = inComm;
	}

	public void menu() {
		if ((CCRTObserver != null) && (CCObserver != null)){

			System.out.println("***************************************************************");
			System.out.println("Emergency Coordination Program");
			System.out.println("------------------------------\n");
			System.out.println("1. New Incident Record");
			System.out.println("2. Modify Incident Record");
			System.out.println("3. View Incident Report");
			System.out.println("4. View Incident Record");
			System.out.println("5. View All Response Teams");
			System.out.println("6. View All Incident Reports");
			System.out.println("7. View All Incident Records");
			System.out.println("8. Simulate new Report");
			System.out.println("9. Exit");
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
				newIncRec(sc);
				break;
			case 2:
				System.out.println("I'm sorry, Dave. I'm afraid I can't do that.");
				getInput();
				break;
			case 3:
				System.out.println("Please enter report id");
				temp = sc.nextInt();
				CCRTObserver.displayIncReport(temp);
				System.out.println("\n");
				getInput();
				break;
			case 4:
				System.out.println("Please enter record id");
				temp = sc.nextInt();
				CCRTObserver.displayIncRecord(temp);
				System.out.println("\n");
				getInput();
				break;
			case 5:
				CCRTObserver.displayAllTeams();
				menu();
				break;
			case 6:
				CCRTObserver.displayAllReports();
				menu();
				break;
			case 7:
				CCRTObserver.displayAllRecords();
				menu();
				break;
			case 8:
				newReport();
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
				getInput();
				break;
		}
	}

	private void newIncRec(Scanner sc){
		boolean invalidInput;
		int tempInt;
		String tempString;

		String type;
		String[] teams;
		int[] reports;
		String stAddress;
		String suburb;
		boolean lifeThreat;
		String[] options;
		boolean tempPol;
		boolean tempFire;
		boolean tempMed;
		ArrayList<String> tempOptions = new ArrayList<String>();

		System.out.println("\n" + "Please enter the street Address");
		stAddress = inputString(sc);
		System.out.println("\n" + "Please enter the suburb");
		suburb = inputString(sc);
		System.out.println("\n" + "Is this incident life threatening? (true/false)");
		lifeThreat = inputBol(sc);

		System.out.println("\n" + "How many teams are associated with this record?");
		teams = new String[inputInt(sc)];
		CCRTObserver.displayAllTeams();
			for (int i=0; i<(teams.length); i++) {
				System.out.println("Please enter team number " + (Integer.toString(i+1)));
				invalidInput = true;
				while (invalidInput){
					tempString = inputString(sc);
					if (CCObserver.teamExists(tempString)){
						teams[i] = tempString;
						invalidInput = false;
					}
					else{
						System.out.println("Please enter an existing Response Team");
//						sc.next();
					}
				}
			}

		System.out.println("\n" + "How many incident reports are associated with this record?");
		reports = new int[inputInt(sc)];
		CCRTObserver.displayAllReports();
			for (int i=0; i<(reports.length); i++) {
				System.out.println("Please enter report id number " + (Integer.toString(i+1)));
				invalidInput = true;
				while (invalidInput){
					tempInt = inputInt(sc);
					if (CCObserver.reportExists(tempInt)){
						reports[i] = tempInt;
						invalidInput = false;
					}
					else{
						System.out.println("Please enter an existing Incident Report");
//						sc.next();
					}
				}
			}

		System.out.println("\n" + "Is this record police related? (true/false)");
		tempPol = inputBol(sc);
		if (tempPol == true){
			System.out.println("\n" + "Number of suspects?");
			tempOptions.add(Integer.toString(inputInt(sc)));
			System.out.println("\n" + "What are the suspects armed with?");
			tempOptions.add(inputString(sc));
		}
		System.out.println("\n" + "Is this record medical related? (true/false)");
		tempMed = inputBol(sc);
		if (tempMed == true){
			System.out.println("\n" + "Number of people injured?");
			tempOptions.add(Integer.toString(inputInt(sc)));
			System.out.println("\n" + "What is the nature of the injuries/conditions?");
			tempOptions.add(inputString(sc));
		}
		System.out.println("\n" + "Is this record fire related? (true/false)");
		tempFire = inputBol(sc);
		if (tempFire == true){
			System.out.println("\n" + "What is the threat to nearby properties?");
			tempOptions.add(inputString(sc));
		}
		options = new String[tempOptions.size()];
		options = tempOptions.toArray(options);

		if (tempPol == true){
			if (tempFire == true){
				if (tempMed == true){
					type = "PMF";
				}else{
					type = "PF";
				}
			}else{
				if (tempMed == true){
					type = "PM";
				}
				else{
					type = "P";
				}
			}
		}
		else{
			if (tempFire == true){
				if (tempMed == true){
					type = "MF";
				}
				else{
					type = "F";
				}
			}
			else {
				if (tempMed == true){
					type = "M";
				}
				else{
					type = "ERROR";
				}
			}
		}

		if (type.equals("ERROR") != true)
			CCObserver.addIncRecord(type, teams, reports, stAddress, suburb, lifeThreat, options);
		else
			System.out.println("Not a valid record type. Record cancelled");

		menu();
	}

	private boolean inputBol(Scanner sc){
		boolean invalidInput = true;
		boolean tempBol = false;
		while (invalidInput){
			if (sc.hasNextBoolean()){
				tempBol = sc.nextBoolean();
				invalidInput = false;
			}
			else{
				System.out.println("Please enter true or false");
//				sc.next();
			}
		}
		return tempBol;
	}

	private int inputInt(Scanner sc){
		boolean invalidInput = true;
		int tempInt = 0;
		while (invalidInput){
			if (sc.hasNextInt()){
				tempInt = sc.nextInt();
				if (tempInt > 0){
					invalidInput = false;
				}
			}
			else{
				System.out.println("Please enter an integer larger than 0");
//				sc.next();
			}
		}
		return tempInt;
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
				simpleComm.receive("WEB", "addIncRep|0|20 Yolholande Ave|Penrith|Alien Abduction|Johno|0812345678|me@hotmail.com");
				break;
			case 2:
				simpleComm.receive("HOSM", "addIncRep|0|Harvey Norman|Osbourne Park|werewolf attack");
				break;
			case 3:
				simpleComm.receive("WEB", "addIncRep|0|5 Callaway Dr|Joondalup|Ghostbusters needed urgently|Steve Perry|0412345678|sp@yahoo.com");
				break;
			case 4:
				simpleComm.receive("FIROP", "addIncRep|0|Warwick Shopping Centre|Warwick|Sale on Capri pants!!");
				break;
			default:
				System.out.println("All out of reports");
				break;
		}
		getInput();
	}
}