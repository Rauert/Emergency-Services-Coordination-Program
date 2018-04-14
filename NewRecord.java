public class NewRecord implements Operation {
	public void doOperation(String[] inData){
		AbstractRecord newRecord = Factory.newRecord(inData);
		if (newRecord != null){ //Validation that an object was created.
			Storage.getInstance().addIncRecord(newRecord);
		} else
			System.out.println("Unable to add Record" + "\n");
	}
}