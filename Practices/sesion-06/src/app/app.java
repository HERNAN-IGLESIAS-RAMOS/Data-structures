package app;

import estDatos.FiniteSet;
import estDatos.Range;

public class app {

	public static void main(String[] args) {
		
		//4 a
		Range<Integer> ri = new Range<>(-40, 60);
		//4 b
		FiniteSet<Integer> c0 = new FiniteSet<>(ri);
		ri.forEach(n -> {
			if(n % 7 == 0) {
				c0.add(n);
			}
		});
		
		//4 c
		c0.remove(0);
		
		c0.remove(7);
		c0.remove(14);
		
		//4 d
		Range<Character> rc = new Range<>('a','z');
		//4 e
		FiniteSet<Character> c1 = new FiniteSet<>(rc,'c','k','r','x');
		FiniteSet<Character> c2 = new FiniteSet<>(rc,'b','f','k','z');
		// 4 f
		FiniteSet<Character> c3 = new FiniteSet<>(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c1);
		
	}

}
