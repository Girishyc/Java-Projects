package aoop.minheap;

/** 
 * IngFilter class designed to implement ingIterator.
 * IngFilter constructor accept iterator as an argument, Operations are to
 * be performed on default iterator to get ingtype Iterator
 * @author girishchaudhari.
 * 
 */

public class IngFilter {

	private Iterator ingIterator;

	public IngFilter(Iterator iterator) {
		ingIterator = iterator;
	}

	public boolean hasNext() {
		while (ingIterator.hasNext()) {
			if (ingIterator.next().toString().endsWith("ing")) {
				return true;
			}
		}
		return false;
	}

	public Node next() {
		return ingIterator.getCurrentElement();
	}
}
