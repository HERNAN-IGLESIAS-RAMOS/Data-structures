package estdatos;

import java.util.Comparator;

public class miComparadorCaracteres implements Comparator<Character> {

	@Override
	public int compare(Character o1, Character o2) {
		return -o1.compareTo(o2);
	}

	
}
