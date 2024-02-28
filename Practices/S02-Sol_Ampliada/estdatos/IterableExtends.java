package estdatos;

import java.util.Iterator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface IterableExtends<T> extends Iterable<T> {
	
	/**
	 * Realiza la acción especificada con todos los ítems que
	 * proporciona el iterador de este iterable.
	 * @param action la acción a realizar
	 */
	default void forAll(Consumer<? super T> action) {
		// forEach(action); es equivalente
		Iterator<T> itr = iterator();		
		while (itr.hasNext()) {
			action.accept(itr.next());
		}
	}
	
	/**
	 * Realiza la acción especificada con el resultado de aplicar
	 * la función dada a cada ítem proporcionado por el iterador
	 * de este iterable
	 * @param action la acción a realizar
	 * @param f la función que se aplica a los ítems
	 */
	default <R> void forAll(Consumer<? super R> action, Function<T, R> f) {
		// forEach(action); es equivalente
		Iterator<T> itr = iterator();		
		while (itr.hasNext()) {
			action.accept(f.apply(itr.next()));
		}
	}
	
	/**
	 * Realiza la acción especificada con todos los ítems de este
	 * iterable que cumplen el filtro dado.
	 * @param action la acción a realizar
	 * @param filter el filtro proporcionado
	 */
	default void forEachFiltered(Consumer<? super T> action,
			    				 Predicate<? super T> filter) {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				action.accept(current);
			}
		}
	}

	/**
	 * Realiza la acción especificada con todos los ítems de este
	 * iterable que cumplen el filtro dado tras aplicar a éstos la
	 * función dada.
	 * @param action la acción a realizar
	 * @param filter el filtro proporcionado
	 * @param f la función que se aplica a los ítems
	 */
	default <R> void forEachFiltered(Consumer<? super R> action,
			    				 	 Predicate<? super R> filter,
			    				 	 Function<T, R> f) {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			R current = f.apply(itr.next());
			if (filter.test(current)) {
				action.accept(current);
			}
		}
	}
	
	/**
	 * Retorna el resultado acumulado de aplicar la función especificada
	 * a los ítems que proporciona el iterador de este iterable. Retorna
	 * {@code null} si este iterable es vacío.
	 * <p>Deberá tenerse en cuenta que al menos uno de los argumentos
	 * que recibe la función podría ser {@code null}. Esto ocurrirá al
	 * inicio y, si el iterable admite ítems nulos, en cualquier otro
	 * momento.</p> 
	 * @param f una función que acepta dos argumentos
	 * @return si {@code A0, A1, A2, ...An-1} son los ítems que proporciona
	 * el iterador, retorna {@code f(...f(f(A1, f(null, A0)), A2), An-1)}
	 */
	default T reduceAll(BiFunction<T, T, T> f) {
		Iterator<T> itr = iterator();
		T result = null;
		while (itr.hasNext()) {
			result = f.apply(result, itr.next());
		}
		
		return result;
	}
	
	/**
	 * Retorna el resultado acumulado de aplicar la función especificada
	 * al resultado de aplicar a los ítems de este iterable la segunda
	 * función dada. Retorna {@code null} si este iterable es vacío.
	 * <p>Deberá tenerse en cuenta que al menos uno de los argumentos
	 * que recibe la función {@code f} podría ser {@code null}. Esto
	 * ocurrirá al inicio y, si el iterable admite ítems nulos, también
	 * la función {@code g} recibirá éstos.</p> 
	 * @param f una función que acepta dos argumentos
	 * @param g la función que se aplica a los ítems
	 * @return si {@code A0, A1, A2, ...An-1} son los ítems que proporciona
	 * el iterador, retorna {@code f(...f(f(g(A1), f(null, g(A0))), g(A2)),
	 * g(An-1))}
	 */
	default <R> R reduceAll(BiFunction<R, R, R> f, Function<T, R> g) {
		Iterator<T> itr = iterator();
		R result = null;
		while (itr.hasNext()) {
			result = f.apply(result, g.apply(itr.next()));
		}
		
		return result;
	}
	
	/**
	 * Retorna el resultado acumulado de aplicar la función especificada
	 * a los ítems de este iterable que cumplen el filtro dado. Retorna
	 * {@code null} si este iterable es vacío o ninguno de los ítems
	 * cumple el filtro.
	 * <p>Deberá tenerse en cuenta que al menos uno de los argumentos
	 * que recibe la función {@code f} podría ser {@code null}. Esto
	 * ocurrirá al inicio y, si el iterable admite ítems nulos, en
	 * cualquier otro momento.</p> 
	 * @param f una función que acepta dos argumentos
	 * @param filter el filtro especificado
	 * @return si {@code a, b, c, ..., k} son los ítems que proporciona
	 * el iterador y cumplen el filtro dado, retorna
	 * {@code f(...f(f(b, f(null, a)), c), k) }
	 */
	default T reduceFiltered(BiFunction<T, T, T> f,
			         		 Predicate<? super T> filter) {
		Iterator<T> itr = iterator();
		T result = null;
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				result = f.apply(result, current);
			}
		}
		
		return result;
	}
	
	/**
	 * Retorna el resultado acumulado de aplicar la función especificada
	 * al resultado de aplicar a los ítems de este iterable y que cumplen
	 * el filtro dado la segunda función proporcionada. Retorna {@code null}
	 * si este iterable es vacío o ninguno de los ítems cumple el filtro.
	 * <p>Deberá tenerse en cuenta que al menos uno de los argumentos
	 * que recibe la función {@code f} podría ser {@code null}. Esto
	 * ocurrirá al inicio y, si el iterable admite ítems nulos, también
	 * la función {@code g} recibirá éstos.</p> 
	 * @param f una función que acepta dos argumentos
	 * @param filter el filtro especificado
	 * @param g la función que se aplica a los ítems
	 * @return si {@code a, b, c, ..., k} son los ítems que proporciona
	 * el iterador y cumplen el filtro dado, retorna
	 * {@code f(...f(f(b, f(null, a)), c), k) }
	 */
	default <R> R reduceFiltered(BiFunction<R, R, R> f,
								 Predicate<? super T> filter, Function<T, R> g) {
		Iterator<T> itr = iterator();
		R result = null;
		while (itr.hasNext()) {
			T current = itr.next();
			if (filter.test(current)) {
				result = f.apply(result, g.apply(current));
			}
		}
		
		return result;
	}
	
	/**
	 * Elimina todos los ítems de este objeto iterable,
	 * lo deja vacío (operación opcional).
	 * @throws UnsupportedOperationException si esta operación
	 * no está soportada
	 */
	default void removeAll() {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			itr.next();
			itr.remove();
		}
	}

	/**
	 * Elimina de este objeto iterable todos los ítems que
	 * cumplen el filtro especificado (operación opcional).
	 * @param filter el filtro dado
	 * @throws UnsupportedOperationException si esta operación
	 * no está soportada
	 */
	default void removeFiltered(Predicate<? super T> filter) {
		Iterator<T> itr = iterator();
		while (itr.hasNext()) {
			if (filter.test(itr.next())) {
				itr.remove();
			}
		}
	}

}
