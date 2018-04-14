public abstract class Comm {
	public Comm() {}
	public abstract void send(String id, String message);//Obviously not really abstract in the specification.
	public abstract void receive(String id, String message);
}