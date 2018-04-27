package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

import java.util.Arrays;

public class GameSettings {
	
	public static final int SIZE_OF_PLAYFIELD = 10;
	public static final Vector2i SIZE_OF_PLAYFIELD_VECTOR = new Vector2i(SIZE_OF_PLAYFIELD, SIZE_OF_PLAYFIELD);
	
	private final ShipBorderConditions shipBorderConditions;
	private final int[] numberOfShips;
	
	GameSettings(ShipBorderConditions shipBorderConditions, int[] numberOfShips) {
		this.shipBorderConditions = shipBorderConditions;
		this.numberOfShips = Arrays.copyOf(numberOfShips, SIZE_OF_PLAYFIELD);
	}
	
	public ShipBorderConditions getShipBorderConditions() {
		return shipBorderConditions;
	}
	
	public int[] getNumberOfShips() {
		return numberOfShips;
	}
	
	public int getNumberOfShips(int shipLength) {
		return numberOfShips[shipLength - 1];
	}
	
	public enum ShipBorderConditions {
		
		TOUCHING_ALLOWED,
		NO_DIRECT_TOUCH,
		NO_DIRECT_AND_DIAGONAL_TOUCH
		
	}
	
	public static class NumberOfShipsBuilder {
		
		private int[] array = new int[SIZE_OF_PLAYFIELD];
		
		public void set(int shipLength, int count) {
			array[shipLength - 1] = count;
		}
		
		public int[] create() {
			return array.clone();
		}
	}
}
