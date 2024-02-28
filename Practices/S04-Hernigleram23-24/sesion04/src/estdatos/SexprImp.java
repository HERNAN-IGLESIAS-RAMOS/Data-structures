package estdatos;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Tipo de dato cuyas instancias son listas multinivel. Los objetos 
 * de este tipo son inmutables.                                                         
 */
public class SexprImp extends AbstractSexpr {
	
	private Sexpr car; // car de sexpr
	private Sexpr cdr; // cdr de esxpr
	private static int size; // numero de items de la lista multinivel
	
	private final static class Atom extends SexprImp {
		private Object data;		// información de las S-expresiones atómicas
		
		private Atom(Object o) {
			this.data = o;
		}
		
		@Override
		public boolean isEmpty() {
			return false;
		}
		
		@Override
		public boolean isAtom() {
			return true;
		}

		@Override
		public boolean isList() {
			return false;
		}

		@Override
		public boolean isPair() {
			return false;
		}

		@Override
		public Object value() {
			return data;
		}

		@Override
		public Sexpr car() {
			throw new IllegalStateException();
		}
		
		@Override
		public Sexpr cdr() {
			throw new IllegalStateException();
		}
		
		@Override
		public Iterator<Sexpr> iterator() {
			throw new UnsupportedOperationException();
		}
		
		
		
		@Override
		public int size() {
			// TODO Auto-generated method stub
			return size;
		}

		@Override
		public String toString() {
			return data.toString();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			
			if (!(obj instanceof Atom)) {
				return false;
			}
			
			Atom other = (Atom)obj;
			return data.equals(other.data);
		}

		@Override
		public int hashCode() {
			return data.hashCode();
		}		
				
	} // class Atom
	
	/**
	 * Crea una lista que tiene por ítems los objetos
	 * especificados, según el orden en que estos se proporcionan.
	 * Los objetos que no sean S-expresiones se añadiran
	 * a la lista como S-expresiones atómicas.
	 * @param o los ítems de la lista (array de Object)
	 */
	@SafeVarargs
	public SexprImp(Object...objs) {
		this.size = 0;
		if (objs.length > 0) {
			this.car = objs[0] instanceof Sexpr ? (Sexpr)objs[0]
										     : new Atom(objs[0]);
			Sexpr current = new SexprImp();
			for (int k = objs.length - 1; k > 0; k--) {
				current = new SexprImp(objs[k], current);
			}
			this.cdr = current;
			this.size = current.size() + 1;
		}
	}

	/**
	 * Crea una lista con los mismos ítems que la S-expresión
	 * especificada (constructor de conversión).
	 * @param sexp la S-expresión dada
	 */
	public SexprImp(Sexpr sexp) {
		SexprImp other;
		if (sexp instanceof SexprImp) { // tipos inmutables
			other = (SexprImp)sexp;
		} else {
			other = sexp.isEmpty() ? new SexprImp()
					               : new SexprImp(sexp.car(),
					                		      sexp.cdr());
		}
		this.car = other.car;
		this.cdr = other.cdr;
		this.size = other.size;
	}
	
	/**
	 * Crea una lista que como primer ítem (su car) tiene el
	 * objeto especificado y que si no es una S-expresión se
	 * añadirá como S-expresión atómica. El resto de ítems de
	 * la lista (su cdr) son los de la S-expresión dada, que
	 * deberá ser una lisa
	 * @param car el car de esta lista
	 * @param cdr el cdr de esta lista
	 * @throws IllegalArgumentException si la S-expresión
	 * {@code cdr} no es una lista
	 */
	public SexprImp(Object car, Sexpr cdr) {
		if (!cdr.isList()) {
			throw new IllegalArgumentException();
		}
		
		this.car = car instanceof Sexpr ? (Sexpr)car
										: new Atom(car);
		this.cdr = new SexprImp(cdr);
		this.size = 1 + cdr.size();
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean isAtom() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isList() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isPair() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object value() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public Sexpr car() { // excepcion si es vacio
		// TODO Auto-generated method stub
		return car;
	}

	@Override
	public Sexpr cdr() { //excepcion si es vacio
		// TODO Auto-generated method stub
		return cdr;
	}

	@Override
	public Iterator<Sexpr> iterator() {
		// TODO Auto-generated method stub
		return new miIterador();
		
		
	}
	
	private class miIterador implements Iterator<Sexpr> {

		Sexpr current = SexprImp.this;
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return !current.isEmpty();
		}

		@Override
		public Sexpr next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			Sexpr car = current.car();
			current = current.cdr();
			return car;
		}
		
	}


}
