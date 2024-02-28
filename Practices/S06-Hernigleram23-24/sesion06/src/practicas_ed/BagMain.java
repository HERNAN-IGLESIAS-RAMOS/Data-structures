package practicas_ed;

import estdatos.LListBAG;


public class BagMain {

	public static void main(String[] args) {

		
		LListBAG<Integer> s=new LListBAG<Integer>();
		s.add(25);
		s.add(30);
		s.add(3);
		s.add(30);
		s.add(30);
		s.add(3);
		System.out.println("s: "+s);
		
		System.out.println("s: "+s);	
		System.out.println("s vacio?: "+s.isEmpty());
		System.out.println("s contiene el 3?: "+s.contains(3));
	}

}
