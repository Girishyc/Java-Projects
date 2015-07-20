package aoop.assignment2.minmaxheap;

/** 
 * HeapNode interface contains all  abstract methods ,which are common to Node and NullNode class.
 * HeapNode participates in Null Object Design pattern.
 * @author girishchaudhari.
 * 
 */

public interface  HeapNode {
	
	public abstract  int  getSize();
	public abstract  boolean isTraversed();

}

