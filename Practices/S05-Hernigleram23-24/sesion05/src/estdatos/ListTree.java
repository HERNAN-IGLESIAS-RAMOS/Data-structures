package estdatos;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 * Tipo de dato modificable para árboles ordenados.
 * 
 * @param <E> el tipo de las etiquetas de los nodos
 */
public class ListTree<E> extends AbstractTree<E> {

	// area de datos en la implementacion
	private E labelRoot;
	private List<Tree<E>> children;
	private Tree<E> parent;

	/**
	 * Crea un árbol cuyo nodo raíz se etiqueta como se especifica y que tiene por
	 * hijos los nodos raíz de lo árboles especificados.
	 * 
	 * @param e     la etiqueta de la raíz de este árbol
	 * @param trees los árboles cuyas raíces son los nodos hijo de la raíz de este
	 *              árbol (trees es un array de árboles)
	 */
	@SafeVarargs
	public ListTree(E e, Tree<E>... trees) {
		// guardar e en laberroot
		// poner que no tengo padre
		// crear la lista (inicialmente vacia)
		// meter en la lista una copia de cada arbol de trees
		// poner de el padre de cada copia soy yo

		this.labelRoot = e;
		this.parent = null;
		this.children = new LinkedList<>();

		for (Tree<E> t : trees) { // forma mas sencilla de hacerlo, tambien se puede for(int
									// i=0;i<trees.length();i++)...trees[i]
			ListTree<E> child = new ListTree<>(t);
			child.parent = this;
			children.add(child);

		}

	}

	/**
	 * Constructor de conversión. Crea un árbol de esta clase e igual al árbol
	 * especificado.
	 * 
	 * @param t el árbol dado
	 */
	public ListTree(Tree<E> t) {
		// mi etiqueta como la de t (raiz de t)
		// no tengo padre
		// creo la lsita de hijos
		// recorro la lista de hijos y meto una copia en la lista
		// el padre de la copia soy yo
		this.labelRoot = t.label();
		this.parent = null;
		this.children = new LinkedList<>();

		ChildrenIterator<Tree<E>> itr = t.childrenIterator();
		while (itr.hasNext()) {
			ListTree<E> current = new ListTree<>(itr.next());
			current.parent = this;
			this.children.add(current);
		}
	}

	@Override
	public boolean isLeaf() {
		return children.isEmpty();
	}

	@Override
	public E label() {
		return labelRoot;
	}

	@Override
	public ChildrenIterator<Tree<E>> childrenIterator() {
		return new miIterador(); // return childre.iterator() hasnext, next, remove no vale!!! HAY QUE CREAR UNO
									// return chidre.listIterator() no vale!!!

	}

	protected class miIterador implements ChildrenIterator<Tree<E>> {
		ListIterator<Tree<E>> itr = children.listIterator();

		@Override
		public boolean hasNext() {
			return itr.hasNext();
		}

		@Override
		public Tree<E> next() {

			return itr.next();
		}

		@Override
		public void remove() {
			itr.remove();
		}

		@Override
		public void set(Tree<E> e) {
			// copia arbol
			// padre arbol donde estoy
			// itr.set lo meto
			ListTree<E> current = new ListTree<>(e);
			current.parent = ListTree.this; // hay que poner ListTree porque estoy en una clase interna
			itr.set(current);
		}

		@Override
		public void add(Tree<E> e) {
			ListTree<E> current = new ListTree<>(e);
			current.parent = ListTree.this; // hay que poner ListTree porque estoy en una clase interna
			itr.add(current);
		}

	}

	// setLabel tenemos que añadirlo nosotros porque es mutable
	@Override
	public void setLabel(E e) {
		labelRoot = e;
	}

}
