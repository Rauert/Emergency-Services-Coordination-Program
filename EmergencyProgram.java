import java.lang.*;
import java.util.*;
import java.io.*;

public class EmergencyProgram
{
	public static void main ( String args[] )
	{
		//Add data.
		Storage storage = Storage.getInstance();
		storage.addTeam("HOSRP");
		storage.addTeam("HOSM");
		storage.addTeam("HOSSCG");
		storage.addTeam("POLPPC");
		storage.addTeam("POLCS");
		storage.addTeam("POLKS");
		storage.addTeam("FIROP");
		storage.addTeam("FIRFRE");
		storage.addTeam("FIRMUR");
		ExternalReport rep1 = new ExternalReport(1,"67 Filamide Way","Hillary's","Godzilla attack (Again)",
												 "Ishirō Honda","0412345678","ihonda@iinet.net.au");
		storage.addIncReport(rep1);
		InternalReport rep2 = new InternalReport(2,"David Jones","Perth","Vending machine is empty");
		storage.addIncReport(rep2);
		ExternalReport rep3 = new ExternalReport(3,"East Perth Cemetery","East Perth","The dead are rising from their graves!!",
												 "George Romero","0812345678","gromero@bigpond.net.au");
		storage.addIncReport(rep3);
		InternalReport rep4 = new InternalReport(4,"22 Kenzington St","Duncraig","Nudist get-together disrupting neighbours (Plus they didn't invite me)");
		storage.addIncReport(rep4);
		String[] tempArr = {"POLPPC"};
		int[] tempArr2 = {1};
		PolRecord rec1 = new PolRecord(1,"P",tempArr,tempArr2,"67 Filamide Way","Hillary's",true,1,"Big ass feet");
		storage.addIncRecord(rec1);

		//Set up connections.
		SimpleComm simpleComm = new SimpleComm();
		CommsController commsController = new CommsController();
		commsController.setComms(simpleComm);
		simpleComm.setCMObserver(commsController);

		int input;
		Scanner sc = new Scanner(System.in);
		boolean invalidInput = true;
		System.out.println("\n" + "Which UI would you like to load"); //Used for demonstration purposes.
		System.out.println("(1) Coordination Centre UI");
		System.out.println("(2) Reponse Team UI");
		System.out.println("Enter any other key to Exit" + "\n");
		System.out.println("Please enter a number:");

		while (invalidInput){
			if (sc.hasNextInt()){
				input = sc.nextInt();
					if (input == 1){
						CoordCentController controller = new CoordCentController();
						controller.setCommsController(commsController);
						CoordCentUI ui = new CoordCentUI();
						ui.setCCRTObserver(controller);
						ui.setCCObserver(controller);
						ui.setComm(simpleComm); //Used for testing/demonstration.
						ui.menu();
					}
					else if (input == 2){
						ResponseTeamController controller = new ResponseTeamController();
						controller.setCommsController(commsController);
						ResponseTeamUI ui = new ResponseTeamUI();
						ui.setRTObserver(controller);
						ui.setComm(simpleComm); //Used for testing/demonstration.
						ui.menu();
					}
					else
						System.exit(0);
			}
			else
				System.exit(0);
		}
	}
}