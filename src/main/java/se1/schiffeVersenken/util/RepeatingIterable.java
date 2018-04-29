package se1.schiffeVersenken.util;

import java.util.Iterator;

public class RepeatingIterable<T> implements Iterable<T> {
	
	public T[] array;
	
	@SafeVarargs
	public RepeatingIterable(T... array) {
		this.array = array;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			public int index;
			
			@Override
			public boolean hasNext() {
				return true;
			}
			
			@Override
			public T next() {
				if (index >= array.length)
					index = 0;
				return array[index++];
			}
		};
	}
}
