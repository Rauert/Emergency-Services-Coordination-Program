import java.util.ArrayList;

public class Storage {
//Singleton pattern. Only need one Storage for each running copy of Program.

	public static Storage instance = null;
	private ArrayList<String> responseTeams;
	private ArrayList<InternalReport> incidentReports;
	private ArrayList<AbstractRecord> incidentRecords;

	public static Storage getInstance() {
		if (instance == null)
			instance = new Storage();
		return instance;
	}

	private Storage(){
		responseTeams = new ArrayList<String>();
		incidentReports = new ArrayList<InternalReport>();
		incidentRecords = new ArrayList<AbstractRecord>();
	}

	public void addTeam(String inId) {
		responseTeams.add(inId);
	}

	public void addIncReport(InternalReport inRep) {
		incidentReports.add(inRep);
	}

	public void addIncRecord(AbstractRecord inRec) {
		incidentRecords.add(inRec);
	}

	public ArrayList<String> getTeams() {
		return responseTeams;
	}

	public ArrayList<InternalReport> getIncReport() {
		return incidentReports;
	}

	public ArrayList<AbstractRecord> getIncRecord() {
		return incidentRecords;
	}

	public int getIncReportCount(){
		return incidentReports.size();
	}

	public int getIncRecordCount(){
		return incidentRecords.size();
	}

	public InternalReport getIncReport(int id) {
		InternalReport report = null;
		for (int i = 0; i < incidentReports.size(); i++){
			if (id == incidentReports.get(i).getId())
				report = incidentReports.get(i);
		}
		return report;
	}

	public AbstractRecord getIncRecord(int id) {
		AbstractRecord record = null;
		for (int i = 0; i < incidentRecords.size(); i++){
			if (id == incidentRecords.get(i).getId())
				record = incidentRecords.get(i);
		}
		return record;
	}

	public boolean teamExists(String id){
		boolean exists = false;
		for (int i = 0; i < responseTeams.size(); i++){
			if (id.equals(responseTeams.get(i)))
				exists = true;
		}
		return exists;
	}

	public boolean reportExists(int id){
		boolean exists = false;
		for (int i = 0; i < incidentReports.size(); i++){
			if (id == incidentReports.get(i).getId())
				exists = true;
		}
		return exists;
	}

//	public void replaceIncRecord(AbstractRecord inRec) {...}
}