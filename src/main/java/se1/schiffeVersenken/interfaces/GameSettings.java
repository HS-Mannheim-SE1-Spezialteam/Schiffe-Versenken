package se1.schiffeVersenken.interfaces;

import se1.schiffeVersenken.interfaces.util.Position;

import java.util.Arrays;

public class GameSettings {
	
	public static final int SIZE_OF_PLAYFIELD = 10;
	public static final Position SIZE_OF_PLAYFIELD_VECTOR = new Position(SIZE_OF_PLAYFIELD, SIZE_OF_PLAYFIELD);
	
	private final ShipBorderConditions shipBorderConditions;
	private final int[] numberOfShips;
	
	GameSettings(ShipBorderConditions shipBorderConditions, int[] numberOfShips) {
		this.shipBorderConditions = shipBorderConditions;
		this.numberOfShips = Arrays.copyOf(numberOfShips, SIZE_OF_PLAYFIELD);
	}
	
	//getter
	public ShipBorderConditions getShipBorderConditions() {
		return shipBorderConditions;
	}
	
	public int[] getNumberOfShips() {
		return numberOfShips;
	}
	
	public int getNumberOfShips(int shipLength) {
		return numberOfShips[shipLength - 1];
	}

//	//validate
//	public ShipWorld validate(Ship[] ships) throws InvalidShipPlacementException {
//		int[] count = new int[numberOfShips.length];
//		for (Ship ship : ships)
//			count[ship.getLength()]++;
//		for (int i = 0; i < numberOfShips.length; i++)
//			if (count[i] != numberOfShips[i])
//				throw new InvalidShipPlacementException("Too many ships of length " + i);
//
//		ShipWorldImpl shipWorld = new ShipWorldImpl(ships);
//		for (Ship ship : ships)
//			for (Position vec : ship.getEmptySpacesSurrounding(this))
//				if (shipWorld.getTile(vec) == Tile.SHIP)
//					throw new InvalidShipPlacementException("The ship " + ship + " is too close to tile " + vec);
//
//		return shipWorld;
//	}
	
	//enum
	public enum ShipBorderConditions {
		
		TOUCHING_ALLOWED,
		NO_DIRECT_TOUCH,
		NO_DIRECT_AND_DIAGONAL_TOUCH
		
	}
}
