package estDatos;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class SortedSet<E> extends SetNoMod<E> {
	private Comparator<? super E> cmp;

	public SortedSet(Collection<? extends E> c) {
		super();
		this.cmp = null;
		c.forEach(item -> this.addItem(item));
		
		
	}

	public SortedSet(Collection<? extends E> c, Comparator<E> cmp) {
		
		super();
		this.cmp = cmp;
		for (E item: c) {
			this.addItem(item);
		}
		
		

	}

	public SortedSet(Comparator<E> cmp, E... e) {

		super();
		this.cmp = cmp;
		for (E item: e) {
			this.addItem(item);
		}
	}

	public SortedSet(E... e) {
		super();
		this.cmp = null;
		for (E item: e) {
			this.addItem(item);
		}
	
	}
	private void addItem(E item) {
		
		ListIterator<E> itr = data.listIterator();
		
		
		
		
		while(itr.hasNext()) {
			
			E current =  itr.next();
			
			if(current.equals(item)) {
				return;
			}
			int x = this.micompare(current, item);
			if(x>0) {
				itr.previous();
				itr.add(item);
				return;
			}
			
			
		}
		itr.add(item);
		
		
		
	}
	
	private int micompare(final E a, final E b) {
		if(this.cmp == null && !(a instanceof Comparable<?>)) {
			throw new ClassCastException(
					String.format("El tipo %s no es comparable", a.getClass().getName()));
			
		}
		return cmp == null ? ((Comparable<E>) a).compareTo(b) : this.cmp.compare(a, b);
	

	}
}
