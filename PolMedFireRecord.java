public class PolMedFireRecord extends PolMedRecord {

	private String threat;

	public PolMedFireRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
							String inSuburb, boolean inLifeThreat, int inNumSuspects, String inWeapons, int inNumInjured,
							String inInjuries, String inThreat)
	{
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat, inNumSuspects, inWeapons,
			  inNumInjured, inInjuries);
		threat = inThreat;
	}

	public String toString(){
		String incPolMedFireRecString;
		incPolMedFireRecString = new String (super.toString() + "\n" + "Fire related Info - Threat to property: " + threat);
		return incPolMedFireRecString;
	}
}