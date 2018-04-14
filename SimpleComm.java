public class SimpleComm extends Comm {

	private CommObserver CMObserver = null;

	public SimpleComm(){}

	public void setCMObserver(CommObserver inObs) {
		CMObserver = inObs;
	}

	public void send(String id, String message) {
		System.out.println("message sent to " + id + "\n");
	}

	public void receive(String id, String message){
		System.out.println("message received from " + id + "\n");
		notify(id, message);
	}

	public void notify(String id, String message) {
		if (CMObserver != null)
			CMObserver.recMessage(id, message);
	}
}