package aoop.assignment2.minmaxheap;

/** 
 * HeapDecorater class Decorates existing Heap class in order to add
 * extra functionality without changing existing heap class
 * Heap Decorator class implements IngDecorator.
 * @author girishchaudhari.
 * 
 */

public class HeapDecorator extends Heap implements IngDecorator {

	protected IngDecorator ingDecorator;

	public HeapDecorator(IngDecorator ingDecorator) {

		this.ingDecorator = ingDecorator;
	}

	public String toString() {
		return ingDecorator.toString();
	}

	public String[] toArray() {
		return ingDecorator.toArray();
	}

	@Override
	public Heap getHeap() {
		return ingDecorator.getHeap();
	}

}
