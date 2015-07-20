package aoop.assignment2.minmaxheap;

/** 
 * Node class represents node type objects which holds our heap elements.
 * this class contains info regarding nodes like leftchild,rightchild,parent,datastring etc.
 * Node class is data class.
 * @author girishchaudhari.
 * 
 */

public class Node implements HeapNode {

	private Node leftChild ;
	private Node rightChild;
	private Node parent;
	private String dataString;


	public Node() {}

	public Node(String data) {
		this.dataString = data;
		leftChild= new NullNode();
		rightChild=new NullNode();
	}

	public Node getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(Node leftChild) {
		this.leftChild = leftChild;
	}

	public Node getRightChild() {
		return rightChild;
	}

	public void setRightChild(Node rightChild) {
		this.rightChild = rightChild;
	}

	public String getDataString() {
		return dataString;
	}

	public void setDataString(String dataString) {
		this.dataString = dataString;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public String toString() {
		return dataString;
	}

	public int getSize() {
		return  1+ leftChild.getSize() + rightChild.getSize() ;
	}

	@Override
	public boolean isTraversed() {
		return true;
	}

}
