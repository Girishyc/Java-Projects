package aoop.minheap;

/**
 * The nullNode class represents nullnode objects which hold do nothing
 * behaviour NullNode class participates in Null object design pattern.
 * 
 * @author girishchaudhari.
 * 
 */

public class NullNode extends Node implements HeapNode {

	public NullNode() {
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public boolean isTraversed() {
		// TODO Auto-generated method stub
		return false;
	}

}
