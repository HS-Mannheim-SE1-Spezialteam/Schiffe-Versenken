package se1.schiffeVersenken.game;

import se1.schiffeVersenken.GameSettings;
import se1.schiffeVersenken.Player;
import se1.schiffeVersenken.PlayerCreator;
import se1.schiffeVersenken.ShipWorld;
import se1.schiffeVersenken.ShipWorldImpl;
import se1.schiffeVersenken.TileWorldImpl;
import se1.schiffeVersenken.TurnAction;

public class GameManagerDemo extends GameManager {
	
	public GameManagerDemo(PlayerCreator playerCreator1, PlayerCreator playerCreator2) {
		super(playerCreator1, playerCreator2);
	}
	
	@Override
	public void runGame(GameSettings settings) {
		Game game1 = new Game(settings, playerCreator1);
		Game game2 = new Game(settings, playerCreator2);
		
		game1.takeTurn(game2);
		game2.takeTurn(game1);
	}
	
	private class Game {
		
		Player player;
		ShipWorld ownWorld;
		TileWorldImpl shotWorld;
		
		public Game(GameSettings settings, PlayerCreator playerCreator) {
			player = playerCreator.createPlayer(settings);
			ownWorld = new ShipWorldImpl(player.getShipPlacement());
			shotWorld = new TileWorldImpl();
		}
		
		public void takeTurn(Game other) {
			player.takeTurn(new TurnAction(shotWorld, other.ownWorld));
		}
	}
}
