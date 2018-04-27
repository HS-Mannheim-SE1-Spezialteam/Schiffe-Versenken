package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

import java.util.stream.Stream;

import static se1.schiffeVersenken.GameSettings.SIZE_OF_PLAYFIELD;

/**
 * The {@link Ship} is our main "Entity" in the Game. <br>
 * It has a position inside a 10x10 grid world, a direction ({@link Direction#HORIZONTAL HORIZONTAL} or {@link Direction#VERTICAL VERTICAL}) and a length (at most 10).<br>
 * Use {@link Ship#getOccupiedSpaces()} to query all blocks of the world it is using.
 */
public class Ship {
	
	/**
	 * the left upper corner of the ship
	 */
	private final Vector2i position;
	private final Direction direction;
	private final int length;
	private final Vector2i[] occupiedSpaces;
	
	public Ship(Vector2i position, Direction direction, int length) {
		this.position = position;
		this.direction = direction;
		this.length = length;
		
		occupiedSpaces = new Vector2i[length];
		for (int i = 0; i < length; i++)
			occupiedSpaces[i] = position.add(direction.positive.multiply(i));
	}
	
	public Vector2i getPosition() {
		return position;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public int getLength() {
		return length;
	}
	
	public Vector2i[] getOccupiedSpaces() {
		return occupiedSpaces;
	}
	
	public static Ship[][] orderShips(Ship[] ships) {
		Ship[][] ret = new Ship[SIZE_OF_PLAYFIELD][];
		Stream<Ship> stream = Stream.of(ships);
		for (int i = 0; i < SIZE_OF_PLAYFIELD; i++) {
			final int i2 = i;
			ret[i] = stream.filter(ship -> ship.length - 1 == i2).toArray(Ship[]::new);
		}
		return ret;
	}
	
	public enum Direction {
		
		HORIZONTAL(new Vector2i(0, 1)),
		VERTICAL(new Vector2i(1, 0));
		
		public final Vector2i positive;
		public final Vector2i negative;
		
		Direction(Vector2i positive) {
			this.positive = positive;
			this.negative = positive.negate();
		}
	}
}
