package estdatos;

import java.util.Set;
import java.util.Map.Entry;

public interface CrossReferences extends Iterable<Entry<String, Set<Integer>>> {
	
	/**
	 * A�ade la referencia al n�mero de l�nea dado para la
	 * palabra especificada.
	 * @param word la palabra referenciada
	 * @param line el n�mero de l�nea en que se ha encontrado
	 * la palabra dada
	 */
	public void addWord(String word, int line);
	
	/**
	 * Retorna el conjunto de palabras de la l�nea de texto
	 * especificada en orden alfab�tico.
	 * @param line el n�mero de l�nea del texto
	 * @return el conjunto de palabras que hay en la l�nea
	 * dada en orden alfab�tico.
	 */
	public Set<String> words(int line);
	
	/**
	 * Retorna el n�mero total de referencias.
	 * @return el n�mero de referencias
	 */
	public int size();

}
