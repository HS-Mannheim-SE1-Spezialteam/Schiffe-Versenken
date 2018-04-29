package se1.schiffeVersenken;

import se1.schiffeVersenken.TileWorld.Tile;
import se1.schiffeVersenken.exception.InvalidActionException;
import se1.schiffeVersenken.util.Vector2i;

public class TurnAction {
	
	private boolean taken = false;
	private final TileWorld enemyWorld;
	
	public TurnAction(TileWorld enemyWorld) {
		this.enemyWorld = enemyWorld;
	}
	
	public boolean isTaken() {
		return taken;
	}
	
	public synchronized Tile shootTile(Vector2i position) throws InvalidActionException {
		if (taken)
			throw new InvalidActionException("Turn already taken");
		
		try {
			Tile type = enemyWorld.getTile(position);
			taken = true;
			return type;
		} catch (IllegalArgumentException e) {
			throw new InvalidActionException("Move not allowed", e);
		}
	}
}
