package app;

import estDatos.LPCHash;

public class LCPCHashMain {

	public static void main(String[] args) {
		LPCHash l1 = new LPCHash(7);
		l1.add(10);
		l1.add(5);
		l1.remove(5);
		l1.toPrint();
	}

}
