public class InternalReport {

	private int id;
	private String stAddress;
	private String suburb;
	private String desc;

	public InternalReport(int inId, String inStAddress, String inSuburb, String inDesc){
		id = inId;
		stAddress = inStAddress;
		suburb = inSuburb;
		desc = inDesc;
	}

	public String toString(){ //Used for displaying Reports to users in UI.
		String intRepString;
		intRepString = new String ("ID: " + id + "\n" + "Address: " + stAddress + ", " + suburb + "\n" + "Description: " + desc);
		return intRepString;
	}

	public int getId(){
		return id;
	}
}