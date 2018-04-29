package se1.schiffeVersenken;

import se1.schiffeVersenken.util.Vector2i;

/**
 * A {@link Player} can {@link Player#takeTurn(TurnAction) take Turns} and supplies it's {@link Player#getShipPlacement() initial placement of Ships}.
 */
public interface Player {
	
	Ship[] getShipPlacement();
	
	void takeTurn(TurnAction turnAction);
	
	void onEnemyShot(Vector2i position, Object target);
}
