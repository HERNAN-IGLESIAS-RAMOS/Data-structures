package estdatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListBag<E> extends AbstractCollection<E> {

	protected List<E> data;

	public ListBag() {

		this.data = new LinkedList<>();
	}

	// CONSTRUCTOR DE ADAPTACION/CONVERSION
	public ListBag(Collection<? extends E> c) {
		this();
		addAll(c); //esto es para mutables
		//data.addAll(c);
		// this.data = new LinkedList<>(c);
		// this.data = new LinkedList<>(c.data);
	}

	@Override
	public Iterator<E> iterator() {
		return this.data.iterator();
	}

	@Override
	public int size() {
		return this.data.size();
	}

	@Override
	public boolean add(E e) {
		if(e == null) {
			throw new IllegalArgumentException();
		}
		return this.data.add(e);
	}

}
