package estdatos;

import java.util.Iterator;
import java.util.List;

/**
 * Tipo de dato abstracto para S-expresiones. Una S-expresión es un dato simple
 * o átomo, o bien, un par de S-expresiones que son el <em>car</em> y el
 * <em>cdr</em> de la primera. Las S-expresions son objetos inmutables.
 */
public interface Sexpr extends Iterable<Sexpr> { // Iterable -> iterator()

	/**
	 * Retorna cierto si esta S-expresión es la lista vacía.
	 * 
	 * @return {@code true} si esta lista está vacía
	 */
	boolean isEmpty();

	/**
	 * Retorna cierto si esta S-expresión es un átomo; es indivisible.
	 * 
	 * @return {@code true} si esta S-expresión es un átomo
	 */
	boolean isAtom();

	/**
	 * Retorna cierto si esta S-expresión es una lista
	 * 
	 * @return {@code true} si esta S-expresión es una lista
	 */
	boolean isList();

	/**
	 * Retorna cierto si esta S-expresión está formada por un par de S-expresiones
	 * que son su <em>car</em> y su <em>cdr</em>
	 * 
	 * @return {@code true} si esta S-expresión es una lista
	 */
	boolean isPair();

	/**
	 * Si esta S-expresión es atómica retorna su información, en caso contrario
	 * retorna {@code this}.
	 * 
	 * @return si esta S-expresión es atómica retorna su información, o {@code this}
	 *         en caso contrario.
	 */
	Object value();

	/**
	 * Retorna el car de esta S-expresión.
	 * 
	 * @return el car de esta S-expresión. Si la S-expresión es una lista,
	 *         {@code (A0 A1 ... An) }, el car es su primer elemento {@code A0}
	 * @throws IllegalStateException si esta S-expresión es un átomo
	 */
	Sexpr car();

	/**
	 * Retorna el cdr de esta S-expresión.
	 * 
	 * @return el cdr de esta S-expresión. Si la S-expresión es un lista,
	 *         {@code (A0 A1 ... An) }, retorna la lista {@code (A1, ..., An)}
	 * @throws IllegalStateException si esta S-expresión es un átomo
	 */
	Sexpr cdr();

	/**
	 * Retorna el número de ítems de una S-expresión que es una lista.
	 * 
	 * @return el número de ítems de una S-expresión que es una lista
	 * @throws UnsupportedOperationException si la S-expresión no es una lista
	 */
	default int size() {

		Iterator<Sexpr> itr = this.iterator();
		if (!this.isList()) {
			throw new UnsupportedOperationException("no es una lista");
		}
		int total = 0;
		while (itr.hasNext()) {
			@SuppressWarnings("unused")
			Sexpr current = itr.next(); // itr.next()
			total++;
		}

		return total;
	}

	/**
	 * Retonar cierto si esta S-expresión es la misma que la S-expresión
	 * especificada.
	 * 
	 * @param sexp la S-expresión dada
	 * @return {@code true} si esta S-expresión es la misma que la especificada
	 */
	default boolean equals(Sexpr sexp) {
		if (this.isAtom() && sexp.isAtom())
			return this.value().equals(sexp.value());
		else if (this.isAtom() && !sexp.isAtom() || 
				!this.isAtom() && sexp.isAtom()) // solo uno es atomo
			return false;

		Iterator<Sexpr> itr1 = this.iterator();
		Iterator<Sexpr> itr2 = sexp.iterator();
		while (itr1.hasNext() && itr2.hasNext())
			if (!itr1.next().equals(itr2.next()))
				return false;

		return itr1.hasNext() == itr2.hasNext();

	}
}
