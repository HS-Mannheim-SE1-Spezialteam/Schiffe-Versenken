package se1.schiffeVersenken.interfaces;

import se1.schiffeVersenken.interfaces.exception.InvalidActionException;
import se1.schiffeVersenken.interfaces.util.Position;

public abstract class TurnAction {
	
	private boolean taken = false;
	
	public boolean isTaken() {
		return taken;
	}
	
	public abstract Tile shootTile(Position position) throws InvalidActionException;
}
