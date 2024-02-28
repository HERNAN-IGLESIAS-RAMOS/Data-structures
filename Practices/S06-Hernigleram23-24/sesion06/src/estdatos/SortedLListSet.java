/**
 * 
 */
package estdatos;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class SortedLListSet<E> extends LListSet<E> {
	protected Comparator<? super E> cmp;

	// constructores

	public SortedLListSet() {
		super();
		this.cmp = null; // si no pones nada, por defecto lo declara a null
	}

	public SortedLListSet(Collection<? extends E> c) {

		super(c);
		this.cmp = null; // si no pones nada, por defecto lo declara a null
	}

	public SortedLListSet(Comparator<? super E> cmp) {
		this();
		this.cmp = cmp;
	}

	public SortedLListSet(Collection<? extends E> c, Comparator<? super E> cmp) {

		/*super(c)
		cmp=cmp        MAL PORQUE EL CMP ES COMO SI FUERA NULO */
		this();
		cmp = cmp;
		addAll(c);

	}

	@SuppressWarnings("unchecked")
	private int compare(Object a, Object b) {
		if (cmp == null && !(a instanceof Comparable<?>)) {
			throw new ClassCastException();
		}

		return cmp == null ? ((Comparable<? super E>) a).compareTo((E) b) : cmp.compare((E) a, (E) b);
	}

	@Override
	public boolean add(E e) {

		ListIterator<E> itr = data.listIterator();
		while (itr.hasNext()) {
			E current = itr.next();
			int x = compare(current, e);
			if (x == 0) {
				return false; 
			}  if (x > 0) {
				itr.previous();
				itr.add(e);
				return true;
			}
		}

		itr.add(e); //también vale data.add(e)
		return true;
	} 
	
	@SuppressWarnings("unchecked")
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj instanceof SortedLListSet) {
			SortedLListSet<E> other = (SortedLListSet<E>) obj;
			if (this.size() != other.size()) {
				return false;
			}
			Iterator<E> it1 = this.iterator();
			Iterator<E> it2 = other.iterator();
			while (it1.hasNext()) {
				E e1 = it1.next();
				E e2 = it2.next();
				if (compare(e1, e2) != 0) {
					return false;
				}
			}
			return true;
		}
		return false;
	}

}
