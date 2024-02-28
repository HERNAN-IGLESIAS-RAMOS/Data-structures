package estDatos;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class LPCHash<E> extends AbstractSet<E> implements Set<E> {
	private E[] table;
	private int[] status;
	private int tablesize;
	private double loadFactorLimit;
	private int elements;
	private int deleted;
	
	
	
	public LPCHash() {
		this(11,0.5);
	}
	public LPCHash(int initialCapacity) {
		this(initialCapacity, 0.5);
	}
	@SuppressWarnings("unchecked")
	public LPCHash(int initialCapacity , double theLoadFactor) {
		this.tablesize = initialCapacity;
		this.loadFactorLimit = theLoadFactor;
		this.elements = 0;
		this.deleted = 0;
		table = (E[]) new Object[tablesize];
		status = new int[tablesize];
		
		for(int i = 0 ; i< tablesize; i++) {
			status[i] = 0;
		}
		
	}
	public LPCHash(Collection<? extends E> c) {
		this();
		this.addAll(c);
	}
	
	private int hash(E e) {
		return e.hashCode()%tablesize;
	}
	
	private int rehash(E e, int col) {
		return (hash(e)+col)%tablesize;
	}
	
	private void resize(int newCapacity) {
		LPCHash<E> aux = new LPCHash<E>(newCapacity);
		for(int i = 0; i< tablesize; i++) {
			if(status[i]==2)
				aux.add(table[i]);
		}
		tablesize = newCapacity;
		table = aux.table;
		status = aux.status;
		deleted = aux.deleted;
		elements = aux.elements;
	}
	
	private int firtsEqualEmpty(E e) {
		int pos = hash(e);
		int colisiones = 0;
		while(colisiones<tablesize) {
			if((status[pos] == 2 && !e.equals(table[pos]))
					|| status[pos] == 1) {
			
				colisiones++;
				pos = rehash(e,colisiones);
				
			}
			
			else {
				return pos;
		}	
	}
		throw new RuntimeException("Fuera de rango");
	}
	private int firstEraseEmpty(E e) {
		int pos = hash(e);
		int colisiones = 0;
		while(colisiones<tablesize) {
			if(status[pos]==2) {
				colisiones++;
				pos = rehash(e,colisiones);
			}
			else
				return pos;
		}
		throw new RuntimeException("Fuera de rango");
	}
	
	@SuppressWarnings("unchecked")
	public boolean contains(Object o) {
		if(status[firtsEqualEmpty((E)o)]==0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean add(E e) {
		if(contains(e)) {
			return false;
		}
		double load = (elements + deleted) / (double)tablesize;
		if(load >= loadFactorLimit) {
			resize(2* tablesize +1 );
		}
		int pos = firstEraseEmpty(e);
		table[pos] = e;
		if ( status[pos] == 1) {
			deleted--;
		}
		status[pos] = 2;
		elements ++;
		return true;
	}
	@Override
	public boolean remove(Object o) {
		@SuppressWarnings("unchecked")
		int pos = firtsEqualEmpty((E)o);
		if(status[pos] != 0) {
			status[pos] = 1;
			elements--;
			deleted++;
			return true;
		}
		return false;
	}
	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return new miIterador();
	}
	private class miIterador implements Iterator<E>{
		private int currentPos; // posicion el elemento que retornara next()
		private int traversed; // numero de elementos obrenidos con el iterador
		private E lastReturned; // ultimo elemento retornado por next()
		
		private void nextPosition() {
			currentPos++;
			while(currentPos < tablesize && status[currentPos] != 2) {
				currentPos++;
			}
		}
		public miIterador() {
			traversed = 0;
			lastReturned = null;
			currentPos = -1;
			nextPosition();
		}
		@Override
		public boolean hasNext() {
			
			return traversed < elements;
		}
		@Override
		public E next() {
			
			if(!hasNext()) {
				throw new NoSuchElementException();
			
			}
			traversed++;
			lastReturned = table[currentPos];
			nextPosition();
			return lastReturned;
		}
		public void remove(){
			if(lastReturned == null) {
				throw new NoSuchElementException();
			}
			LPCHash.this.remove(lastReturned);
			traversed--;
			lastReturned = null;
		}
		
	}
	@Override
	public int size() {
		return this.table.length;
	}
	public String toPrint() {
		for(int i = 0; i< this.size(); i++) {
			if(status[i]==2) 
			System.out.println(i+ ": " +this.table[i]);
			else
			System.out.println(i+ ": ");
		}
	return "";
	}
}
