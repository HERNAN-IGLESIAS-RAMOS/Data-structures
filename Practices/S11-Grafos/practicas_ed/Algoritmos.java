package practicas_ed; 

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import estdatos.Graph;

public class Algoritmos {
	
	/***  Recorrido en profundidad ***/
	
	public static <Vertex> void BEP (Graph<Vertex> g, Vertex v, Collection<Vertex> marked) {
		System.out.print(v);System.out.print(" ");	
		marked.add(v);
		Collection<Vertex> adyacentes=g.adjacentsTo(v);
		for (Vertex w : adyacentes)
			if (!marked.contains(w))
			   BEP(g,w,marked);
	}

	public static <Vertex> void REP (Graph<Vertex> g) {
		Collection<Vertex> vertices=g.getAllVertex();
		HashSet<Vertex> marcados=new HashSet<Vertex>(g.getNumVertex()*2);
		for (Vertex v : vertices)
			if (!marcados.contains(v))
	             BEP(g,v,marcados);
	}
	
	/***  Recorrido en anchura ***/
	
	public static <Vertex> void BEA (Graph<Vertex> g, Vertex v, Collection<Vertex> marked) {
        LinkedList<Vertex> cola=new LinkedList<Vertex>();  //uno una lista como cola
		marked.add(v);
		cola.addLast(v);
		while (!cola.isEmpty()){
			Vertex a=cola.removeFirst();
			System.out.print(a);System.out.print(" ");	
			Collection<Vertex> adyacentes=g.adjacentsTo(a);
			for (Vertex w : adyacentes)
				if (!marked.contains(w)){
					cola.addLast(w);
					marked.add(w);
				}		
		}
	}

	public static <Vertex> void REA (Graph<Vertex> g) {
		Collection<Vertex> vertices=g.getAllVertex();
		HashSet<Vertex> marcados=new HashSet<Vertex>(g.getNumVertex()*2);
		for (Vertex v : vertices)
			if (!marcados.contains(v))
	             BEA(g,v,marcados);
	}
	
	
	public static <Vertex> void printPath(Map<Vertex,Vertex> pred, Vertex initial, Vertex last) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex current=last;
		while (!current.equals(initial)) {
			path.addFirst (current);
			current = pred.get(current);
		}
		path.addFirst (initial);
		System.out.println (path);
	}
	
	//grado de entrada de un vertice
	public static <Vertex> int gradoEntrada (Graph<Vertex> g, Vertex v) {	
		if (!g.hasVertex(v))
			 throw new RuntimeException("Vertice no existe");
		int count=0;
		Collection<Vertex> vertices=g.getAllVertex();
		for (Vertex w: vertices){
			Collection<Vertex> adjs=g.adjacentsTo(w); 
			if (adjs.contains(v))
			     count++;
		}
		return count;
	}
	
	//grado maximo de salida de cualquier vertice del grafo
	public static <Vertex> int gradoSalidaMax (Graph<Vertex> g) {	
		int gradoMax=-1;
		Collection<Vertex> vertices=g.getAllVertex();
		for (Vertex w: vertices){
			Collection<Vertex> adjs=g.adjacentsTo(w);
			int gradoSalida=adjs.size();
			if (gradoSalida>gradoMax) 
			     gradoMax=gradoSalida;
		}
		return gradoMax;
	}	

}


