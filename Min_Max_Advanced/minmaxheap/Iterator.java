package aoop.assignment2.minmaxheap;

/** 
 * Iterator class build iterator over Heap.
 * @author girishchaudhari.
 */
 
import java.util.Stack;

public class Iterator {

	private Stack<Node> heapStack = new Stack<Node>();
	private Node currentNode;
	private Node currentElement;


	public Node getCurrentElement(){
		return currentElement;
	}
	
	public Iterator(Node currentNode) {
		this.currentNode = currentNode;
	}

	public Node next() {
		while (currentNode.isTraversed()) {
			heapStack.push(currentNode);
			currentNode = currentNode.getLeftChild();
		}

		currentNode = heapStack.pop();
		currentElement = currentNode;
		currentNode = currentNode.getRightChild();

		return currentElement;
	}

	public boolean hasNext() {
		return (!heapStack.isEmpty() || currentNode.isTraversed());
	}

}
