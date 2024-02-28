package estdatos;

/**
 * Tipo inmutable de racionales.
 */
public class ImmutableRational extends AbstractRational {
    /**
     * El par {@code (numerador, denominador)}.
     */
    private Pair<Integer, Integer> p; //No new no hacemos nada

    /**
     * Crea el racional {@code n/d}. El signo se establece
	 * en el numerador.
     *
     * @param n el numerador del racional
     * @param d el denominador del racional
     * @throws IllegalArgumentException si el denominador
     * es cero
     */
    public ImmutableRational(final int n, final int d) {
		p = new ImmutablePair<>(n,d);
    }

    /**
     * Constructor de conversión.
     *
     * @param r el racional a copiar
     */
    public ImmutableRational(final Rational r) { //INMUTABLE SE PONE IF, MUTABLE NO! (HAY Q PROBAR EL MUTABLE, AÑADIR SETDENOMINATOR/NUMERATOR)
    	if( r instanceof ImmutableRational) {
    		ImmutableRational other = (ImmutableRational) r;
    		this.p = other.p;
    	
    	}
    	else {
    		p = new ImmutablePair<>(r.numerator(),r.denominator());
    	}
    }
    
    
    @Override
    public int numerator() {
    	return p.first();
    }
    
    @Override
    public int denominator() {
    	return p.second();
    }

	@Override
	public int compareTo(Rational o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
