public class NewReport implements Operation {
	public void doOperation(String[] inData){
		InternalReport newReport = Factory.newReport(inData);
		if (newReport != null){ //Validation that an object was created.
			Storage.getInstance().addIncReport(newReport);
		} else
			System.out.println("Unable to add Report" + "\n");
	}
}