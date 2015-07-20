package aoop.minheap;

import java.util.Scanner;

/**
 * Assignment 1 - MinHeap Tree Imlementation 
 * This class hold logic to implement MinHeapTree by using 
 * pointer (reference)".Every new node added into subtree which is lesser in height.
 * contains methods to insert new node and  print minheap tree element in preorder .
 * @author girishchaudhari.
 * @created 01/29/2014.
 * 
 */

public class MinHeapTree {
	public Node root;  
	public StringBuffer treeElements; //treeElements declaration as StringBuffer.

	public MinHeapTree() {
		root=null;
		treeElements=new StringBuffer();
	}

	/**
	 * Method to insert node into MinHeap Tree.
	 * @param dataString, treeNode.
	 * @exception NullPointerException.    
	 */
	public void insertNode(String dataString, Node treeNode) throws NullPointerException{
		if (treeNode.leftChild == null){
			treeNode.leftChild = new Node(dataString);
			treeNode.leftChild.setParent(treeNode);

			if(treeNode.leftChild.dataString.compareTo(treeNode.dataString) >0)
				treeNode=treeNode.leftChild;
			else{
				swapTreeNodesValues(treeNode,treeNode.leftChild);
				treeNode=treeNode.leftChild;
			}
		}
		else if (treeNode.rightChild == null){
			treeNode.rightChild = new Node(dataString);
			treeNode.rightChild.setParent(treeNode);

			if(treeNode.rightChild.dataString.compareTo(treeNode.dataString) >0)
				treeNode=treeNode.rightChild;
			else{
				swapTreeNodesValues(treeNode,treeNode.rightChild);
				treeNode=treeNode.rightChild;

			}
		}
		else if (treeSize(treeNode.leftChild) <=treeSize(treeNode.rightChild)){
			insertNode(dataString, treeNode.leftChild);
		}
		else{
			insertNode(dataString, treeNode.rightChild);	
		}
	}


	/**
	 * Method to swap nodes of MinHeap Tree if childNode < ParentNode.
	 * @param treeNode, treeChild.
	 * @exception NullPointerException.    
	 */
	private void swapTreeNodesValues(Node treeNode, Node treeChild) throws NullPointerException {
		String swapValue;
		swapValue=treeNode.dataString;
		treeNode.dataString=treeChild.dataString;
		treeChild.dataString=swapValue;
		if(treeNode.parent!=null){

			if(treeNode.dataString.compareTo(treeNode.getParent().dataString) < 0){
				// Recursive call to a method to swap tree elements if parent node > childnode.
				swapTreeNodesValues(treeNode.getParent(),treeNode ); 
			}

		}
	}

	/**
	 * Method to add node into MinHeap Tree.
	 * @param dataString.    
	 */
	public void addNode(String dataString)
	{
		if (this.isEmpty())
			root = new Node(dataString);  // Initialization of root node as first node of MinHeap Tree.
		else
			insertNode(dataString, root);   
	}

	/**
	 *  Method  to checks whether root is null or not. 
	 * @return boolean.    
	 */

	public Boolean isEmpty()
	{
		return root == null;
	}

	/**
	 * Method to get size of minHeap tree.
	 * @param treeNode
	 * @return result (integer).    
	 */

	private int treeSize(Node treeNode)
	{
		if (treeNode == null)
			return 0;
		else
			return 1 + treeSize(treeNode.leftChild) + treeSize(treeNode.rightChild);
	}


	/**
	 * Method to print  MinHeap Tree node elements in preorder. 
	 * @param treeNode.
	 * @return treeElements.
	 */

	public  String preOrderTraverse(Node treeNode,Boolean ingCheckFlag){
		if(treeNode!=null){
			String treeNodeElement =treeNode.dataString;
			if(ingCheckFlag){
				if(treeNodeElement.endsWith("ing")){	
					treeElements.append(treeNodeElement+" ");
				}
			}else{
				treeElements.append(treeNodeElement+" ");
			}
			preOrderTraverse(treeNode.leftChild , ingCheckFlag);
			preOrderTraverse(treeNode.rightChild, ingCheckFlag);
		}
		return treeElements.toString();
	}

	/**
	 * This method clear stringBuffer. 
	 */
	public  void clearStringBuffer() {
		treeElements.setLength(0);
	}

	public static void main(String[] args) {

		String inputString;
		MinHeapTree tree= new MinHeapTree();

		Scanner in = new Scanner(System.in);

		do {
			System.out.println("Enter InputString element  to insert into MinHeapTree: ");
			inputString=in.nextLine();
			tree.addNode(inputString);
			System.out.println("Do You want to Insert more InputString element into the MinHeap Tree y/n?: ");
		}while(in.nextLine().equalsIgnoreCase("y"));

		in.close();
		System.out.println("\nMinHeap Tree Elements in PreOrder:");
		System.out.println(tree.preOrderTraverse(tree.root,false));
		tree.clearStringBuffer();
		System.out.println("\nMinHeap Tree Elements ending with 'ing' in PreOrder:");
		System.out.println(tree.preOrderTraverse(tree.root,true));
	}
}
