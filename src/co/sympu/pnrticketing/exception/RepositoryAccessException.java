package co.sympu.pnrticketing.exception;

/**
 * A convenient Exception class for properly showing
 * error information in the UI.
 * 
 * @author Rian Carlo Reyes
 *
 */
public class RepositoryAccessException extends RuntimeException {
	
	/**
	 * Ignore for now, this is to avoid warnings.
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Nature of this exception. Used to determine
	 * what UI message to show.
	 * 
	 * @author Rian Carlo Reyes
	 *
	 */
	public static enum Type {
		// CREATION,
		// RETRIEVE,
		// PARSE,
		INPUT,
		GENERAL;
	}
	
	/**
	 * RepositoryException type, for proper messages.
	 */
	public Type type;
	
	/**
	 * Constructs a RepositoryAccessException with the specified
	 * message and type.
	 * 
	 * @param message
	 * @param type
	 */
	public RepositoryAccessException(String message, Type type) {
		super(message);
		this.type = type;
	}

}
