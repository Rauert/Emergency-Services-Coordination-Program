public class FireRecord extends AbstractRecord {

	private String threat;

	public FireRecord(int inId, String inRecType, String[] inResTeams, int[] inIncReps, String inStAddress,
					  String inSuburb, boolean inLifeThreat, String inThreat){
		super(inId, inRecType, inResTeams, inIncReps, inStAddress, inSuburb, inLifeThreat);
		threat = inThreat;
	}

	public String toString(){
		String incFireRecString;
		incFireRecString = new String (super.toString() + "\n" + "Fire related Info - Threat to property: " + threat);
		return incFireRecString;
	}
}