public class CommsController implements CommObserver {
		
	private Operation commOperation = null;
	private Comm comm = null;

	public CommsController(){}

	private void setOperation(Operation inOp){
		commOperation = inOp;
	}

	public void setComms(Comm inComm){
		comm = inComm;
	}

	private void doOperation(String[] inData){
		if (commOperation != null)
			commOperation.doOperation(inData);
	}

	public void recMessage(String id, String message){
		String[] newMess = splitMessage(message);
			if (newMess[0].equals("addIncRec")){
				setOperation(new NewRecord());
				doOperation(newMess);
			}
			else if (newMess[0].equals("alert")){
				setOperation(new Alert());
				doOperation(newMess);
			}
			else if (newMess[0].equals("addIncRep")){
				newMess[1] = Integer.toString(newIncRepID()); //Adds new id.
				setOperation(new NewReport());
				doOperation(newMess);
				//If newReport is being received by CC, alerts that a new report has come in
				//and sends report to ALL locations for local storage.
				if (id.equals("CC") == false){ //Only runs if id= WEB or RT. Reports received by Response Teams will have an id of CC.
					System.out.println("Received new incident report, ID: " + newMess[1] + "\n");
					newMessage("ALL",message);
				}
			}
//			else if (newMess[0].equals("modIncRec")){
//				setOperation(new ModRecord());
//				doOperation(newMess);
//			}
//			else if (newMess[0].equals("modify")){
//				setOperation(new Modify());
//				doOperation(newMess);
//			}
			else{
				System.out.println("Cannot interpret message from " + id + "\n" + "Full message: " + message);
			}
		setOperation(null);
	}

	public void newMessage(String commID, String[] inMessage) {
		String combiMess = combiMessage(inMessage);
		comm.send(commID, combiMess);
	}

	public void newMessage(String commID, String inMessage) {
		comm.send(commID, inMessage);
	}

	public String[] splitMessage(String message) {
		String[] outMes = message.split("\\|");
		return outMes;
	}

	public String combiMessage(String[] inMessage) {
		String outMes = "";
		for (int i=0; i<(inMessage.length-1); i++) {
			outMes = (outMes + inMessage[i] + "|");
		}
		outMes = (outMes + inMessage[inMessage.length-1]); //Adds last item without delimiter.
		return outMes;
	}
	private int newIncRepID(){
		return (Storage.getInstance().getIncReportCount() + 1);
	}
}
