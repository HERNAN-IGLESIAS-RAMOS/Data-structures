package estdatos;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Polynomial implements Poly {

	SortedMap<Integer, Double> terms;

	public Polynomial() {
		this.terms = new TreeMap<Integer, Double>();
	}

	public Polynomial(Integer i, Double d) {
		this();
		this.put(i, d); // terms.put(exp,coef) no puedo hacerlo añade exponente 0
	}

	public Polynomial(Poly p) {
		if (p instanceof Polynomial) {
			Polynomial aux = (Polynomial) p;
			terms = new TreeMap<Integer, Double>(aux.terms); // COPIA
		} else {
			terms = new TreeMap<Integer, Double>();
			int grado = p.degree();
			for (int g = 0; g <= grado; g++) {
				Double coef = p.coefficient(g);
				if (coef != 0) {
					terms.put(g, coef);
				}
			}
		}
	}

	@Override
	public Double put(Integer exp, Double coef) {

		Double coef_old = terms.get(exp);
		if (coef_old == null) {
			if (coef != 0)
				terms.put(exp, coef);
			return 0.0;

		} else {
			Double new_coef = coef + coef_old;
			if (new_coef != 0)
				this.terms.put(exp, new_coef);
			else
				this.terms.remove(exp);

		}
		return coef_old;
	}

	@Override
	public Double remove(Integer exp) {
		if (this.terms.containsKey(exp)) {
			return this.terms.remove(exp);
		} else {
			return 0.0;
		}

	}

	@Override
	public Double coefficient(Integer exp) {
		if (this.terms.containsKey(exp)) {
			return terms.get(exp);
		} else {
			return 0.0;
		}

	}

	@Override
	public Integer degree() {
		if (terms.isEmpty()) {
			return 0;
		} else {
			return this.terms.lastKey();
		}

	}

	@Override
	public Double evaluate(Integer x) {
		if (terms.isEmpty()) {
			return 0.0;
		} else {
			double result = 0.0;
			for (Map.Entry<Integer, Double> t : terms.entrySet()) {

				result += Math.pow(x, t.getKey()) * t.getValue();
			}
			return result;
		}
	}

	@Override
	public String toString() {
		String res = "";
		Set<Map.Entry<Integer, Double>> s = terms.entrySet();
		Iterator<Map.Entry<Integer, Double>> it = s.iterator();
		while (it.hasNext()) {
			Map.Entry<Integer, Double> t = it.next();
			String st = "" + t.getValue() + "x" + t.getKey();
			if (terms.lastKey() != t.getKey() && t.getValue() > 0)
				st = '+' + st;
			res = st + " " + res;
		}
		return res;
	}

	public static Polynomial sum(Polynomial p1, Polynomial p2) {
		//(O(n*log n))
		Polynomial result = new Polynomial(p1);
		for(Map.Entry<Integer, Double> t: p2.terms.entrySet()) {
			result.put(t.getKey(), t.getValue());
			
		}
		return result;
		
		/*
		 // Mismo coste 
		  Polynomial result = new Polynomial();
		  Set<Map.Entry<Intger,Double>> s1 = p1.terms.entrySet();
		  Set<Map.Entry<Intger,Double>> s2 = p2.terms.entrySet();
		  PeekIterator<Map.Entry<Integer,Double>> itr1 = new PeekingIterator;
		  PeekIterator<Map.Entry<Integer,Double>> ittr2 = new PeekingIterator;
		  
		  while(itr1.hasNext() && itr2.hasNext()){
		 	Map.Entry<Integer,Double>> currentP1 = itr1.peek();
		  	Map.Entry<Integer,Double>> currentP2 = itr2.peek();
		   if(currentP1.getKey() == currentP2.getKey()){
		   	Double suma = currentP1.getValue()+currentP2.getValue();
		   	if(suma !=0)
		   		//result.put(currentP1.getKey(),suma); // O(log)
		   	itr1.next();
		  		itr2.next();
		  }
		  else if(currentP1.getKey() < currentP2.getKey()){
		 		result.terms.put(currentP1.getKey(),currentP1.getValue());
		  		itr1.next();
		  }
		  else{
		  		result.terms.put(currentP2.getKey(),currentP2.getValue());
		  		itr2.next();
		  
		*/  
		  
		  
	
		 
		 
		  
		 
	}

}
