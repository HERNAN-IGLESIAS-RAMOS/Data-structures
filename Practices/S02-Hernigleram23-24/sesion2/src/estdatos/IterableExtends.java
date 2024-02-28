package estdatos;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public interface IterableExtends<T> extends Iterable<T> {

	/**
	 * Realiza la acción especificada con todos los elementos que proporciona el
	 * iterador, uno a uno.
	 * 
	 * @param action la acción a realizar
	 */
	default void forAll(Consumer<? super T> action) {
		// Implementar utilizando un iterador de forma explícita

		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			T current = itr.next();
			// System.out.print(current);
			action.accept(current);
		}

	}

	/**
	 * Realiza la acción especificada con todos los elementos que cumplen el filtro
	 * dado.
	 * 
	 * @param action la acción a realizar
	 * @param filter el filtro proporcionado
	 */
	default void forEachFiltered(Consumer<? super T> action, Predicate<? super T> filter) {
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				action.accept(current);
			}
		}

	}

	/**
	 * Retorna el resultado acumulado de aplicar la función especificada a los
	 * elementos que proporciona el iterador, uno a uno.
	 * 
	 * @param f la función dada
	 * @return si {@code A0, A1, A2, ...An-1} son los ítems que proporciona el
	 *         iterador, el valor de {@code f(...f(f(A1, f(A0)), A2), An-1) }
	 * @throws IllegalStateException si este objeto iterable está vacío (el iterador
	 *                               no tiene ítems que proporcionar)
	 */
	default T reduceAll(BiFunction<T, T, T> f) {
		// Implementar utilizando un iterador de forma explícita

		Iterator<T> itr = iterator();

		if (!itr.hasNext()) {
			throw new IllegalStateException("esta vacío");
		}

		T acumulado = itr.next();
		while (itr.hasNext()) {
			T current = itr.next();
			acumulado = f.apply(acumulado, current);
			// acumulado = f.apply(acumulado,itr.next());
		}
		return acumulado;
	}

	/**
	 * Retorna el resultado acumulado de aplicar la función especificada a los
	 * elementos que cumplen el filtro dado.
	 * 
	 * @param f      la función dada
	 * @param filter el filtro especificado
	 * @return si {@code a, b, c, ..., k} son los elementos que proporcina el
	 *         iterador y cumplen el filtro dado, el valor
	 *         {@code f(...f(f(b, f(a)), c), k) }
	 * @throws IllegalStateException si este objeto iterable está vacío (el iterador
	 *                               no tiene ítems que proporcionar) o ningún ítem
	 *                               cumple el filtro dado
	 */
	default T reduceFiltered(BiFunction<T, T, T> f, Predicate<? super T> filter) {
		// Implementar utilizando un iterador de forma explícita
		Iterator<T> itr = iterator();

		if (!itr.hasNext()) {
			throw new IllegalStateException("esta vacío");
		}
		T acumulado = null;

		while (itr.hasNext() && acumulado == null) {
			T current = itr.next();
			if (filter.test(current)) {
				acumulado = current;
			}
		}
		if (!itr.hasNext()) {
			throw new IllegalStateException();
		}
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				acumulado = f.apply(acumulado, current);
				// acumulado = f.apply(acumulado,itr.next());
			}
		}
		return acumulado;
	}

	/**
	 * Elimina todos los ítems de este objeto iterable, lo deja vacío.
	 * 
	 * @throws UnsupportedOperationException si esta operación no está soportada
	 */
	default void removeAll() {

		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			T current = itr.next();
			itr.remove();
		}
	}

	/**
	 * Elimina de este objeto iterable todos los ítems que cumplen el filtro
	 * especificado.
	 * 
	 * @param filter el filtro dado
	 * @throws UnsupportedOperationException si esta operación no está soportada
	 */
	default void removeFiltered(Predicate<? super T> filter) {

		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				itr.remove();
			}
		}
	}

}
