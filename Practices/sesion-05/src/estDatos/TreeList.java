package estDatos;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class TreeList<E> implements Tree<E> {
	E labelRoot;
	List<Tree<E>> children;
	
	
	
	public TreeList(E e) {
		if(e==null) throw new NullPointerException();
		
		this.labelRoot = e ;
		this.children = new LinkedList<>();
	}
	public TreeList(E e, Tree<E>...trees) {
		if(e==null) throw new NullPointerException();
		this.labelRoot = e ;
		
		this.children = new LinkedList<>();
		
		for(Tree<E> t : trees) {
			this.children.add(new TreeList<>(t));
		}
	}
	public TreeList(E e, List<Tree<E>> children) {
		if(e==null) throw new NullPointerException();
		this.labelRoot = e ;
		
		this.children = new LinkedList<>();
		
		for(Tree<E> t : children) {
			this.children.add(new TreeList<>(t));
		}
		
	}
	public TreeList(Tree<E> t) {
		if(t==null) throw new NullPointerException();
		
		this.labelRoot = t.label();
		this.children = new LinkedList<>();
		
		Iterator<Tree<E>> itr = t.iteratorChildren();
		
		while(itr.hasNext()) {
			this.children.add(itr.next());
		}
		
		
	}
	
	@Override
	public boolean isLeaf() {
			
		return this.children.isEmpty();
	}

	@Override
	public E label() {
		
		return this.labelRoot;
	}
	
	public void setLabel(E e) {
		this.labelRoot = e;
	}
	@Override
	public IteratorChildren<Tree<E>> iteratorChildren() {
		
		
		return new miIterador();
	}
	private final class miIterador implements IteratorChildren<Tree<E>> {
		private ListIterator<Tree<E>> itr ;
		
		private miIterador() {
			itr =   children.listIterator();
		}
		@Override
		public boolean hasNext() {
			
			return itr.hasNext();
		}

		@Override
		public Tree<E> next() {
			
			return itr.next();
		}
		
		
		
		
	}

}
