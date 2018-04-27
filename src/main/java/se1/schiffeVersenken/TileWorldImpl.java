package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

public class TileWorldImpl implements TileWorld {
	
	private final Tile[][] tiles;
	
	public TileWorldImpl() {
		this(new Tile[GameSettings.SIZE_OF_PLAYFIELD][GameSettings.SIZE_OF_PLAYFIELD]);
	}
	
	public TileWorldImpl(TileWorld world) {
		this(world.getTileArray());
	}
	
	public TileWorldImpl(Tile[][] tiles) {
		this.tiles = tiles;
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
		if (!position.boundsCheck(Vector2i.NULL_VECTOR, GameSettings.SIZE_OF_PLAYFIELD_VECTOR))
			throw new IllegalArgumentException("Vector out of bounds: " + position);
		return tiles[position.x][position.y];
	}
	
	void setTile(Vector2i position, Tile tile) {
		if (!position.boundsCheck(Vector2i.NULL_VECTOR, GameSettings.SIZE_OF_PLAYFIELD_VECTOR))
			throw new IllegalArgumentException("Vector out of bounds: " + position);
		tiles[position.x][position.y] = tile;
	}
}
