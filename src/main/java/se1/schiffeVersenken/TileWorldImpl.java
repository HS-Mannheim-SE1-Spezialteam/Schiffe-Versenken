package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Grid2;
import se1.schiffeVersenken.util.Vector2i;

public class TileWorldImpl implements TileWorld {
	
	private final Grid2<Tile> tiles;
	
	public TileWorldImpl() {
		this(Tile.UNDISCOVERED);
	}
	
	public TileWorldImpl(Tile defaultTile) {
		tiles = new Grid2<>(GameSettings.SIZE_OF_PLAYFIELD_VECTOR, defaultTile);
	}
	
	@Override
	public Tile getTile(Vector2i position) {
		return tiles.get(position);
	}
	
	public void setTile(Vector2i position, Tile tile) {
		tiles.set(position, tile);
	}

//	public SecureTileWorld makeSecureTileWorld() {
//		return new SecureTileWorld();
//	}
//
//	private class SecureTileWorld implements TileWorld {
//
//		@Override
//		public Tile getTile(Vector2i position) {
//			return TileWorldImpl.this.getTile(position);
//		}
//	}
}
