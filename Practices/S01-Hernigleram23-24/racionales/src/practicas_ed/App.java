package practicas_ed;

import estdatos.Rational;
import estdatos.ImmutableRational;

/**
 * Clase para el programa principal sobre racionales.
 */
public final class App {
	
	private static void comparar(final Rational a, final Rational b) {
		int x = a.compareTo(b);
		System.out.printf("%s.compareTo(%s): %d\n", a, b, x);
		if (x == 0) {
			System.out.printf("%s = %s\n", a, b);
		} else
			if (x > 0) {
				System.out.printf("%s > %s\n", a, b);
			} else {
				System.out.printf("%s < %s\n", a, b);
			}
	}
	
    private App() {
    }

    /**
     * Programa principal.
     *
     * @param args argumentos del programa
     */
    public static void main(final String[] args) {
    	final Rational rat1 = new ImmutableRational(2, 3);
    	final Rational rat2 = new ImmutableRational(4, 6);
    	final Rational rat3 = new ImmutableRational(2, -5);
    	
    	System.out.printf("¿rat1=rat2? %b\n", rat1.equals(rat2));
    	System.out.printf("rat1.hasCode(): %d\n", rat1.hashCode());
    	System.out.printf("rat2.hasCode(): %d\n", rat2.hashCode());
    	
        System.out.printf("Racional rat1: %s\n", rat1);
        System.out.printf("Racional rat2: %s\n", rat2);
        System.out.printf("Racional rat3: %s\n", rat3);
        comparar(rat1, rat2);
        comparar(rat1, rat3);
        comparar(rat2, rat3);
		// Error, operación no soportada
        rat3.setNumerator(3);
        System.out.printf("Racional r3: %s\n", rat3);
    }
}
