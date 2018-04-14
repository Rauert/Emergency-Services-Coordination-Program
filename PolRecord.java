public class PolRecord extends AbstractRecord {

	private int numSuspects;
	private String weapons;

	public PolRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
					 String inSuburb, boolean inLifeThreat, int inNumSuspects, String inWeapons)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat);
		numSuspects = inNumSuspects;
		weapons = inWeapons;
	}

	public String toString(){
		String incPolRecString;
		incPolRecString = new String (super.toString() + "\n" + "Police related Info - Number of suspects: "
									  + numSuspects + " | Known suspect armaments: " + weapons);
		return incPolRecString;
	}
}