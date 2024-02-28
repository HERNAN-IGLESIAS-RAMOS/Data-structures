package app;


import estDatos.Pair;
import estDatos.PairImp;
import estDatos.Racional;
import estDatos.RacionalMod;
import estDatos.RacionalNoMod;

/**
 * Clase para el programa principal sobre racionales.
 */
public final class App {
	
    private App() {
    }

    /**
     * Programa principal.
     *
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        final Racional r1 = new RacionalMod(2, 4);
        final Racional r2 = new RacionalNoMod(r1);

        System.out.printf("Racional r1: %s\n", r1);
        System.out.printf("Racional r2: %s\n", r2);

        r1.reduce();
        System.out.printf("Racional r1: %s\n", r1);
        System.out.printf("¿r1=r2? %b\n", r1.equals(r2));
        // r2.reduce(); no soportado
        System.out.printf("Racional r1: %s\n", r2);
    	Pair<Integer,Integer> p = new PairImp<>(5,33);
    	Pair<Integer, String> p2 = new PairImp<>(5,"aaaa");
    	System.out.println(p);
    	System.out.println(p2);
//    	final Racional r2 = new RacionalNoMod(2,4);
//    	final Racional r1 = new RacionalNoMod(3,4);
//    	System.out.printf("Racional r2: %s\n", r2);
//    	System.out.println(r2.compareTo(r1));
//    	System.out.println(r2.equals(r1));
//    	final Racional r3 = new RacionalMod(r2);
//    	System.out.println("----------------");
//    	System.out.println(r3);
//    	r3.reduce();
//    	System.out.println(r3);
//    	System.out.println(r2);
    	
    }
}
