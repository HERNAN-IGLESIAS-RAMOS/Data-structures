package estDatos;

import java.util.Objects;

public class RacionalNoMod extends AbstractRacional {
	// area de datos
	protected Pair<Integer,Integer> par;
	
	
	
	//constructor por defecto
	//	public RacionalNoMod() {
	//		
	//		par= new PairImp<>(0,1);
	//		
	//		
	//	}
	
	
	
	public RacionalNoMod(int n1, int n2) {
		par= new PairImp<>(n1,n2);
		
	}
	//constructor conversion
	public RacionalNoMod(Racional r) {
		
		if(r instanceof RacionalNoMod) {
			RacionalNoMod other = (RacionalNoMod) r;
			this.par= other.par;
		}
		else {
			
		
		this.par= new PairImp<>(r.numerador(),r.denominador());
		}
		
	}
	
	//contructor de copia
	public RacionalNoMod(RacionalNoMod r) {
		
		
		par= r.par;
		
	}

	@Override
	public int numerador() {
		
		return  par.first();
				
	}

	@Override
	public int denominador() {
		
		return par.second();
	}
	
	
	
	
	
	

	
	

}
