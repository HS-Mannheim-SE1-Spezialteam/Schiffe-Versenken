package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

public class ShipWorldImpl implements ShipWorld {
	
	private final Ship[][] ships;
	private final Tile[][] tiles;
	
	public ShipWorldImpl(Ship[] ships) {
		this(Ship.orderShips(ships));
	}
	
	public ShipWorldImpl(Ship[][] ships) {
		this.ships = ships;
		this.tiles = new Tile[0][];
	}
	
	@Override
	public Ship[][] getAllShips() {
		Ship[][] ret = new Ship[ships.length][];
		for (int i = 0; i < ships.length; i++)
			ret[i] = ships[i].clone();
		return ret;
	}
	
	@Override
	public Ship[] getShipsOfLength(int shipLength) {
		return ships[shipLength - 1];
	}
	
	@Override
	public Tile[][] getTileArray() {
		Tile[][] ret = new Tile[tiles.length][];
		for (int i = 0; i < tiles.length; i++)
			ret[i] = tiles[i].clone();
		return ret;
	}
	
	@Override
	public Tile getType(Vector2i position) {
		return tiles[position.x][position.y];
	}
}
