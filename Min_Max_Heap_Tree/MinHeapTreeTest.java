
								 	MinHeapTreeTest.java


package aoop.minheap;

import static org.junit.Assert.*;

import org.junit.Test;

public class MinHeapTreeTest {

	public  String actualResult, expectedResult;
	Boolean ingCheck=false;// Flag to print tree element value in preorder with or without ing constrain.

	@Test
	public void testMain1() {

		MinHeapTree tree= new MinHeapTree();

		tree.addNode("crying");
		tree.addNode("test");
		tree.addNode("running");
		tree.addNode("testing");
		tree.addNode("sitting");
		tree.addNode("minheap");
		tree.addNode("aiming");

		expectedResult="aiming minheap testing test crying sitting running ";
		actualResult=tree.preOrderTraverse(tree.root,ingCheck);
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void testMain2() {
		ingCheck=true;
		MinHeapTree tree= new MinHeapTree();
		tree.addNode("crying");
		tree.addNode("test");
		tree.addNode("running");
		tree.addNode("testing");
		tree.addNode("sitting");
		tree.addNode("minheap");
		tree.addNode("aiming");

		expectedResult="aiming testing crying sitting running ";
		actualResult=tree.preOrderTraverse(tree.root,ingCheck);
		assertEquals(expectedResult, actualResult);
	}



}
