package se1.schiffeVersenken.interfaces;

import se1.schiffeVersenken.interfaces.exception.InvalidShipPlacementException;

public interface ShipPlacer {
	
	void setShips(Ship[] ships) throws InvalidShipPlacementException;
}
