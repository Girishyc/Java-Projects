package aoop.minheap;

/**
 * Assignment 1 - MinHeap Tree Imlementation
 * This class hold basic getter setter methods to get referene to various
 * node's and their (left,right) childrens and parents.
 * @author girishchaudhari.
 * @created 01/29/2014.   
 */

class Node{

	//Node's leftChild, rightChild , parent declaration as instance variable.

	public	Node leftChild;		
	public	Node rightChild;	
	public	Node parent;		
	public	String dataString; // Declaration of dataString value which is to be contained by node.

	//Default Node constructor
	public Node( String data) {
		this.dataString=data;
	}

	/**
	 * Sets the parent of node
	 * @param Parent(Node)
	 */
	public void setParent(Node parent) {
		this.parent = parent;
	}

	/**
	 * Gets the parent of node
	 * @return parent(Node).
	 */
	public Node getParent() {
		return parent;
	}

	public String toString(){
		return dataString;
	}
}