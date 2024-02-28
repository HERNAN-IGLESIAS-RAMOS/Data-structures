package estDatos;

import java.util.Objects;

public abstract class AbstractRacional implements Racional {

	
	@Override
	public String toString() {
		return  + numerador() + "/" + denominador() ;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Racional)) {
			return false;
		}
		Racional other = (Racional) obj;
		
		
		// lo especifico
		
		
		
		
		return (this.compareTo(other)==0);
	}

}
