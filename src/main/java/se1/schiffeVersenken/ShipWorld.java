package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

public interface ShipWorld extends TileWorld {
	
	Ship[] getShips();
	
	Object getObject(Vector2i position);
	
	@Override
	Tile getTile(Vector2i position);
	
	Ship getShip(Vector2i position);
}
