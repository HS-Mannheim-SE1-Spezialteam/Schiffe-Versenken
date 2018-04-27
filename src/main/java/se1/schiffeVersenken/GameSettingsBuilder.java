package se1.schiffeVersenken;

import se1.schiffeVersenken.GameSettings.ShipBorderConditions;

public class GameSettingsBuilder {
	
	private ShipBorderConditions shipBorderConditions;
	private int[] numOfShips = new int[GameSettings.SIZE_OF_PLAYFIELD];
	
	public GameSettingsBuilder setShipBorderConditions(ShipBorderConditions shipBorderConditions) {
		this.shipBorderConditions = shipBorderConditions;
		return this;
	}
	
	public GameSettingsBuilder setNumOfShips(int shipLength, int count) {
		numOfShips[shipLength - 1] = count;
		return this;
	}
	
	public GameSettings createGameSettings() {
		return new GameSettings(shipBorderConditions, numOfShips);
	}
}