package estDatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

public class OpenHash<E> extends AbstractSet<E> implements Set<E> {
	private ArrayList<TreeSet<E>> table;
	private int elements;
	private int tablesize;
	private double loadFactorLimit;
	private LinkedList<E> elemList;
	
	public OpenHash() {
		this(11,0.75);
	}
	public OpenHash(int initialCapacity) {
		this(initialCapacity,075);
	}
	
	public OpenHash(int initialCapacity, double theLoadFactor) {
		
		
		loadFactorLimit=theLoadFactor;
		tablesize = initialCapacity;
		elements=0;
		table = new ArrayList<>(initialCapacity);
		for(int i=0; i<tablesize; i++) {
			table.add(i,new TreeSet<E>());
		}
		
		elemList = new LinkedList<E>();
	}
		
	public OpenHash(Collection<? extends E>c) {
		this();
		this.addAll(c);
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return new MiIterador();
	}
	
	private class MiIterador implements Iterator<E>{
		
		private Iterator<E> itr;
		
		public MiIterador() {
			itr = elemList.iterator();
		}
		
		@Override
		public boolean hasNext() {
			
			return itr.hasNext();
		}

		@Override
		public E next() {
			
			return itr.next();
		}

		

		@Override
		public void remove() {
			
			throw new UnsupportedOperationException();
		}

		
		
	}
		
	
	@Override
	public int size() {
		
		return table.size();
	}
	@Override
	public boolean add(E e) {
		
		if(contains(e))
			return false;
		if((elements/(float)tablesize)>=loadFactorLimit)
			resize(tablesize*2+1);
		
		int pos = hash(e);
		table.get(pos).add(e);
		elemList.add(e);
		elements++;
		return true;
		
		
	}
	@Override
	public boolean contains(Object o) {
	
		int hash = hash((E) o);
		

		
		return table.get(hash).contains(o);
	}
	public boolean remove(Object o) {
		int pos = hash((E)o);
		boolean borrado = table.get(pos).remove(o);
		if(borrado) {
			elemList.remove(o);
			elements--;
		}
		return borrado;
	}
	private void resize(int newCapacity) {
		OpenHash<E> aux = new OpenHash<E>(newCapacity);
		for(E elem: elemList) {
			aux.add(elem);
		}
		tablesize = newCapacity;
		table = aux.table;
	}
	
	private int hash(E e) {
		return e.hashCode()%tablesize;
	}
	public String printTable() {
		for(int i = 0; i<this.size(); i++) {
			System.out.println(i+ ": " +this.table.get(i));
		}
		return "";
	}
}
