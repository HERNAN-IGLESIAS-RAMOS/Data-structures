package practicas_ed;

import java.util.Iterator;

import estdatos.Sexpr;
import estdatos.SexprImp;

public class App<E> {
	
	private static boolean check(Sexpr s1, Sexpr s2) {
		Iterator<Sexpr> itr1 = s1.iterator();
		Iterator<Sexpr> itr2 = s2.iterator();
		while (itr1.hasNext() && itr2.hasNext()) {
			if (itr1.next() != itr2.next()) {
				return false;
			}
		}

		return itr1.hasNext() == itr2.hasNext();
	}
	
	public static Sexpr  append(Sexpr s1, Sexpr s2) {
		if(s1.isEmpty()) {
			return s2;
		}
		
		return new SexprImp(s1.car(), append(s1.cdr(),s2));
	}
	
	
	
	public static void main(String[] args) {

		Sexpr sa, sb, sc, sd, se;
		try {
			sa = new SexprImp('a', -1, new SexprImp('b'));
			sb = new SexprImp("hola", "mundo");
			sc = new SexprImp(100, sa);
			sd = new SexprImp(2.3, new SexprImp(sa, new SexprImp()), "string");
			se = new SexprImp(2.3, sb, "string");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Algún constructor está mal implementado.");
			return;
		}
		
		System.out.printf("sa: %s\n", sa);	// (a -1 (b))
		System.out.printf("sb: %s\n", sb);	// (hola mundo)
		System.out.printf("sc: %s\n", sc);	// (100 a -1 (b))
		System.out.printf("sd: %s\n", sd);	// (2.3 ((a -1 (b))) string)
		System.out.printf("se: %s\n", se);	// (2.3 (hola mundo) string)
		
		if (!check(sa, sc.cdr()) ||
				!check(sa, sd.cdr().car().car()) ||
				!check(sb, se.cdr().car())) {
			System.out.println("\nAunque tus tuplas contengan los ítems esperados");
			System.out.println("alguno de tus constructores no está bien implementado.");
			System.out.println("Recuérdese que si los objetos son inmutables se ha de");
			System.out.println("compartir la información siempre que se pueda.");
			return;
		}
		
		

		System.out.println(sd.equals(se));				  // false
		System.out.println(sd.equals(new SexprImp(sd)));  // true
//		System.out.println(append(se, reverse(se)));
	}
	
	

}
