package exceptionHandler;

public class EmailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmailException() {
		super();
	}
	public String toString() {
		return "Invalid email";
	}
	
}
