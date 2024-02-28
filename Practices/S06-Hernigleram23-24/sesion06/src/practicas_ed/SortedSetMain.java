package practicas_ed;


import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

import estdatos.LListSet;
import estdatos.PeekIterator;
import estdatos.PeekingIterator;
import estdatos.SortedLListSet;

public class SortedSetMain {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedLListSet<Integer> s=new SortedLListSet<Integer>();
		s.add(25);
		s.add(30);
		s.add(3);
		s.add(30);
		s.add(5);
		s.add(15);
		System.out.println("s: "+s);	
		System.out.println("s: contiene 0? "+s.contains(0));
	    System.out.println("s: contiene 66? "+s.contains(66));
	    System.out.println("s: contiene 3? "+s.contains(3));
		System.out.println("s: contiene 25? "+s.contains(25));
		
		
		//Redefinir equals y luego descomentar		
		SortedLListSet<Integer> s2=new SortedLListSet<Integer>(s);
		System.out.println("s: equals(s2)? "+s.equals(s2));

		
		
}

	public static <E> void recorreColeccion(Collection<E> c, Consumer<E> cons) {
		 PeekIterator<E> peekIterator = new PeekingIterator<>(c);
	        while (peekIterator.hasNext()) {
	            E element = peekIterator.peek(); 
	            cons.accept(element); 
	            peekIterator.next(); 
	        }
	    }
}

/*******************  SALIDA: **************************
s: [3, 5, 15, 25, 30]
s: contiene 66? false
s: contiene 3? true
s: equals(s2)? true
s: [1, 3, 5, 15, 25, 27, 30, 39, 41]
******************************************************/
