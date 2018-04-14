public class Alert implements Operation {
	public void doOperation(String[] inData){
		String threat = "";
		if (Boolean.parseBoolean(inData[2]) == true)
			threat = " LIFE THREATENING EMERGENCY";
		System.out.println("ALERT: Please respond to incident. See incident record: " + inData[1] + threat);
	}
}