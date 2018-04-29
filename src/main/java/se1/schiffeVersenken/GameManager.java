package se1.schiffeVersenken;

import se1.schiffeVersenken.exception.InvalidShipPlacementException;
import se1.schiffeVersenken.util.RepeatingIterable;

public class GameManager {
	
	public PlayerCreator playerCreator1;
	public PlayerCreator playerCreator2;
	
	public GameManager(PlayerCreator playerCreator1, PlayerCreator playerCreator2) {
		this.playerCreator1 = playerCreator1;
		this.playerCreator2 = playerCreator2;
	}
	
	public void runGame(GameSettings settings) throws InvalidShipPlacementException {
		Game g1 = new Game(settings, playerCreator1);
		Game g2 = new Game(settings, playerCreator2);
		
		for (Game game : new RepeatingIterable<>(g1, g2)) {
		
		}
	}
	
	private class Game {
		
		Player player;
		ShipWorld ownWorld;
		
		public Game(GameSettings settings, PlayerCreator playerCreator) throws InvalidShipPlacementException {
			player = playerCreator.createPlayer(settings);
			ownWorld = new ShipWorldImpl(player.getShipPlacement());
		}
		
		public void takeTurn(Game other) {
			player.takeTurn(new TurnAction(other.ownWorld));
		}
	}
}
