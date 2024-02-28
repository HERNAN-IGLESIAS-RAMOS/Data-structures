package estdatos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class CrossReferencesImp implements CrossReferences {

	SortedMap<String, Set<Integer>> refs;

	public CrossReferencesImp() {
		this.refs = new TreeMap<>();
	}

	public CrossReferencesImp(CrossReferences cr) {
		/*
		 * this(); Iterator<Entry<String, Set<Integer>>> itr = cr.iterator(); while
		 * (itr.hasNext()) { Entry<String, Set<Integer>> entry = itr.next();
		 * refs.put(entry.getKey(), entry.getValue()); }
		 */
		if (cr instanceof CrossReferencesImp) {
			CrossReferencesImp aux = (CrossReferencesImp) cr;
			refs = new TreeMap<>(aux.refs);
		} else {
			refs = new TreeMap<>();
			Iterator<Entry<String, Set<Integer>>> itr = cr.iterator();
			while (itr.hasNext()) {
				Entry<String, Set<Integer>> entry = itr.next();
				refs.put((entry.getKey()), entry.getValue());
			}
		}

	}

	@Override
	public void addWord(String word, int line) {
		Set<Integer> references = refs.get(word);
		if (references == null) {
			references = new LinkedHashSet<>();
			refs.put(word, references);
		}
		references.add(line);
	}

	@Override
	public Set<String> words(int line) {
		Set<String> result = new LinkedHashSet<>();
		for (Map.Entry<String, Set<Integer>> entry : refs.entrySet()) {
			Set<Integer> lineasEntry = entry.getValue();
			if (lineasEntry.contains(line)) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	@Override
	public int size() {
		int count = 0;
		for (Set<Integer> lineas : refs.values())
			count += lineas.size();
		return count;
	}

	@Override
	public Iterator<Entry<String, Set<Integer>>> iterator() {
		return this.refs.entrySet().iterator();
	}

}
