package se1.schiffeVersenken;

/**
 * A {@link Player} can {@link Player#takeTurn(TurnAction) take Turns} adn supplies it's {@link Player#getShipPlacement() initial placement of Ships}.
 */
public interface Player {
	
	Ship[] getShipPlacement();
	
	void takeTurn(TurnAction turnAction);
}
