package estdatos;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class LListSet<E> extends AbstractSet<E> implements Set<E> {

	public List<E> data;

	public LListSet() {
		this.data = new LinkedList<>();
	}

	public LListSet(Collection<? extends E> c) {
		this();
		addAll(c);
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public Iterator<E> iterator() {
		return data.iterator();
	}

	@Override
	public boolean add(E e) {
		if (!contains(e)) {
			data.add(e);

			return true;
		}
		return false;
	}

}
