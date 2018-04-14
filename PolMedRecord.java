public class PolMedRecord extends PolRecord {

	private Integer numInjured;
	private String injuries;

	public PolMedRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
						String inSuburb, boolean inLifeThreat, int inNumSuspects, String inWeapons,
						int inNumInjured, String inInjuries)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat, inNumSuspects, inWeapons);
		numInjured = inNumInjured;
		injuries = inInjuries;
	}

	public String toString(){
		String incPolMedRecString;
		incPolMedRecString = new String (super.toString() + "\n" + "Medical related Info - Number of patients: "
									  + numInjured + " | Nature of injuries/conditions: " + injuries);
		return incPolMedRecString;
	}
}