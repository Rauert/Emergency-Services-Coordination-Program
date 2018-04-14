public interface ResponseTeamObserver {
	void addIncReport(String[] inRep);
	void displayAllTeams();
	void displayAllReports();
	void displayAllRecords();
	void displayIncReport(int id);
	void displayIncRecord(int id);
}