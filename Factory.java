public class Factory {

	public static InternalReport newReport(String[] inRep){
		InternalReport newRep = null;
		if (inRep.length == 5)
			newRep = new InternalReport(Integer.parseInt(inRep[1]), inRep[2], inRep[3], inRep[4]);
		else if (inRep.length == 8)
			newRep = new ExternalReport(Integer.parseInt(inRep[1]), inRep[2], inRep[3], inRep[4],
										inRep[5], inRep[6], inRep[7]);
		return newRep;
	}

	public static AbstractRecord newRecord(String[] inRec){
		AbstractRecord newRec = null;

		int arrayLocation = 4;

		int id = Integer.parseInt(inRec[1]);
		String type = inRec[2];
		int numTeams = Integer.parseInt(inRec[3]);
		String[] resTeams = new String[numTeams];
		for (int i = 0; i < numTeams; i++){
			resTeams[i] = inRec[arrayLocation];
			arrayLocation++;
		}
		int numReps = Integer.parseInt(inRec[arrayLocation]);
		arrayLocation++;
		int[] incReps = new int[numReps];
		for (int j = 0; j < numReps; j++){
			incReps[j] = Integer.parseInt(inRec[arrayLocation]);
			arrayLocation++;
		}
		String stAddress = inRec[arrayLocation++];
		String suburb = inRec[arrayLocation++];
		boolean lifeThreat = Boolean.parseBoolean(inRec[arrayLocation++]);

//		Note: Whilst this would have been better as a case statement, using a String in a case
//		only became possible in JDK7, so I'm playing it safe with else-ifs.
		if (type.equals("P"))
			newRec = new PolRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
								   Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++]);
		else if (type.equals("F"))
			newRec = new FireRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
									inRec[arrayLocation++]);
		else if (type.equals("M"))
			newRec = new MedRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
								   Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++]);
		else if (type.equals("PF"))
			newRec = new PolFireRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
								       Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++],
									   inRec[arrayLocation++]);
		else if (type.equals("PM"))
			newRec = new PolMedRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
									  Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++],
									  Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++]);
		else if (type.equals("MF"))
			newRec = new MedFireRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
									   Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++],
									   inRec[arrayLocation++]);
		else if (type.equals("PMF"))
			newRec = new PolMedFireRecord(id, type, resTeams, incReps, stAddress, suburb, lifeThreat,
									      Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++],
										  Integer.parseInt(inRec[arrayLocation++]), inRec[arrayLocation++],
										  inRec[arrayLocation++]);
		return newRec;
	}

	public static AbstractRecord newRecord(int id, String type, String[] teams, int[] reports, String stAddress,
									String suburb, boolean lifeThreat, String[] options){

		AbstractRecord newRec = null;

		if (type.equals("P"))
			newRec = new PolRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
								   options[1]);
		else if (type.equals("F"))
			newRec = new FireRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, options[0]);
		else if (type.equals("M"))
			newRec = new MedRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
								   options[1]);
		else if (type.equals("PF"))
			newRec = new PolFireRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
									   options[1], options[2]);
		else if (type.equals("PM"))
			newRec = new PolMedRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
									  options[1], Integer.parseInt(options[2]), options[3]);
		else if (type.equals("MF"))
			newRec = new MedFireRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
									   options[1], options[2]);
		else if (type.equals("PMF"))
			newRec = new PolMedFireRecord(id, type, teams, reports, stAddress, suburb, lifeThreat, Integer.parseInt(options[0]),
										  options[1], Integer.parseInt(options[2]), options[3], options[4]);
		return newRec;
	}
}