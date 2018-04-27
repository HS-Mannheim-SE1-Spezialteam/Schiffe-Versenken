package se1.schiffeVersenken.exception;

/**
 * I'll prefer this to be an {@link Exception} instead of an {@link RuntimeException}, but I don't want ot make to too complicated.
 */
public class InvalidActionException extends RuntimeException {
	
	public InvalidActionException() {
	}
	
	public InvalidActionException(String message) {
		super(message);
	}
	
	public InvalidActionException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidActionException(Throwable cause) {
		super(cause);
	}
}
