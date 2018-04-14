public class PolFireRecord extends PolRecord {

	private String threat;

	public PolFireRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
						 String inSuburb, boolean inLifeThreat, int inNumSuspects, String inWeapons, String inThreat)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat, inNumSuspects, inWeapons);
		threat = inThreat;
	}

	public String toString(){
		String incPolFireRecString;
		incPolFireRecString = new String (super.toString() + "\n" + "Fire related Info - Threat to property: " + threat);
		return incPolFireRecString;
	}
}