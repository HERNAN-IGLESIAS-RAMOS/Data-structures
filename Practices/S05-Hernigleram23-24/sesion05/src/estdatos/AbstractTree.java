// abstracta, implementacion es donde pongo el equals (mejor en la abstracta)
package estdatos;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractTree<E> implements Tree<E> {

	private String childrenList() {
		List<E> l = new LinkedList<>();
		ChildrenIterator<Tree<E>> itr = childrenIterator();
		while (itr.hasNext()) {
			l.add(itr.next().label());
		}

		return l.toString();
	}

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder();
		out.append(label().toString());
		out.append(": ");
		out.append(childrenList());
		out.append('\n');

		ChildrenIterator<Tree<E>> itr = childrenIterator();
		while (itr.hasNext()) {
			Tree<E> child = itr.next();
			if (child.childrenIterator().hasNext()) {
				out.append(child.toString());
			}
		}

		return out.toString();
	}

	@Override
	public boolean equals(Object obj) { // siempre igual
		if (this == obj)
			return true;
		// SI DICE ALGO DE LOS NULL
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Tree))
			return false;
		Tree<E> other = (Tree<E>) obj;
		// delegamos en el otro equals, el de la interfaz (default)
		return this.equals(other);
	}
}
