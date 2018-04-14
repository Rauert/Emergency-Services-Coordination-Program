public class AbstractRecord {

	private int id;
	private String recType;
	private String[] responseTeams;
	private int[] incidentReports;
	private String stAddress;
	private String suburb;
	private boolean lifeThreat;

	public AbstractRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps,
						  String inStAddress, String inSuburb, boolean inLifeThreat){
		id = inId;
		recType = inRecType;
		responseTeams = inResTeams;
		incidentReports = inIncReps;
		stAddress = inStAddress;
		suburb = inSuburb;
		lifeThreat = inLifeThreat;
	}

	public String toString(){ //Used for displaying Records to users in UI.
		String incRecString;
		incRecString = new String ("ID: " + id + " | Record Type: " + recType + " | Life Threatening: " + lifeThreat + "\n" + "Response Teams:"
								   + toStringTeams() + "\n" + "Incident Reports:" + toStringReports() + "\n"
								   + "Address: " + stAddress + ", " + suburb);
		return incRecString;
	}

	private String toStringTeams(){ //For adding arrays to toString.
		String resTeamsString = "";
		for (int i = 0; i < responseTeams.length; i++)
			resTeamsString = resTeamsString + " " + responseTeams[i];
		return resTeamsString;
	}

	private String toStringReports(){
		String incReportsString = "";
		for (int i = 0; i < incidentReports.length; i++)
			incReportsString = incReportsString + " " + incidentReports[i];
		return incReportsString;
	}

	public int getId(){
		return id;
	}
}