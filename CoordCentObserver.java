public interface CoordCentObserver {
	void addIncRecord(String type, String[] teams, int[] reports, String stAddress,
					  String suburb, boolean lifeThreat, String[] options);
	boolean teamExists(String id);
	boolean reportExists(int id);
//	void modIncRecord(Integer id);
}