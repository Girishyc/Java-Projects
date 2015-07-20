package aoop.minheap;

/** 
 * IngDecorator is an Interface implemented in order to implement Decorator patterns
 * This interface has three methods which in then implemented by heapDecorator class.
 * @author girishchaudhari.
 * 
 */

public interface IngDecorator {

	public abstract Heap getHeap();

	public abstract String toString();

	public abstract String[] toArray();
}
