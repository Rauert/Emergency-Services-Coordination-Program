public class MedFireRecord extends MedRecord {

	private String threat;

	public MedFireRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
						 String inSuburb, boolean inLifeThreat, int inNumInjured, String inInjuries, String inThreat)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat, inNumInjured, inInjuries);
		threat = inThreat;
	}

	public String toString(){
		String incMedFireRecString;
		incMedFireRecString = new String (super.toString() + "\n" + "Fire related Info - Threat to property: " + threat);
		return incMedFireRecString;
	}
}