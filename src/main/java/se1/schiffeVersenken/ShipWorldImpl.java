package se1.schiffeVersenken;

import se1.schiffeVersenken.exception.InvalidShipPlacementException;
import se1.schiffeVersenken.util.Grid2;
import se1.schiffeVersenken.util.Vector2i;

import static se1.schiffeVersenken.TileWorld.Tile.WATER;

public class ShipWorldImpl implements ShipWorld {
	
	private final Ship[] ships;
	/**
	 * either {@link Tile} or {@link Ship}
	 */
	private final Grid2<Object> tiles;
	
	public ShipWorldImpl(Ship[] ships) throws InvalidShipPlacementException {
		this.ships = ships;
		tiles = new Grid2<>(GameSettings.SIZE_OF_PLAYFIELD_VECTOR, Tile.WATER);
		
		for (Ship ship : ships)
			for (Vector2i vec : ship.getOccupiedSpaces())
				if (tiles.replace(vec, ship) != WATER)
					throw new InvalidShipPlacementException("Ship " + ship + " placed on top of ship" + tiles.get(vec) + "!");
	}
	
	//getter
	@Override
	public Ship[] getShips() {
		return ships;
	}
	
	//get at position
	@Override
	public Object getObject(Vector2i position) {
		return tiles.get(position);
	}
	
	@Override
	public Tile getTile(Vector2i position) {
		Object o = tiles.get(position);
		if (o instanceof Tile)
			return (Tile) o;
		if (o instanceof Ship)
			return Tile.SHIP;
		throw new IllegalStateException("Invalid Entry at " + position);
	}
	
	@Override
	public Ship getShip(Vector2i position) {
		Object o = tiles.get(position);
		if (o instanceof Ship)
			return (Ship) o;
		return null;
	}
}
