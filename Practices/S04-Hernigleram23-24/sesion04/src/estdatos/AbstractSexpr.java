package estdatos;

import java.util.Iterator;
import java.util.Objects;

public abstract class AbstractSexpr implements Sexpr {

	final static Object NULL = new Object();

	@Override
	public String toString() {
		StringBuilder out = new StringBuilder("(");
		Iterator<?> itr = this.iterator();
		if (itr.hasNext()) { // primer ítem de la lista
			out.append(itr.next().toString());
		}
		while (itr.hasNext()) {
			out.append(' ');
			out.append(itr.next().toString());
		}
		out.append(')');

		return out.toString();
	}

	@Override
	public int hashCode() {
		if (this.isEmpty()) {
			return Objects.hash(NULL);
		}

		return Objects.hash(this.car(), this.cdr());
	}

	@Override
	public boolean equals(Object obj) {
		// rellenar

		if (this == obj)
			return true;
		if (!(obj instanceof Sexpr))
			return false;
		Sexpr other = (Sexpr) obj;
		return this.equals(other);

	}



}
