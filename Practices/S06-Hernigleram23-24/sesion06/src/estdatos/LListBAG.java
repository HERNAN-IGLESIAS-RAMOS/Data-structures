package estdatos;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class LListBAG<E> extends LListSet<E> {

	// NO PONEMOS AREA DE DATOS, YA QUE LO ESTAMOS HEREDANDO DE LLISSET

	public LListBAG() {
		super();
	}

	public LListBAG(Collection<? extends E> c) {
		super(c);

	}

	@Override
	public boolean add(E e) {

		return this.data.add(e);
	}

}
