package exceptions;

public class UsernameAlreadyExists extends Exception {
	private static final long serialVersionUID = 1L;

	public UsernameAlreadyExists() {
		super();
	}

	/**
	 * This exception is triggered if the event has already finished
	 * 
	 * @param s String of the exception
	 */
	public UsernameAlreadyExists(String s) {
		super(s);
	}
}