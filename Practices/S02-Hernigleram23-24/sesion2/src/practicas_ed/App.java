package practicas_ed;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import estdatos.IterableExtends;
import estdatos.InternalIterator;

public class App {
	private final static Iterable<String> CSTR = Stream
			.of("esto", "es", "un stream", "formado", "por", "varias", "cadenas", "de", "caracteres")
			.collect(Collectors.toCollection(LinkedList::new));

	public static void main(String[] args) {

		/* 
		 *  Utilizando un iterador interno (objeto de tipo
		 *  InternalIterator<String>)
		 */
		System.out.println("\n\tCon iteradores internos");
		System.out.println("\t-----------------------");
		
		IterableExtends<String> itr = new InternalIterator<>(CSTR); //new ...de una clase!!!! no de una interface
		
		// Muestra en consola las cadenas de la colección CSTR	

		
		/*  LAMBDA   (STR)->{código}   (a, b) ->{código}*/
		itr.forAll((str)->{System.out.printf("  %s ",str);});
		System.out.println();
		
		// Cadenas de CSTR con más de 5 caracteres
		itr.forEachFiltered((str)->{System.out.printf("  %s ",str);}, (str)->{return str.length()>5;});
		System.out.println();
		
		// Menor cadena de la colección CSTR
		
		String strMin = itr.reduceAll((str1,str2)->{(str1.compareTo(str2)<=0 ?  str1 :  str2);});
		System.out.printf("%s ",strMin);
		System.out.println();
		
		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.
		
		
		// Concatenar cadenas de CSTR
		
		String result = itr.reduceAll((str1,str2)->{return str1+str2;});
		System.out.printf("%s ",result);
		System.out.println();


		System.out.println("\n\tEliminando ítems de un objeto iterable");
		System.out.println("\t--------------------------------------");
		// La colección CSTR es constante y no se puede modificar, por
		// lo que se crea una nueva colección, list, igual que CSTR que
		// si se pueda modificar
		Iterable<String> list = new LinkedList<>((List<String>)CSTR);  
		System.out.printf("list.equals(CSTR)? %b\n", list.equals(CSTR));
		
		// Eliminar de list todas las cadenas que tengan menos de 3
		// caracteres o comiencen por el carácter 'c'.

		
		// Mostrar en consola las cadenas de la colección list	
		// utilizando el iterador ímplicito (bucle for-each)


		System.out.print("");
		for(String str: list) {
			System.out.printf("%s ",str);
		}

		/* 
		 *  Utilizando un iterador externo (objeto de tipo
		 *  Iterator<String>) 
		 */
		System.out.println("\n\tCon iteradores externos");
		System.out.println("\t-----------------------");
		
		Iterator<String> iter = CSTR.iterator();
		
		// Muestra en consola las cadenas de la colección CSTR

		while(iter.hasNext()) {
			System.out.printf("%s",iter.next());
		}
		// Cadenas de CSTR con más de 5 caracteres

		
		// Menor cadena de la colección CSTR


		// Concatenación de las cadenas de CSTR con más de 5 caracteres.
		// Éstas se concatenan según el orden en que las proporciona un
		// iterador.


	}

}
