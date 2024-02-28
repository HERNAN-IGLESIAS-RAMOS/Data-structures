package estDatos;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


/**
 * Tipo de dato modificable de conjuntos finitos. Los conjuntos
 * sólo contendrán elementos de un rango dado. Por tanto, el 
 * conjunto universal (tiene todos los elementos posibles) está
 * constituido por todos los valores de dicho rango.
 */
public class FiniteSet<E> extends AbstractSet<E> {
	private Range<E> universal;		// conjunto universal
	private List<Boolean> vbool;	// secuencia de booleanos
	private int numItems;			// número de elementos del conjunto
	
	/**
	 * Crea un conjunto finito para el rango especificado
	 * que contiene los  elementos dados.
	 * @param r el rango asociado
	 * @param items los elementos del conjunto
	 */
	@SafeVarargs
	public FiniteSet(Range<E> r, E...items) {
		// la capacidad de lArrayList<Boolean> es el tamaño del rango
		this.vbool = new ArrayList<>(r.size());
		this.numItems = 0;
		this.universal = r;
		// conjunto vacio: añadir r.size() valores false
		for (int k = 0; k < r.size(); k++) {
			this.vbool.add(false);
		}
		// añadir los elementos de items
		for (E e: items) {
			this.add(e);
		}
		
	}
	
	/**
	 * Crea un conjunto finito copia del especificado.
	 * @param c el conjunto finito a copiar
	 */
	public FiniteSet(FiniteSet<E> c) {

		this.vbool = new ArrayList<>(c.vbool);
		this.numItems = c.numItems;
		this.universal = c.universal;

	}
	
	
	public boolean add(E e) {

		int pos = this.universal.eToInt(e);

		if (this.vbool.get(pos) == false) {
			this.numItems++;
			this.vbool.add(pos, true);
			return true;
		}

		return false;
		
	}
	
	@Override
	public Iterator<E> iterator() {
		
		return new setIterator();
	}
	
	private final class setIterator implements Iterator<E> {
		int current;
		Integer previous;
		
		private setIterator() {
			current = 0;
			previous = null;
			jumpFake();
			
		}

		@Override
		public boolean hasNext() {
			
			
			return current < vbool.size();
		}

		@Override
		public E next() {
			if (!hasNext()) {

				throw new NoSuchElementException();
			}
			
			this.previous=this.current++;
			jumpFake();
			return universal.intToE(this.previous);
			
			
		}
	
		public void remove() {
			
			if(this.previous == null) {
				throw new IllegalStateException();
			}
			vbool.set(this.previous, false);
			numItems--;
			this.previous=null;
		
			
		}
		private void jumpFake() {
			while (this.current < vbool.size() && !vbool.get(this.current)) {
				this.current++;
			}
		}
	
	
	}
	
	@Override
	public int size() {
		
		return numItems;
	}
		
} // class FiniteSet
