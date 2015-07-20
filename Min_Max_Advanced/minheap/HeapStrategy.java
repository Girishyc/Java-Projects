package aoop.minheap;

/** 
 * HeapStrategy  contains  heapStrategy interface, MinHeap, MaxHeap inner classes.
 * heapStrategy inteface contain all methods which common to Minheap as well as MaxHeap.
 * Participates in  Strategy Design pattern. Methods are invoked based on passed strategy.
 * @author girishchaudhari.
 */

public interface HeapStrategy {
	
	public abstract boolean compareToChild(Node childNode, Node heapNode);

	public abstract boolean compareToParent(Node heapNode);

}


class MinHeap implements HeapStrategy {

	/**This Method compare child ( newly added element) with its parents. 
	 * @param childNode
	 * @param heapNode
	 * @return true: if child element is bigger than its parent.
	 * @return false: if child element is lesser than its parent.
	 */
	
	@Override
	public boolean compareToChild(Node childNode, Node HeapNode) {
		return (childNode.getDataString().compareTo(HeapNode.getDataString()) > 0);
	}

	/**This Method compare heapnode with its parent element recursively until MinHeap
	 * algorithm constraint get satisfied.
	 * @param heapNode
	 * @return true: if parent element is bigger than its child element.
	 * @return false: if parent element is lesser than its child element.
	 */
	
	@Override
	public boolean compareToParent(Node heapNode) {
		return (heapNode.getDataString().compareTo(heapNode.getParent().getDataString()) < 0);
	}

}

class MaxHeap implements HeapStrategy {

	/**This Method compare child ( newly added element) with its parents
	 * @param childNode
	 * @param heapNode
	 * @return true: if child element is lesser than its parent.
	 * @return false: if child element is bigger than its parent.
	 */
	
	@Override
	public boolean compareToChild(Node childNode, Node heapNode) {
		return (childNode.getDataString().compareTo(heapNode.getDataString()) < 0);
	}

	/**This Method compare heapnode with its parent element recursively until 
	 * MaxHeap algorithm constraint get satisfied
	 * @param heapNode
	 * @return true: if parent element is lesser than its child element.
	 * @return false: if parent element is bigger than its child element.
	 */
	
	@Override
	public boolean compareToParent(Node heapNode) {
		return (heapNode.getDataString().compareTo(heapNode.getParent().getDataString()) > 0);
	}

}
