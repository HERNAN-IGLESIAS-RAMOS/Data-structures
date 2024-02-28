package estDatos;

public class RacionalMod extends RacionalNoMod {

	public RacionalMod(int n1, int n2) {
		super(n1, n2);
		
	}

	public RacionalMod(Racional r) {
		//super(r); dudoso puede compartir memoria
		super(r.numerador(),r.denominador());
	}

	public RacionalMod(RacionalMod r) {
		//RacionalMod other = (RacionalMod) this;
		
		// par= new PairImp<>(other.numerador(),other.denominador());
		
		super(r);
		
	}
	public void reduce() {
		int n = this.numerador();
		int d = this.denominador();
		
		if(n!=0) {
			int mcd = Racional.mcd(Math.abs(n), d);
			par.setFirst(n/mcd);
			par.setSecond(d / mcd);
			
			
			
		}
	}

}
