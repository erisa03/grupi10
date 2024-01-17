package exceptionHandler;
public class FieldEntryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FieldEntryException() {
		super();
	}
	public String toString() {
		return "Fields can't be empty";
	}

}
