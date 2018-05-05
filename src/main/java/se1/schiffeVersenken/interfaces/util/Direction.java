package se1.schiffeVersenken.interfaces.util;

public enum Direction {
	
	HORIZONTAL(new Position(0, 1)),
	VERTICAL(new Position(1, 0));
	
	public final Position positive;
	public final Position negative;
	
	Direction(Position positive) {
		this.positive = positive;
		this.negative = positive.negate();
	}
	
	public Direction other() {
		switch (this) {
			case HORIZONTAL:
				return VERTICAL;
			case VERTICAL:
				return HORIZONTAL;
		}
		throw new IllegalStateException();
	}
}
