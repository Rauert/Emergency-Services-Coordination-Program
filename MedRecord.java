public class MedRecord extends AbstractRecord {

	private Integer numInjured;
	private String injuries;

	public MedRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
					 String inSuburb, boolean inLifeThreat, int inNumInjured, String inInjuries)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat);
		numInjured = inNumInjured;
		injuries = inInjuries;
	}

	public String toString(){
		String incMedRecString;
		incMedRecString = new String (super.toString() + "\n" + "Medical related Info - Number of patients: "
									  + numInjured + " | Nature of injuries/conditions: " + injuries);
		return incMedRecString;
	}
}