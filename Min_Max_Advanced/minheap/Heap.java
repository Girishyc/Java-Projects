package aoop.minheap;

import java.util.Collection;

/**
 * Heap class represents heap type objects . Heap implements HeapIterator
 * interface in order to create iterator on heap, implements IngDecorator
 * interface to decorate exisiting Heap class. This class implements java's
 * default collection interface to override some of its 
 * operations/methods add , toArray, toString, size etc.
 * 
 * @author girishchaudhari.
 */

public class Heap implements Collection<String>, HeapIterator, IngDecorator {

	private Node root;
	private HeapStrategy heapType;
	private int ingElementCount;
	private boolean isFirstElement;

	public Heap() {
		isFirstElement = true;
	}

	/**
	 * This method sets heapType to (Min/Max) based on passed strategy.
	 * @param newHeaptype.
	 */

	public void setHeapType(HeapStrategy newHeaptype) {
		heapType = newHeaptype;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public int getIngElementCount() {
		return ingElementCount;
	}

	public Heap getHeap() {
		return this;
	}

	public int size() {
		return root.getSize();
	}

	/**
	 * This method create iterator on heap and returns the same.
	 * @return Iterator.
	 */
	@Override
	public Iterator heapIterator() {
		return new Iterator(root);
	}

	@Override
	public boolean add(String dataString) {
		if (dataString.endsWith("ing"))
			ingElementCount++;

		if (isFirstElement) {
			this.setRoot(new Node(dataString));
			isFirstElement = false;
		} else
			insertNode(dataString, root);
		return true;
	}

	@Override
	public String[] toArray() {
		int i = 0;
		Iterator iterator = this.heapIterator();
		String[] result = new String[this.size()];
		while (iterator.hasNext())
			result[i++] = iterator.next().toString();
		return result;
	}

	@Override
	public String toString() {
		Iterator iterator = this.heapIterator();
		String result = new String();
		while (iterator.hasNext()) {
			result += iterator.next().toString() + " ";
		}
		return result;
	}

	@Override
	public void clear() {
		this.setRoot(new NullNode());
		isFirstElement = true;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public java.util.Iterator<String> iterator() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends String> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	/**
	 * This method insert element into the heap. 
	 * This method works recursive manner until element get inserted into heap.
	 * at desired position.MinHeap/MaxHeap algorithm constructed based on strategy passed.
	 * @param dataString
	 * @param heapNode
	 */

	private void insertNode(String dataString, Node heapNode) {

		if (!heapNode.getLeftChild().isTraversed()) {

			addElementToLeft(dataString, heapNode);

		} else if (!heapNode.getRightChild().isTraversed()) {

			addElementToRight(dataString, heapNode);

		} else if (heapNode.getLeftChild().getSize() <= heapNode.getRightChild().getSize()) {
			insertNode(dataString, heapNode.getLeftChild());
		} else {
			insertNode(dataString, heapNode.getRightChild());
		}

	}

	/**
	 * This Method add Element as rightChild of passed heapNode. 
	 * @param dataString
	 * @param heapNode
	 */

	private void addElementToRight(String dataString, Node heapNode) {
		heapNode.setRightChild(new Node(dataString));
		heapNode.getRightChild().setParent(heapNode);

		//Based on HeapStrategy passed , Respective algorithm  compareToChild  
		//for Min/Max Heap get called runtime.
		if (heapType.compareToChild(heapNode.getRightChild(), heapNode))
			heapNode = heapNode.getRightChild();
		else {
			swapHeapNodeValues(heapNode, heapNode.getRightChild());
			heapNode = heapNode.getRightChild();
		}
	}

	/**
	 * This Method add Element as leftChild of  passed heapNode. 
	 * @param dataString
	 * @param heapNode
	 */

	private void addElementToLeft(String dataString, Node heapNode) {
		heapNode.setLeftChild(new Node(dataString));
		heapNode.getLeftChild().setParent(heapNode);

		//Based on HeapStrategy passed , Respective algorithm  compareToChild  
		//for Min/Max Heap get called at runtime.
		if (heapType.compareToChild(heapNode.getLeftChild(), heapNode))
			heapNode = heapNode.getLeftChild();
		else {
			swapHeapNodeValues(heapNode, heapNode.getLeftChild());
			heapNode = heapNode.getLeftChild();
		}
	}

	private void swapHeapNodeValues(Node heapNode, Node childNode) {
		String swapValue;
		swapValue = heapNode.getDataString();
		heapNode.setDataString(childNode.getDataString());
		childNode.setDataString(swapValue);
		if (heapNode !=root) {
			//Based on Strategy passed , Respective algorithm of parent comparision 
			// for Min/Max Heap type get called at runtime.
			if (heapType.compareToParent(heapNode)) { 
				swapHeapNodeValues(heapNode.getParent(), heapNode);
			}

		}
	}

}
