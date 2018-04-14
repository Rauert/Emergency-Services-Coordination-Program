import java.util.ArrayList;

public class CoordCentController extends ResponseTeamController implements CoordCentObserver {

	public CoordCentController(){}

	public void addIncRecord(String type, String[] teams, int[] reports, String stAddress,
							 String suburb, boolean lifeThreat, String[] options){
		int id = newIncRecID();
		AbstractRecord newRecord = Factory.newRecord(id, type, teams, reports, stAddress,
												     suburb, lifeThreat, options);
		if (newRecord != null){ //Validation that an object was created.
			Storage.getInstance().addIncRecord(newRecord);
			String[] alString = new String[3];
			alString[0] = "alert";
			alString[2] = String.valueOf(lifeThreat);
			for (int i=0; i<(teams.length); i++) { //Send alerts to Response Teams.
				alString[1] = teams[i];
				commsController.newMessage(alString[1], alString);
//				System.out.println("Alert sent to " + teams[i]);
			}
			String[] mesString = newRecordMessage(id, type, teams, reports, stAddress,
												  suburb, lifeThreat, options); //Create message string
			
			commsController.newMessage("All", mesString); //Send new Record to all locations.
		} else
			System.out.println("Unable to add Record" + "\n");
	}

	private int newIncRecID(){
		return (Storage.getInstance().getIncRecordCount() + 1);
	} //If deletions were allowed this would not work. Would need to find highest id in list and increment.

	//Creates a new String array of the record to be sent to ALL.
	private String[] newRecordMessage(int id, String type, String[] teams, int[] reports, String stAddress,
									  String suburb, boolean lifeThreat, String[] options){
		ArrayList<String> newMes = new ArrayList<String>();
		newMes.add("addIncRec");
		newMes.add(Integer.toString(id));
		newMes.add(type);
		newMes.add(Integer.toString(teams.length));
		for (int i=0; i<(teams.length); i++) {
			newMes.add(teams[i]);
		}
		newMes.add(Integer.toString(reports.length));
		for (int i=0; i<(reports.length); i++) {
			newMes.add(Integer.toString(reports[i]));
		}
		newMes.add(stAddress);
		newMes.add(suburb);
		newMes.add(String.valueOf(lifeThreat));
		for (int i=0; i<(options.length); i++) {
			newMes.add(options[i]);
		}
		String[] mesString = new String[newMes.size()];
		mesString = newMes.toArray(mesString);
		return mesString;
	}

	public boolean teamExists(String id){
		return Storage.getInstance().teamExists(id);
	}

	public boolean reportExists(int id){
		return Storage.getInstance().reportExists(id);
	}

//	public void modIncRecord(Integer id){
//	}
}