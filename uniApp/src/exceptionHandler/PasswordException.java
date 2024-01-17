package exceptionHandler;

public class PasswordException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PasswordException() {
		super();
	}
	public String toString() {
		return "Invalid password!";
	}
}
