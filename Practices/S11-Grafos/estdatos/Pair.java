package estdatos; 

public class Pair<K, V> implements Comparable<Pair<K, V>>{
	   private K first;  //primera componente de par
	   private V second; //segunda componetes del par
	   public Pair(K first, V second){
	     this.first = first;
	     this.second = second;
	   }

	   public void setFirst(K first){
	    this.first = first;
	   }

	   public void setSecond(V second) {
	     this.second = second;
	   }

	   public K getFirst() {
	     return this.first;
	   }

	   public V getSecond() {
	     return this.second;
	   }

	@Override
	public int compareTo(Pair<K, V> p) {
		// TODO Auto-generated method stub
		Comparable<? super K> aux=(Comparable<? super K>) first; 
		return aux.compareTo(p.first);  //Comparo solo la primera componente
	}
	
	public String toSring() {
		String s = "";	
		s += "(" + first + ", " + second + ")\n";	
		return s;
	}
}
