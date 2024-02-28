package estdatos;

import java.util.Objects;

/**
 * Clase abstracta para racionales.
 */
public abstract class AbstractRational implements Rational {
	private final static Object obj = new Object();
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = obj.hashCode();
		result = prime * result + Objects.hash(this.numerator(), this.denominator());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Rational))
			return false;
		Rational other = (Rational) obj;
		return this.numerator()  == other.numerator() &&
				this.denominator() == other.denominator();
	}

	@Override
	public String toString() {
		int n = this.numerator();
		int d = this.denominator();
		return d==1 ? String.format("%d", n) : String.format("%d/%d", n,d);
	}
	
	/*
	 * String result="";
	 * result = result+numerator();
	 * if(denominator()!=1)
	 * result='/'+denominator();
	 * return result;
	 */
    
}
