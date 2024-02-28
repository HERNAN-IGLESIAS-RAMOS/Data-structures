package app;

import java.util.Iterator;

import estDatos.SetNoMod;
import estDatos.SortedSet;

public class app2 {

	public static void main(String[] args) {
		
		SetNoMod <Integer> set = new SetNoMod<>(2,5,1);
		System.out.println(set);
		SetNoMod <Integer> set2 = new SetNoMod<>();
		System.out.println(set2);
		SortedSet <Integer> set3 = new SortedSet<>(2,5,1);
		System.out.println(set3);
		
	
	}

}
