package estdatos;

/**
 * TDA de números racionales. Números de la forma {@code a/b} con {@code a} y
 * {@code b} enteros ({@code b≠0}).
 *
 * <p>
 * El signo de un número racional coincidirá siempre con el signo del numerador
 * </p>
 */
public interface Rational extends Comparable<Rational> {

	/**
	 * Retorna el máximo común divisor de los enteros dados.
	 *
	 * @param a el primer entero
	 * @param b el segundo entero
	 * @return el máximo común divisor de los enteros especificados
	 * @throws IllegalArgumentException si {@code a=0} o {@code b=0 }
	 */
	static int gcd(final int a, final int b) {
		if (a == 0 || b == 0) {
			throw new IllegalArgumentException();
		}

		int n1 = a > 0 ? a : -a;
		int n2 = b > 0 ? b : -b;

		while (n2 != 0) {
			int temp = n1;
			n1 = n2;
			n2 = temp % n2;
		}

		return n1;
	}

	/**
	 * Retorna el numerador de este racional.
	 *
	 * @return el numerador del racional
	 */
	int numerator();

	/**
	 * Retorna el denominador de este racional.
	 *
	 * @return el denominador del racional
	 */
	int denominator();

	/**
	 * Cambia el numerador de este racional por el valor especificado (operación
	 * opcional).
	 * 
	 * @param n el nuevo valor del numerador
	 * @throws UnsupportedOperationException si ésta operación no está soportada
	 */
	default void setNumerator(final int n) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Cambia el denominador de este racional por el valor especificado (operación
	 * opcional).
	 * 
	 * @param d el nuevo valor del denominador
	 * @throws UnsupportedOperationException si ésta operación no está soportada
	 */
	default void setDenominator(final int d) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Cambia este racional a uno irreducible equivalente.
	 * 
	 * @throws UnsupportedOperationException si ésta operación no está soportada
	 */
	default void reduce() {

		this.setNumerator(this.numerator() / (gcd(this.numerator(), this.denominator())));
		this.setDenominator(this.denominator() / (gcd(this.numerator(), this.denominator())));

		/*
		 * int mcd = Rational.gcd(numerator(), denominator()); if(mcd!=1) {
		 * setNumerator(numerator()/mcd); setDenominator(denominator()/mcd); }
		 */

	}
	default int compareTo(final Rational r) {
		return this.numerator()*r.denominator()-r.numerator()*this.numerator();
	}

}
