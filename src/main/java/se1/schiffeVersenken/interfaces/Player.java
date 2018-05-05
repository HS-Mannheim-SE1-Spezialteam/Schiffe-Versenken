package se1.schiffeVersenken.interfaces;

import se1.schiffeVersenken.interfaces.util.Position;

/**
 * A {@link Player} can {@link Player#takeTurn(TurnAction) take Turns} and supplies it's {@link Player#placeShips(ShipPlacer) initial placement of Ships}.
 */
public interface Player {
	
	void placeShips(ShipPlacer placer);
	
	void takeTurn(TurnAction turnAction);
	
	void onEnemyShot(Position position, Object target);
}
