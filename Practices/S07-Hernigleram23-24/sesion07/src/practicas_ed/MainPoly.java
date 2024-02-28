package practicas_ed;
import estdatos.Polynomial;

public class MainPoly {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Polynomial p=new Polynomial();
		System.out.println("p: "+p);
		p.put(0,-7.5);
		p.put(6,2.5);
		p.put(3,4.3);
		System.out.println("p: "+p);	
		System.out.println("Grado de p: "+p.degree());	
		System.out.println("Evaluación si x=2: "+p.evaluate(2));
		System.out.println("Coeficiente de grado 6: "+p.coefficient(6));
		Polynomial p2=new Polynomial(p);
		p.put(6,1.5);
		p.put(5,-8.5);
		p.put(0,7.5);
		System.out.println("p: "+p);
		p.remove(5);
		System.out.println("p: "+p);
		System.out.println("*********************");
		
		p.put(2,-3.7);
		System.out.println("p: "+p);
		System.out.println("p2: "+p2);
		System.out.println("p+p2: "+Polynomial.sum(p,p2));
		
	}

}

//Salida del programa
//p: 
//p: 2.5x6 +4.3x3 -7.5x0 
//Grado de p: 6
//Evaluación si x=2: 186.9
//Coeficiente de grado 6: 2.5
//p: 4.0x6 -8.5x5 +4.3x3 
//p: 4.0x6 +4.3x3 
//*********************
//p: 4.0x6 +4.3x3 -3.7x2 
//p2: 2.5x6 +4.3x3 -7.5x0 
//p+p2: 6.5x6 +8.6x3 -3.7x2 -7.5x0 
