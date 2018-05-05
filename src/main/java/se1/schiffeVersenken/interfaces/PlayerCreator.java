package se1.schiffeVersenken.interfaces;

@FunctionalInterface
public interface PlayerCreator {
	
	Player createPlayer(GameSettings settings);
}
