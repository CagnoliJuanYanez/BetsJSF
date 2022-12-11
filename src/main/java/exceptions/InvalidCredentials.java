package exceptions;

public class InvalidCredentials extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidCredentials() {
		super();
	}

	/**
	 * This exception is triggered if the event has already finished
	 * 
	 * @param s String of the exception
	 */
	public InvalidCredentials(String s) {
		super(s);
	}
}