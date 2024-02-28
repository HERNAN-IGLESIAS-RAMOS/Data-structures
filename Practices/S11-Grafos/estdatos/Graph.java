package estdatos;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.SortedMap;


/* Clase para grafos dirigidos simples basada en listas de adyacencia
*  Se parametriza el tipo de los vertices (Vertex).  Los pesos son tipo Double
*/
public class Graph<Vertex> {
	private SortedMap<Vertex, SortedMap<Vertex, Double>> adjList;
	private int numVertex;
	private int numEdges;

	public Graph() {
		adjList=new TreeMap<Vertex, SortedMap<Vertex,Double>> ();
		numVertex=0;
		numEdges=0;
	}
	
	public Graph(Graph<Vertex> g) {
		adjList=new TreeMap<Vertex, SortedMap<Vertex,Double>> (g.adjList);
		numVertex=g.numVertex;
		numEdges=g.numEdges;
	}	
	
	public boolean hasVertex(Vertex v){
		return adjList.containsKey(v);
	}

	public boolean hasEdge(Vertex from, Vertex to){
		if (hasVertex(from) && hasVertex(to)){
		     SortedMap<Vertex,Double> adjs=adjList.get(from);
		     return adjs.containsKey(to);
		}
		else
			return false;
	}
	
    public boolean addVertex(Vertex v){
		if (hasVertex(v))
			   return false;
		numVertex++;		
		TreeMap<Vertex,Double> aux=new TreeMap<Vertex,Double>();  //creo una lista de adj vacía
		adjList.put(v,aux); 
        return true;
	}

	public boolean removeVertex(Vertex v){
		if (!hasVertex(v))
			return false;
		//hay que borrarlo de cada dicc de adyacentes y del dicc principal
		numEdges=numEdges-degreeOut(v);
		adjList.remove(v);
		for (Entry<Vertex, SortedMap<Vertex, Double>> entry : adjList.entrySet()){
			SortedMap<Vertex,Double> adjs=entry.getValue();
			if (adjs.remove(v)!=null)
			    numEdges--;
		}
        numVertex--;
		return true;
	}	
	
	public boolean addEdge(Vertex from, Vertex to, Double weight){
		if (hasEdge(from,to))
				return false;
		numEdges++;		
		addVertex(from); //puede existir ya
		addVertex(to);   //puede existir ya
		SortedMap<Vertex,Double> adjs=adjList.get(from);
		adjs.put(to, weight);
		return true;
	}
	
	public boolean removeEdge(Vertex from, Vertex to){
		if (!hasEdge(from,to))
			return false;
	    SortedMap<Vertex,Double> adjs=adjList.get(from);
	    adjs.remove(to);
		numEdges--;
		return true;		
	}

	public Double weightEdge(Vertex from, Vertex to){
		if (!hasEdge(from,to))
			return -1D;  //null o lanzar una excepcion
		
	    SortedMap<Vertex,Double> adjs=adjList.get(from);
	    return adjs.get(to);		
	}
	
	public Collection<Vertex> adjacentsTo(Vertex v){
		if (!hasVertex(v))
			 throw new RuntimeException("Vertice no existe");
		SortedMap<Vertex,Double> adjs=adjList.get(v);
		return adjs.keySet();
	}

	public Collection<Vertex> getAllVertex(){
		return adjList.keySet();
	}

	//grado de entrada
	public int degreeIn(Vertex v){
		if (!hasVertex(v))
			 throw new RuntimeException("Vertice no existe");
		int count=0;
		for (Entry<Vertex, SortedMap<Vertex, Double>> entry : adjList.entrySet()){
			SortedMap<Vertex,Double> adjs=entry.getValue();
			if (adjs.containsKey(v))
			     count++;
		}
		return count;
	}

	//grado de salida
	public int degreeOut(Vertex v){
		if (!hasVertex(v))
			 throw new RuntimeException("Vertice no existe");
		return adjacentsTo(v).size();
	}

    public int getNumVertex(){
    	return numVertex;
    }

    public int getNumEdges(){
    	return numEdges;
    }   
    
    public boolean equals(Graph<Vertex> g){
    	if (this==g)
    		return true;
    	if ((g.numVertex!=this.numVertex) ||
    	    (g.numEdges!=this.numEdges)   ||
    	    ((g.getAllVertex()).equals(this.getAllVertex())==false))
    		     return false;
    	//comprobar los arcos y sus pesos
    	Iterator<Entry<Vertex, SortedMap<Vertex, Double>>> itr1= this.adjList.entrySet().iterator();
    	Iterator<Entry<Vertex, SortedMap<Vertex, Double>>> itr2= g.adjList.entrySet().iterator();
    	
		while (itr1.hasNext()){
			Entry<Vertex, SortedMap<Vertex, Double>> entry1=itr1.next();
			Entry<Vertex, SortedMap<Vertex, Double>> entry2=itr2.next();
		    return entry1.equals(entry2);
		}
		return true;
    }
	 
	public String toString() 	{	
		String s = "";	
		for (Entry<Vertex, SortedMap<Vertex, Double>> entry : adjList.entrySet())	
			s += "(" + entry.getKey() + ", " + (entry.getValue()).toString() + ")\n";	
		return s;	
	}	

}


