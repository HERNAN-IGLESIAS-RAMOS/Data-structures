package practicas_ed;

import estdatos.Graph;

public class GraphMain {
	public static void main(String[] args) {

		Graph<String> G = new Graph<String>();
	    G.addVertex("A");
	    G.addVertex("B");
	    G.addVertex("H");
	    G.addVertex("C");	

		G.addEdge("A", "B", 1D);
		G.addEdge("A", "C", 2D);
		G.addEdge("B", "D", 7D);
		G.addEdge("C", "D", 13D);
		G.addEdge("D", "E", 4D);
		G.addEdge("D", "G", 15D);
		G.addEdge("D", "A", 8D);
		G.addEdge("E", "G", 6D);
		G.addVertex("H");
		
		System.out.println("G:\n"+G);
		System.out.printf("Vertices:%d\n",G.getNumVertex());	
		System.out.printf("Ejes:%d\n",G.getNumEdges());
		System.out.println("AllVertex:"+G.getAllVertex());
				
		System.out.println("Adyancentes a D:"+G.adjacentsTo("D"));
		System.out.printf("Grado de entrada a D:%d\n",G.degreeIn("D"));
		System.out.printf("Grado de salida de D:%d\n",G.degreeOut("D"));	
		
		System.out.println("Adyancentes a G:"+G.adjacentsTo("G"));
		System.out.printf("Grado de entrada a G:%d\n",G.degreeIn("G"));
		System.out.printf("Grado de salida de G:%d\n",G.degreeOut("G"));
		
		G.removeEdge("A","C");
		System.out.println("G:\n"+G);
		
		G.removeVertex("G");
		System.out.println("G:\n"+G);
		
		System.out.println("Prueba del constructor de copia");
		Graph<String> G2 = new Graph<String>(G);
		System.out.println("G2:\n"+G2);
	    			System.out.println("G.equals(G2): "+G.equals(G2));	
		G2.addEdge("X","Y",33D);
				    System.out.println("G.equals(G2): "+G.equals(G2));	
		
		System.out.println("G:\n"+G);		
		System.out.println("G2:\n"+G2);	
			
		
		Graph<String> Gf = new Graph<String>();	    
		Gf.addEdge("A", "B", 50D);
		Gf.addEdge("A", "C", 30D);
		Gf.addEdge("A", "D", 100D);
		Gf.addEdge("A", "E", 10D);
		Gf.addEdge("C", "B", 5D);
		Gf.addEdge("D", "B", 20D);
		Gf.addEdge("D", "C", 50D);
		Gf.addEdge("E", "D", 10D);	
		System.out.println("Gf:\n"+Gf);	
		
		System.out.print("REP: ");
		Algoritmos.REP(Gf);  //recorrido en profundidad
		System.out.println();
		System.out.print("REA: ");
		Algoritmos.REA(Gf);  //recorrido en anchura
		System.out.println();
		
		System.out.println("Grado Entrada (G,D)="+Algoritmos.gradoEntrada(G, "D"));
		System.out.println("Grado Salida Maximo (Gf)="+Algoritmos.gradoSalidaMax(Gf));
	
	}
}
