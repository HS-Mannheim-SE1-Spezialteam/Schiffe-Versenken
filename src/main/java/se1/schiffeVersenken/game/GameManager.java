package se1.schiffeVersenken.game;

import se1.schiffeVersenken.GameSettings;
import se1.schiffeVersenken.PlayerCreator;

public abstract class GameManager {
	
	public PlayerCreator playerCreator1;
	public PlayerCreator playerCreator2;
	
	public GameManager(PlayerCreator playerCreator1, PlayerCreator playerCreator2) {
		this.playerCreator1 = playerCreator1;
		this.playerCreator2 = playerCreator2;
	}
	
	public abstract void runGame(GameSettings settings);
}
