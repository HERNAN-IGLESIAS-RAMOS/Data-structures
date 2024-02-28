package estDatos;

import java.util.Comparator;
import java.util.Iterator;

public class SortedBag<E> extends BagMod<E> {

	private Comparator<? super E> cmp;
    
	public SortedBag() {
        super();
        this.cmp = null;
    }
	
	
	public SortedBag(final Comparator<? super E> cmp) {
        super();
        this.cmp = cmp;
    }
	public SortedBag(final int capacidad) {
        super(capacidad);
        this.cmp = null;
        
    }
	public SortedBag(final int capacidad, final Comparator<? super E> cmp) {
        super(capacidad);
        this.cmp = cmp;
        
    }
	
	
	public boolean add(final E e) {
        
		Iterator<E> itr = iterator();
		if (e == null) {
            throw new NullPointerException();
        }
        while(itr.hasNext()) {
        	
        	E elemento = itr.next();
        	
        	
        	
        

      
         }
        return true;
	}
	
	private int position(final E e) {
		int index = 0;
		for(E item: this) {
			if(this.micompare(e,item)<0) {
				return index;
			}
		  index++;
		}
		return index;
		
//		Iterator<E> itr = this.iterator();
//		while(itr.hasNext()) {
//			E item = itr.next();
//			index ++;
//			if(this.micompare(e,item)<0) {
//				
//				return index;
//			}
//		}
		
	}
	private int micompare(final E a, final E b) {
		if(this.cmp == null && !(a instanceof Comparable<?>)) {
			throw new ClassCastException(
					String.format("El tipo %s no es comparable", a.getClass().getName()));
			
		}
		return cmp == null ? ((Comparable<E>) a).compareTo(b) : this.cmp.compare(a, b);
	}
}
