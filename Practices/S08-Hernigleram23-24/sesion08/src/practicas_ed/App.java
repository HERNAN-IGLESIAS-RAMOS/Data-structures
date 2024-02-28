package practicas_ed;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

import estdatos.CrossReferences;
import estdatos.CrossReferencesImp;

public class App {

	/**
	 * Retorna las referencias cruzadas del archivo de de texto de nombre
	 * especificado.
	 * 
	 * @param fileName el nombre del archivo de texto
	 * @return las referencias cruzadas del texto
	 * @throws FileNotFoundException si no es posible leer el archivo de texto
	 *                               indicado
	 */
	private static CrossReferences processText(String fileName) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(fileName));
		CrossReferences cr = new CrossReferencesImp();
		int numberLine = 0;

		while (sc.hasNextLine()) {
			numberLine++;
			String newLine = sc.nextLine();
			String[] tokens = newLine.split("[( ,;:.)]"); // Dividir la línea en palabras

			for (String word : tokens) {
				if (!word.isEmpty()) {
					cr.addWord(word.toLowerCase(), numberLine);
				}
			}
		}       

		sc.close();
		return cr;
	}

	public static void main(String[] args) {
		CrossReferences cr;
		try {
			/*
			 * Se valorar� que las referencias cruzadas se muestren como se indica en el
			 * enunciado (o en el comentario que hay al final de este archivo), encolumnando
			 * convenientemente los n�meros de l�nea en que �stas aparecen
			 */
			cr = processText("texto.txt");
			System.out.println("\nReferencias cruzadas");
			System.out.println("--------------------");
			System.out.println("Palabra\t\tL�neas en que aparece");
			
			Iterator<Entry<String,Set<Integer>>> itr = cr.iterator();
			while(itr.hasNext()) {
				Entry<String,Set<Integer>> entry = itr.next();
				System.out.print(entry.getKey());
				System.out.print(blancos(entry.getKey()));
				System.out.printf("\t%s\n", entry.getValue());
			}

			// Completar y proporcionar el n�mero de referencias y las palabras
			// que aparecen en la l�nea cuatro.

			System.out.printf("\nN�mero de referencias: %d\n", 0);
			System.out.println();
			System.out.printf("Palabras de la l�nea 4: %s", "");
		} catch (FileNotFoundException e) {
			System.err.format("Error abriendo el archivo: %s", e.getMessage());
		}
	}

}

/*
 * 
 * 
 * Referencias cruzadas -------------------- Palabra L�neas en que aparece ansi
 * [5] archivos [1, 5] cada [2] caracteres [2, 3] carro [4] codificaci�n [5]
 * compone [2] constan [1] cr [4] de [1, 2, 3, 4, 5] define [3] donde [2] dos
 * [3] el [1] en [1, 5] estar [5] impl�cita [3] lf [4] los [1, 5] l�nea [2, 3,
 * 4] l�neas [2] mediante [3] o [6] oem [5] operativo [1] pueden [5] retorno [4]
 * salto [4] se [2, 3] secuencia [2] sistema [1] texto [1, 5] un [3] una [2]
 * unicode [6] usuario [3] utf-8 [6] varias [1] windows [1, 5] y [4]
 * 
 * N�mero de referencias: 53
 * 
 * Palabras de la l�nea 4: [carro, cr, de, lf, l�nea, retorno, salto, y]
 * 
 */