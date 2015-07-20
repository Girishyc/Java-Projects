package aoop.minheap;

/**
 * IngHeap Decorater class decorate Heap class. This is achieved by modifying
 * toArray and toString methods of existing Heap class.
 * 
 * @author girishchaudhari.
 */

public class IngHeapDecorator extends HeapDecorator {

	public IngHeapDecorator(IngDecorator ingDecorator) {
		super(ingDecorator);

	}

	/**
	 * This method modifies/Decorates toString method of Heap.
	 */

	@Override
	public String toString() {
		Heap heap = ingDecorator.getHeap();
		IngFilter ingIterator = new IngFilter(heap.heapIterator());
		String result = new String();
		while (ingIterator.hasNext()) {
			result += ingIterator.next().toString() + " ";
		}
		return result;
	}

	/**
	 * This method modifies/Decorates toArray method of Heap.
	 */

	@Override
	public String[] toArray() {
		int i = 0;
		Heap heap = ingDecorator.getHeap();
		IngFilter iterator = new IngFilter(heap.heapIterator());
		String result[] = new String[heap.getIngElementCount()];
		while (iterator.hasNext())
			result[i++] = iterator.next().toString();
		return result;
	}

}
