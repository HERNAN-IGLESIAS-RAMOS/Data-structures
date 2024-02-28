package practicas_ed;

import java.util.Arrays;

import estdatos.LListSet;

public class SetMain {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] a={1,5,3,7,11,9};
		
		LListSet<Integer> s=new LListSet<Integer>();
		s.add(25);
		s.add(30);
		s.add(3);
		s.add(30);
		System.out.println("s: "+s);
		
		s.addAll(Arrays.asList(a));
		System.out.println("s: "+s);	
		System.out.println("s vacio?: "+s.isEmpty());
		System.out.println("s contiene el 3?: "+s.contains(3));
		
		LListSet<Integer> s1=new LListSet<Integer>(s);
		System.out.println("s1: "+s1);
		
		s1.removeAll(s);
		
		System.out.println("s1: "+s1);	
		
		LListSet<String> t=new LListSet<String>();
		t.add("Pedro");
		t.add("Luis");
		t.add("Maria");
		t.add("Ana");
		t.add("Ana");
		
		System.out.println("t: "+t);	
		t.remove("Luis");	
		System.out.println("t: "+t);	
	}
}

/*******************  SALIDA: **************************
s: [25, 30, 3]
s: [25, 30, 3, 1, 5, 7, 11, 9]
s vacio?: false
s contiene el 3?: true
s1: [25, 30, 3, 1, 5, 7, 11, 9]
s1: []
t: [Pedro, Luis, Maria, Ana]
t: [Pedro, Maria, Ana]
***************************************************/
