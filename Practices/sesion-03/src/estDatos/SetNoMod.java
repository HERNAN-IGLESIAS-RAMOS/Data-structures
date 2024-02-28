package estDatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SetNoMod<E> extends AbstractCollection<E> {

	protected LinkedList<E> data;

	public SetNoMod() {
		this.data = new LinkedList<>();
	}

	public SetNoMod(Collection<? extends E> c) {

		if (c instanceof SetNoMod) {
			SetNoMod<E> other = (SetNoMod<E>) c;

			this.data = other.data;
		}

		else {
			this.data = new LinkedList<>(c);
			c.forEach(item -> {
				if (!this.data.contains(item)) {
					this.data.add(item);
				}
			});
		}
	}

	public SetNoMod(E... e) {

		this.data = new LinkedList<>();

		for (E elemento : e) {
			if (!this.data.contains(elemento)) {
				this.data.add(elemento);
			}
		}

	}

	@Override
	public Iterator<E> iterator() {
		return new SetNoModIterator();

	}

	private final class SetNoModIterator implements Iterator<E> {
		private Iterator<E> itr ;

		
		private SetNoModIterator() {
			this.itr=data.iterator();
		}
		@Override
		public boolean hasNext() {

			return itr.hasNext();
		}

		@Override
		public E next() {
			

			return itr.next();
		}

	}

	@Override
	public int size() {

		return data.size();

	}

}
