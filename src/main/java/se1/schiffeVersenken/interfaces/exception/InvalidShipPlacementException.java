package se1.schiffeVersenken.interfaces.exception;

public class InvalidShipPlacementException extends Exception {
	
	public InvalidShipPlacementException() {
	}
	
	public InvalidShipPlacementException(String message) {
		super(message);
	}
	
	public InvalidShipPlacementException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public InvalidShipPlacementException(Throwable cause) {
		super(cause);
	}
}
