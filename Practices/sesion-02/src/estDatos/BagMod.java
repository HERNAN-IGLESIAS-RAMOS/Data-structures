package estDatos;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Los objetos del tipo modificable {@code BolsaMod<E>} son bolsas
 * de elementos. Las bolsas no pueden contener el valor {@code null}.
 *
 * @param <E> el tipo de los elementos de la bolsa
 */
public class BagMod<E> extends AbstractCollection<E> {

    /**
     * Capacidad de almacenamiento mínima.
     */
    private static final int MIN_CAPACITY = 10;

    /**
     * Espacio de almacenamiento para los elementos de esta bolsa
     * (un vector).
     */
    protected E[] data;

    /**
     * Número de elementos de la bolsa.
     */
    protected int numItems;

    /**
     * Crea una bolsa vacía de capacidad mínima.
     */
    public BagMod() {
        this(MIN_CAPACITY);
    }

    /**
     * Crea una bolsa vacía de la capacidad especificada.
     *
     * @param capacity la capacidad inicial de la bolsa
     */
    @SuppressWarnings("unchecked")
    public BagMod(final int capacity) {
        this.data = (E[]) new Object[Math.max(capacity, MIN_CAPACITY)];
        this.numItems = 0;
    }

    /**
     * Crea una bolsa con los elementos de la colección especificada.
     *
     * @param c la colección que tiene los elementos que contendrá la
     * bolsa
     */
    public BagMod(final Collection<? extends E> c) {
        this(c.size());
        this.addAll(c);
    }

    /**
     * Retorna un iterador sobre los elementos de esta bolsa.
     *
     * @return un iterador para esta bolsa
     */
    @Override
    public Iterator<E> iterator() {
    	return new BolsaIterator();	// completar
    }
    
    
    
    
    
	// ITERADOR INTERNO
	private final class BolsaIterator implements Iterator<E> {
		private int actual ;
		
		private boolean opNext;
		// para saber si podemos borrar

		public boolean hasNext() {

			return actual < numItems;

		}
		
		private BolsaIterator() {
			this.actual = 0;
			this.opNext = false;
		}
		
		public E next() {

			if (!hasNext()) {

				throw new NoSuchElementException();
			}

			E temp = data[actual];
			this.actual++;
			this.opNext = true;
			//indicamos que hemos hecho next() y ya podemos borrar
			return temp;

		}
		
		
		public void remove() {
			
			if(!opNext) {
				throw new IllegalStateException();
				
			}
			
			this.opNext = false;
			System.arraycopy(data, this.actual, data, this.actual -1, numItems - this.actual);
			numItems--;
			this.actual--;
			
		}

	}
    
    
    
    
    
    
    
    
    
    
    /**
     * Retorna el número de elementos de esta bolsa.
     *
     * @return el número de elementos de esta bolsa
     */
    @Override
    public int size() {
        return this.numItems;
    }

    /**
     * Duplica la capacidad del espacio de almacenamiento.
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        int oldCapacity = this.data.length;
        E[] temp = (E[]) new Object[2 * oldCapacity];

        System.arraycopy(this.data, 0, temp, 0, oldCapacity);
        this.data = temp;
    }

    /**
     * Añade el elemento especificado a esta colección.
     *
     * @param e el elemento a añadir
     * @return true
     * @throws NullPointerException si e es null
     */
    @Override
    public boolean add(final E e) {
        if (e == null) {
            throw new NullPointerException();
        }

        if (numItems == this.data.length) {
            resize();
        }

        this.data[this.numItems++] = e;

        return true;
    }

}
