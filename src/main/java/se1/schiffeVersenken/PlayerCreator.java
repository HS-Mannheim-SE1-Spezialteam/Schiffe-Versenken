package se1.schiffeVersenken;

@FunctionalInterface
public interface PlayerCreator {
	
	Player createPlayer(GameSettings settings);
}
