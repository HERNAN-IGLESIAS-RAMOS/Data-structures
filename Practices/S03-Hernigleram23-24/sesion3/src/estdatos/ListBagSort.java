package estdatos;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;

public class ListBagSort<E> extends ListBag<E> {

	Comparator<? super E> cmp;

	public ListBagSort() {
		super();
		cmp = null;
	}

	public ListBagSort(Collection<? extends E> c) {
		super(c);
		cmp = null;
	}

	public ListBagSort(Comparator<? super E> elcmp) {

		super();
		cmp = elcmp;
	}

	public ListBagSort(Collection<? extends E> c, Comparator<? super E> elcmp) {
		this();
		this.cmp = elcmp;
		addAll(c);
	}

	@SuppressWarnings("unchecked")
	public int compare(E a, E b) { // miComparador
		return cmp == null ? ((Comparable<E>) a).compareTo(b) : cmp.compare(a, b);
	}

	@Override
	public boolean add(E e) {

		ListIterator<E> itr = this.data.listIterator();
		while (itr.hasNext()) {

			E current = itr.next();
			// if (((Comparable<E>) current).compareTo(e) > 0) {
			if (this.compare(current, e) > 0) { // inserta

				itr.previous();
				itr.add(e);
				return true;
			}
		}

		itr.add(e);
		return true;
		// return data.add(e); mete por el final
	}

}
