package app;

import estDatos.BagMod;
//import estDatos.SortedBag;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Ejemplo de uso de las bolsas.
 */
public final class App {

    /**
     * Nombre del archivo de texto.
     */
    private static final String ENTRADA_TEXTO = "texto.txt";

    private App() {
    }

    /**
     * Retorna la colección de palabras proporcionadas mediante el
     * archivo de nombre especificado.
     *
     * @param nombre el nombre del archivo especificado
     * @return la colección de figuras
     * @throws IOException si el archivo de datos es erróneo
     */
    private static Collection<String> obtenerPalabras(final String nombre)
            throws IOException {
        Collection<String> c = new BagMod<>();
        File f = new File(nombre);
        Scanner sc = new Scanner(f);
        // [;\n] es una expresión regular que indica los
        // delimitadores utilizados en el archivo: el
        // caracter ';' y el salto de línea
        sc.useDelimiter("[;\n]");
        // procesar el archivo línea a línea
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] v = linea.split("[.,;:¿?¡!\"() ]");

            for (String palabra : v) {
                if (palabra != null) {
                    if (!palabra.equals("")) {
                        c.add(palabra.toLowerCase());
                    }
                }
            }
        }

        sc.close();
        return c;
    }

    /**
     * Cuenta el número de ocurrencia del objeto especificado en la
     * colección dada.
     *
     * @param o el objeto
     * @param b la colección
     * @return número de ocurrencias del objeto en la colección
     */
    private static int numeroOcurrencias(final Object o,
                                         final Collection<?> b) {
        int num = 0;

        for (Object item : b) {
            if (item.equals(o)) {
                num++;
            }
        }

        return num;
    }

    /**
     * Programa principal.
     *
     * @param args argumentos del programa
     */
    public static void main(final String[] args) {
//        try {
//            Collection<String> b1 = obtenerPalabras(ENTRADA_TEXTO);
//            //Collection<String> b2 = new SortedBag<>(b1);
//
//            System.out.printf("Bolsa: %s\n", b1.toString());
//            System.out.printf("Número de apariciones de \"en\": %d\n",
//                              numeroOcurrencias("en", b1));
//            System.out.printf("Número de apariciones de \"para\": %d\n",
//                              numeroOcurrencias("para", b1));
//
//          //  System.out.printf("Bolsa: %s\n", b2.toString());
//           // System.out.printf("Número de apariciones de \"en\": %d\n",
//            //                  numeroOcurrencias("en", b2));
//           // System.out.printf("Número de apariciones de \"para\": %d\n",
//            //                  numeroOcurrencias("para", b2));
//        } catch (ArrayIndexOutOfBoundsException e) {
//            System.err.println("Falta el nombre del archivo");
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            System.err.printf("Error abriendo archivo: %s\n",
//                e.getMessage());
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
    
    	BagMod<Object> bolsa = new BagMod<>();
    	bolsa.add("1");
    	bolsa.add("2");
    	bolsa.add("3");
    	bolsa.add("4");
    	bolsa.add("5");
    	bolsa.add("6");
    	bolsa.add("7");
    	bolsa.add("8");
    	bolsa.add("9");
    	bolsa.add("10");
    	
    	
    	Iterator itr = bolsa.iterator();
    	while(itr.hasNext()) {
    		
    		System.out.println(itr.next());
    		
    	}
    	
    	
    	
    }
    
}
