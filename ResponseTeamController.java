import java.util.ArrayList;

public class ResponseTeamController implements ResponseTeamObserver {

	public CommsController commsController = null;

	public ResponseTeamController(){}

	public void setCommsController(CommsController inCommsCont){
		commsController = inCommsCont;
	}

	public void addIncReport(String[] inRep){
		commsController.newMessage("CC",inRep);
	}

	public void displayAllTeams(){
		ArrayList<String> teams = Storage.getInstance().getTeams();
		if (teams.isEmpty()){
			System.out.println("No Response Teams");
		}else{
			for (int i = 0; i < teams.size(); i++){
				System.out.println("\n" + teams.get(i));
			}
		}
		System.out.println("\n");
	}

	public void displayAllReports(){
		ArrayList<InternalReport> reports = Storage.getInstance().getIncReport();
		if (reports.isEmpty()){
			System.out.println("No Reports");
		}else{
			for (int i = 0; i < reports.size(); i++){
				System.out.println("\n" + reports.get(i).toString());
			}
		}
		System.out.println("\n");
	}

	public void displayAllRecords(){
		ArrayList<AbstractRecord> records = Storage.getInstance().getIncRecord();
		if (records.isEmpty()){
			System.out.println("No Records");
		}else{
			for (int i = 0; i < records.size(); i++){
				System.out.println("\n" + records.get(i).toString());
			}
		}
		System.out.println("\n");
	}

	public void displayIncReport(int id){
		InternalReport report = Storage.getInstance().getIncReport(id);
		if (report != null)
			System.out.println(report.toString());
		else
			System.out.println("Report does not exist");
	}

	public void displayIncRecord(int id){
		AbstractRecord record = Storage.getInstance().getIncRecord(id);
		if (record != null)
			System.out.println(record.toString());
		else
			System.out.println("Record does not exist");
	}
}
