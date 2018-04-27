package se1.schiffeVersenken.util;

/**
 * A Vector Utility class using <code>int</code>.<br>
 * Every Method creates a new Object, which may not be the most efficient way but it'll be easier for Beginners working on this.
 */
public class Vector2i {
	
	public static final Vector2i NULL_VECTOR = new Vector2i(0, 0);
	
	public final int x;
	public final int y;
	
	public Vector2i(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2i add(Vector2i vec) {
		return new Vector2i(x + vec.x, y + vec.y);
	}
	
	public Vector2i sub(Vector2i vec) {
		return new Vector2i(x - vec.x, y - vec.y);
	}
	
	public Vector2i multiply(int scalar) {
		return new Vector2i(x * scalar, y * scalar);
	}
	
	public Vector2i divide(int scalar) {
		return new Vector2i(x / scalar, y / scalar);
	}
	
	public Vector2i negate() {
		return new Vector2i(-x, -y);
	}
	
	@SuppressWarnings("BooleanMethodIsAlwaysInverted")
	public boolean boundsCheck(Vector2i min, Vector2i max) {
		return min.x <= x && x < max.x && min.y <= y && y < max.y;
	}
	
	@Override
	public String toString() {
		return "{x=" + x + ", y=" + y + "}";
	}
}
