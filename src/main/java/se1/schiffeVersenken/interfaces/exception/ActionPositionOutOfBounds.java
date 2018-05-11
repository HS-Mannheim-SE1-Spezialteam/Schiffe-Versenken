package se1.schiffeVersenken.interfaces.exception;

import se1.schiffeVersenken.interfaces.util.Position;

public class ActionPositionOutOfBounds extends InvalidActionException {
	
	private final Position pos;
	
	public ActionPositionOutOfBounds(Position pos) {
		super("Invalid Position: " + pos + "!");
		this.pos = pos;
	}
}
