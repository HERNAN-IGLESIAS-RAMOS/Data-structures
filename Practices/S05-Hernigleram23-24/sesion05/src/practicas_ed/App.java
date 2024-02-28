package practicas_ed;

import estdatos.Tree;
import estdatos.ChildrenIterator;
import estdatos.FTree;
import estdatos.LCRSTree;
import estdatos.ListTree;


public class App {
	
    /**
     * @param t un árbol ordenado
     * @param e la etiqueta a buscar
     * @return la longitud del camino desde la raíz del árbol {@code t}
     * hasta el primer nodo en postorden de etiqueta {@code e}. Si la 
     * etiqueta no se encuentra en el árbol retorna -1
     */
	public static <E> int length(Tree<E> t, E e) {
		int len=-1;
		ChildrenIterator<Tree<E>> itr = t.childrenIterator();
		while(itr.hasNext() && len==-1) {
			len=length(itr.next(),e);
		}
		if(len!=-1) {
			len++;
		}
		else {
			if(t.label().equals(e)) {
				len=0;
			}
		}
		return len;
	}

	public static void main(String[] args) {

		// Obtención de un árbol t de tipo Tree<Character> a partir de los
		// strings que se obtienen al recorrer éste en preordern y postorden.
		// Este árbol será una instancia de TreeLCRS<Character> y, por tanto,
		// está representado por un árbol binario.
		Tree<Character> t = FTree.createTree("abdhicefjg", "hidbejfgca");
		
		System.out.printf("¿t instanceof TreeLCRS<Character>? %b\n",
				t instanceof LCRSTree<?>);
		System.out.printf("¿t instanceof TreeList<Character>? %b\n",
				t instanceof ListTree<?>);
		// Comprobación de tipo. Todo subárbol del árbol t debe ser de
		// tipo TreeLCRS<Character>
		FTree.typeChecking("t", t);
			
		// Ahora se utilizará el árbol t con los constructores del tipo TreeList<E>
		// para crear dos instancias de este tipo: tree1 y tree2. Adicionalmente,
		// se crea una copia del árbol tree1.
		Tree<Character> tree1 = new ListTree<>(t);
		Tree<Character> tree2 = new ListTree<>('x', new ListTree<>('y'), t);
		Tree<Character> tree1Copy = new ListTree<>(tree1);
		
		System.out.printf("Árbol tree1:\n%s\n", tree1);
		System.out.println();
		System.out.printf("Árbol tree2:\n%s\n", tree2);
		
		
		
		// Comprobación de tipo. Todo subárbol de los árboles tree1, tree2 y
		// tree1Copy debe ser de tipo TreeList<Character>
		FTree.typeChecking("tree1", tree1);
		FTree.typeChecking("tree2", tree2);
		FTree.typeChecking("tree1Copy", tree1Copy);
		System.out.println();
		
		/*** Se requiere que la operación de igualdad esté implementada ***/
		// Object obj = t;
		
		// // Comprobando la igualdad de los árboles tree1 y tree2 con obj
		// System.out.printf("¿tree1.equals(t)? %b\n", tree1.equals(obj));	// true
		// System.out.printf("¿tree2.equals(t)? %b\n", tree2.equals(obj));	// false
		// System.out.println();
		
		/*** Se requiere que las operación parent() de ListTree<E> esté
	         implementada y que también estén implementadas las operaciones
	         obligatorias del iterador childrenIterator()				    ***/
	
		// FTree.parents((ListTree<Character>)tree2);	// Padre de x:  
		// 											// Padre de y: x
		// 											// Padre de a: x
		// 											// Padre de b: a
		// 											// Padre de d: b
		// 											// Padre de h: d
		// 											// Padre de i: d
		// 											// Padre de c: a
		// 											// Padre de e: c
		// 											// Padre de f: c
		// 											// Padre de j: f
		// 											// Padre de g: c		
		// System.out.println();

		
		/*** Se requiere que las operaciones obligatorias del iterador
		     childrenIterator() estén implementadas                    ***/
		
		// // Muestra en consola los árboles tree1 y tree2. Los árboles se recorren
		// // en preorden y para cada nodo con hijos se muestra la etiqueta de éste
		// // y a continuación la lista de las etiquetas de los nodos hijo.
		// System.out.printf("Árbol tree1:\n%s\n", tree1);	// Árbol tree1:
		// 												// a: [b, c]
		// 												// b: [d]
		// 												// d: [h, i]
		// 												// c: [e, f, g]
		// 												// f: [j]
		// System.out.printf("Árbol tree2:\n%s\n", tree2);	// Árbol tree2:
		// 												// x: [y, a]
		// 												// a: [b, c]
		// 												// b: [d]
		// 												// d: [h, i]
		// 												// c: [e, f, g]
		// 												// f: [j]

		
		/*** Se requiere que las operaciones opcionales del iterador
	         childrenIterator() estén implementadas                  ***/
			
		// // Elimina del árbol tree1 el subárbol cuyo nodo raíz tiene la etiqueta 'c'.
		// FTree.removeTree(tree1, 'c');
		// System.out.printf("Árbol tree1:\n%s\n", tree1);	// Árbol tree1:
		// 												// a: [b]
		// 												// b: [d]
		// 												// d: [h, i]
		// System.out.println();
		
		// // Se crea de nuevo el árbol tree1 y un nuevo árbol (other)
		// tree1 = new ListTree<>(tree1Copy);
		// Tree<Character> other = 
		// 		new ListTree<Character>('1',
		// 		                        new ListTree<>('2'),
		// 		                        new ListTree<>('3', new ListTree<>('&')),
		// 		                        new ListTree<>('4', new ListTree<>('!')));		
		// System.out.printf("Árbol tree1:\n%s\n", tree1);	// Árbol tree1:
		// 												// a: [b, c]
		// 												// b: [d]
		// 												// d: [h, i]
		// 												// c: [e, f, g]
		// 												// f: [j]
		// System.out.printf("Árbol other:\n%s\n", other);	// Árbol other:
		// 												// 1: [2, 3, 4]
		// 												// 3: [&]
		// 												// 4: [!]
		
		// FTree.addTree(other, '3',
		// 		new ListTree<Character>('r',
		// 								new ListTree<>('$'),
		// 								new ListTree<>('%')));
		
		// System.out.printf("Árbol other:\n%s\n", other);	// Árbol other:
		// 												// 1: [2, 3, r, 4]
		// 												// 3: [&]
		// 												// r: [$, %]
		// 												// 4: [!]

		// // En el árbol other se reemplaza el subárbol cuyo nodo raíz tiene la
		// // etiqueta  por el árbol tree1.
		// FTree.replaceTree(other, '3', tree1);
		// System.out.printf("Árbol other:\n%s\n", other);	// Árbol other:
		// 												// 1: [2, a, r, 4]
		// 												// a: [b, c]
		// 												// b: [d]
		// 												// d: [h, i]
		// 												// c: [e, f, g]
		// 												// f: [j]
		// 												// r: [$, %]
		// 												// 4: [!]
		
		/*** Se requiere que la función length esté implementada ***/

		// System.out.printf("Nivel del nodo de etiqueta 'r': %d\n",
		// 		App.length(other, 'r'));							// 1
		// System.out.printf("Nivel del nodo de etiqueta 'j': %d\n",
		// 		App.length(other, 'j'));							// 4
		// System.out.printf("Nivel del nodo de etiqueta 'k': %d\n",
		// 		App.length(other, 'k'));							// -1
		// System.out.println();
		
		// Rango de caracteres [inf, sup]
		final char inf = '0';
		final char sup = '9';
		

	}

}
