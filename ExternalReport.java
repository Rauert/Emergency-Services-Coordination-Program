public class ExternalReport extends InternalReport {

	private String name;
	private String phone; //Using a string since leading 0's force compiler to interpret number as an octal.
	private String email;

	public ExternalReport(int inId, String inStAddress, String inSuburb, String inDesc, String inName, String inPhone, String inEmail){
		super(inId, inStAddress, inSuburb, inDesc);
		name = inName;
		phone = inPhone;
		email = inEmail;
	}

	public String toString(){
		String extRepString;
		extRepString = new String (super.toString() + "\n" + "Reporter Details - Name: " + name + " | Phone: " + phone + " | email: " + email);
		return extRepString;
	}
}