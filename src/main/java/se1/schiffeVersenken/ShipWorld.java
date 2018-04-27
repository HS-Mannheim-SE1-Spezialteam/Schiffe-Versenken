package se1.schiffeVersenken;

public interface ShipWorld extends TileWorld {
	
	Ship[][] getAllShips();
	
	Ship[] getShipsOfLength(int shipLength);
}
