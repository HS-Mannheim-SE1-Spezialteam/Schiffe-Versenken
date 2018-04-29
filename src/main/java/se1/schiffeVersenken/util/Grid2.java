package se1.schiffeVersenken.util;

import java.util.Arrays;

public class Grid2<T> {
	
	private Vector2i size;
	private T[] array;
	
	public Grid2(Vector2i size, T filler) {
		this(size);
		Arrays.fill(array, filler);
	}
	
	@SuppressWarnings("unchecked")
	public Grid2(Vector2i size) {
		this(size, (T[]) new Object[size.x * size.y]);
	}
	
	public Grid2(Vector2i size, T[] array) {
		this.size = size;
		this.array = array;
	}
	
	//internal
	private int getIndex(Vector2i position) {
		if (!position.boundsCheck(Vector2i.NULL_VECTOR, size))
			throw new IllegalArgumentException("Out of Bounds! " + position);
		return position.y * size.x + position.x;
	}
	
	//access
	public T get(Vector2i position) {
		return array[getIndex(position)];
	}
	
	public void set(Vector2i position, T obj) {
		array[getIndex(position)] = obj;
	}
	
	public void set(Vector2i[] position, T obj) {
		int[] index = new int[position.length];
		for (int i = 0; i < position.length; i++)
			index[i] = getIndex(position[i]);
		for (int i : index)
			array[i] = obj;
	}
	
	public T replace(Vector2i position, T obj) {
		int index = getIndex(position);
		T ret = array[index];
		array[index] = obj;
		return ret;
	}
}
