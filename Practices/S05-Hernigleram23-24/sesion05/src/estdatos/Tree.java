package estdatos;

public interface Tree<E> {

	/**
	 * Retorna cierto si la raíz de este árbol es una hoja
	 * 
	 * @return {@code true} si la raíz de este árbol es una hoja
	 */
	boolean isLeaf();

	/**
	 * Retorna la etiqueta de la raíz de este árbol.
	 * 
	 * @return la raíz del árbol
	 */
	E label();
	
	/**
	 * Iterador de los subárboles hijos de la raíz de este árbol.
	 * 
	 * @return un iterador de los nodos hijos de la raíz de
	 * este árbol
	 */
	ChildrenIterator<Tree<E>> childrenIterator();

	/**
	 * Cambia la etiqueta de la raíz de este árbol al objeto
	 * especificado (operación opcional).
	 * 
	 * @param e la nueva etiqueta de la raíz
	 * @throws UnsupportedOperationException si la operación
	 * no está soportada por este árbol.
	 * @throws NullPointerException si este árbol no admite etiquetas
	 * de valor {@code null}
	 */
	default void setLabel(E e) {
		throw new UnsupportedOperationException();
	}
	
	default public boolean equals(Tree<E> t) { //default utilizar los metodos de la interfaz
		if (!label().equals(t.label())) {
			return false;
		}
		
		ChildrenIterator<Tree<E>> itrThis = childrenIterator();
		ChildrenIterator<Tree<E>> itrT = t.childrenIterator();
		while (itrThis.hasNext() && itrT.hasNext()) {
			if (!itrThis.next().equals(itrT.next())) {
				return false;
			}
		}
		
		return itrThis.hasNext() == itrT.hasNext();
	}
}