package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

public interface TileWorld {
	
	Tile getTile(Vector2i position);
	
	enum Tile {
		
		UNDISCOVERED,
		WATER,
		SHIP
		
	}
}
