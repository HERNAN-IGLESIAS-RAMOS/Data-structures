package estdatos;

import java.util.Iterator;

public class InternalIterator<T> implements IterableExtends<T> {
	private Iterable<T> iterable;
	
	public InternalIterator(Iterable<T> it) {
		iterable = it;
	}

	@Override
	public Iterator<T> iterator() {
		return iterable.iterator();
	}

}
