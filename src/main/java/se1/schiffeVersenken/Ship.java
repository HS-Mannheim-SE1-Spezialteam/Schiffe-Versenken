package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

import java.util.stream.Stream;

import static se1.schiffeVersenken.GameSettings.SIZE_OF_PLAYFIELD;

/**
 * The {@link Ship} is our main "Entity" in the Game. <br>
 * It has a position inside a 10x10 grid world, a direction ({@link Direction#HORIZONTAL HORIZONTAL} or {@link Direction#VERTICAL VERTICAL}) and a length (at most 10).<br>
 * Use {@link Ship#getOccupiedSpaces()} to query all blocks of the world it is using.
 */
public final class Ship {
	
	/**
	 * the left upper corner of the ship
	 */
	private final Vector2i position;
	private final Direction direction;
	private final int length;
	private int health;
	private final Vector2i[] occupiedSpaces;
	
	public Ship(Vector2i position, Direction direction, int length) {
		this.position = position;
		this.direction = direction;
		this.length = length;
		this.health = length;
		
		occupiedSpaces = new Vector2i[length];
		for (int i = 0; i < length; i++)
			occupiedSpaces[i] = position.add(direction.positive.multiply(i));
	}
	
	//getter
	public Vector2i getPosition() {
		return position;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public int getLength() {
		return length;
	}
	
	public int getHealth() {
		return health;
	}
	
	public boolean isSunk() {
		return health == 0;
	}
	
	public Vector2i[] getOccupiedSpaces() {
		return occupiedSpaces;
	}
	
	public Vector2i[] getEmptySpacesSurrounding(GameSettings settings) {
		switch (settings.getShipBorderConditions()) {
			case TOUCHING_ALLOWED:
				return new Vector2i[0];
			case NO_DIRECT_TOUCH:
				Vector2i[] ret = new Vector2i[length * 2 + 2];
				ret[0] = position.add(direction.negative);
				ret[1] = position.add(direction.positive.multiply(length + 1));
				for (int i = 0; i < length * 2; i++)
					ret[i + 2] = position.add(direction.positive.multiply(i / 2)).add(i % 2 == 0 ? direction.other().negative : direction.other().positive);
				return ret;
			case NO_DIRECT_AND_DIAGONAL_TOUCH:
				Vector2i[] ret2 = new Vector2i[length * 2 + 6];
				for (int i = 0; i < 3; i++)
					ret2[i] = position.add(direction.negative).add(direction.other().positive.multiply(i - 1));
				for (int i = 0; i < 3; i++)
					ret2[i + 3] = position.add(direction.positive.multiply(length + 1)).add(direction.other().positive.multiply(i - 1));
				for (int i = 0; i < length * 2; i++)
					ret2[i + 6] = position.add(direction.positive.multiply(i / 2)).add(i % 2 == 0 ? direction.other().negative : direction.other().positive);
				return ret2;
		}
		throw new IllegalArgumentException();
	}
	
	//static
	public static Ship[][] orderShips(Ship[] ships) {
		Ship[][] ret = new Ship[SIZE_OF_PLAYFIELD][];
		Stream<Ship> stream = Stream.of(ships);
		for (int i = 0; i < SIZE_OF_PLAYFIELD; i++) {
			final int i2 = i;
			ret[i] = stream.filter(ship -> ship.length - 1 == i2).toArray(Ship[]::new);
		}
		return ret;
	}
	
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("Ship{");
		sb.append("position=").append(position);
		sb.append(", direction=").append(direction);
		sb.append(", length=").append(length);
		sb.append(", health=").append(health);
		sb.append('}');
		return sb.toString();
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
		
		public Direction other() {
			switch (this) {
				case HORIZONTAL:
					return VERTICAL;
				case VERTICAL:
					return HORIZONTAL;
			}
			throw new IllegalStateException();
		}
	}
}
