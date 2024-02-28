package practicas_ed;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import estdatos.IterableExtends;
import estdatos.InternalIterator;

public class App {
	private final static Iterable<String> CSTR =
			Stream.of("esto", "es", "un stream", "formado", "por",
					  "varias", "cadenas", "de", "caracteres").collect(
							  Collectors.toCollection(LinkedList::new));
	private final static Iterable<Integer> CINT =
			Stream.of(2, -8, 12, 4, 20, -3, 15, 7).collect(
							  Collectors.toCollection(LinkedList::new));
	
	public static void main(String[] args) {

		/* 
		 *  Utilizando un iterador interno (objeto de tipo
		 *  InternalIterator<String>)
		 */
		System.out.println("\n\tCon iteradores internos");
		System.out.println("\t-----------------------");
		IterableExtends<String> iterable = new InternalIterator<>(CSTR);
		
		// Muestra en consola las cadenas de la colección CSTR
		System.out.print("Cadenas de la colección:");
		iterable.forAll(
				(str) -> {
					System.out.printf(" \"%s\"", str);
				});
		System.out.println();
		
		// Cadenas de CSTR con más de 5 caracteres
		System.out.print("Cadenas con más de 5 caracteres:");
		iterable.forEachFiltered(
				(str) -> {
					System.out.printf(" \"%s\"", str);
				},
				(str) -> {
					return str.length() > 5;
				});
		System.out.println();
		
		// Menor cadena de la colección CSTR
		String strMin = iterable.reduceAll(
				(str1, str2) -> {
					if (str1 == null) {
						return str2;
					}
					if (str2 == null) {
						return str1;
					}
					return (str1.compareTo(str2) <= 0 ? str1 : str2);
				});
		System.out.printf("Cadena menor: \"%s\"\n", strMin);
		
		Predicate<String> predicate =
				(str) -> {
					return str.length() > 5;
				};
		
		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.
		String concatenation = iterable.reduceFiltered(
				(str1, str2) -> {
					if (str1 == null) {
						str1 = "";
					}
					if (str2 == null) {
						str2 = "";
					}
					return str1 + str2;
				}, predicate);
		System.out.printf("Cadenas concatenadas: \"%s\" (%d caracteres)\n",
				concatenation, concatenation.length());
		
		BiFunction<Integer, Integer, Integer> sumFunction =
				(n1, n2) -> {
					if (n1 == null) {
						n1 = 0;
					}
					if (n2 == null) {
						n2 = 0;
					}
					return n1 + n2;
				};
		
		// Suma de todas las longitudes de las cadenas de CSTR con más
		// de 5 caracteres
		int lengthsSum = iterable.reduceFiltered(
				(n1, n2) -> {
					if (n1 == null) {
						n1 = 0;
					}
					if (n2 == null) {
						n2 = 0;
					}
					return n1 + n2;
				},
				predicate,
				(str) -> {
					return str.length();
				});
		System.out.printf("Suma de las longitudes de las cadenas de la colección: %d\n", lengthsSum);
		
		IterableExtends<Integer> iiter = new InternalIterator<>(CINT);
		// Suma de todos los enteros de la colección CINT
		System.out.printf("Suma de los enteros de la colección: %d\n",
				iiter.reduceAll(sumFunction));
		
		// Producto de todos los enteros positivos y pares de la colección CINT
		int product = iiter.reduceFiltered(
				(n1, n2) -> {
					if (n1 == null) {
						n1 = 1;
					}
					if (n2 == null) {
						n2 = 1;
					}
					return n1 * n2;
				},
				(num) -> {
					return (num > 0 && num % 2 == 0);
				});
		System.out.printf("Producto de los enteros positivos pares de la colección: %d\n", product);
		
		// Muestra en consola los cuadrados de los enteros de la colección
		Function<Integer, Integer> squareFunction =
				(num) -> {
					return num * num;
				};				
		System.out.print("Cuadrados de los enteros de la colección:");
		iiter.forAll(
				(num) -> {
					System.out.printf(" %d", num);
				}, squareFunction);
		System.out.println();
		
		// Suma de los cuadrados de los enteros de la colección
		System.out.printf("Suma de los cuadrados de los enteros de la colección: %d\n",
				iiter.reduceAll(sumFunction, squareFunction));
				
		System.out.println("\n\tEliminando ítems de un objeto iterable");
		System.out.println("\t--------------------------------------");
		// La colección CSTR es constante y no se puede modificar, por
		// lo que se crea una nueva colección, list, igual que CSTR que
		// si se pueda modificar
		Iterable<String> list = new LinkedList<>((List<String>)CSTR);
		System.out.printf("list.equals(CSTR)? %b\n", list.equals(CSTR));
		
		// Eliminar de list todas las cadenas que tengan menos de 3
		// caracteres o comiencen por el carácter 'c'.
		IterableExtends<String> iter = new InternalIterator<>(list);
		System.out.print("Eliminando cadenas con menos de 3 caracteres o que comienza por 'c' ... ");
		iter.removeFiltered((str) -> {
			return (str.length() < 3 || str.charAt(0) == 'c');
		});
		System.out.println("hecho.");
		
		// Mostrar en consola las cadenas de la colección list	
		// utilizando el iterador ímplicito (bucle for-each)
		System.out.print("Cadenas en la colección list:");
		for (String str: list) {
			System.out.printf(" \"%s\"", str);
		}
		System.out.println();


		/* 
		 *  Utilizando un iterador externo (objeto de tipo
		 *  Iterator<String>) 
		 */
		System.out.println("\n\tCon iteradores externos");
		System.out.println("\t-----------------------");
		Iterator<String> itr = CSTR.iterator();
		
		// Muestra en consola las cadenas de la colección CSTR
		System.out.print("Cadenas de la colección:");
		while (itr.hasNext()) {
			System.out.printf(" \"%s\"", itr.next());
		}
		System.out.println();
		
		// Cadenas de CSTR con más de 5 caracteres
		itr = CSTR.iterator();
		System.out.print("Cadenas con más de 5 caracteres:");
		while (itr.hasNext()) {
			String current = itr.next();
			if (current.length() > 5) {
				System.out.printf(" \"%s\"", current);
			}
		}
		System.out.println();
		
		// Menor cadena de la colección CSTR
		strMin = null;
		itr = CSTR.iterator();
		if (itr.hasNext()) {
			strMin = itr.next();
		}
		while (itr.hasNext()) {
			String current = itr.next();
			if (strMin.compareTo(current) > 0) {
				strMin = current;
			}
		}
		System.out.printf("Cadena menor: \"%s\"\n", strMin);

		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.
		itr = CSTR.iterator();
		StringBuilder result = new StringBuilder();
		while (itr.hasNext()) {
			String current = itr.next();
			if (current.length() > 5) {
				result.append(current);
			}
		}
		System.out.printf("Cadenas concatenadas: \"%s\"\n", result);		
	}

}
