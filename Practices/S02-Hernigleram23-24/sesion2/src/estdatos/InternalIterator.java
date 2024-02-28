package estdatos;

import java.util.Iterator;

public class InternalIterator<T> implements IterableExtends<T> {

	Iterable<T> objetoiterable;

	public InternalIterator(Iterable<T> obj) {
		this.objetoiterable = obj;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return objetoiterable.iterator();
	}

}
