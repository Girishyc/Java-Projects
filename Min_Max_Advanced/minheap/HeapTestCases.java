package aoop.minheap;

/** 
 * HeapTest Class contains all testcases for MinMax Heap implementation .
 * Pattern Designed and Implemented :NullObject,Iterator,IngFilter,Strategy,Decorator.
 * @author girishchaudhari.
 * 
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HeapTestCases {

	private String actualResult, expectedResult;
	private Heap heap;

	@Before
	public void initialize() {
		heap = new Heap();
	}

	@Test
	public void minHeapToStringTest() {

		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		expectedResult = "testing minheap test aiming sitting crying running ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void minHeapIngToStringCheckTest() {

		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");
		heap = new IngHeapDecorator(heap);
		expectedResult = "testing aiming sitting crying running ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void maxHeapToStringTest() {

		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		expectedResult = "crying test minheap testing running sitting aiming ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void maxHeapIngToStringCheckTest() {

		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");
		heap = new IngHeapDecorator(heap);
		expectedResult = "crying testing running sitting aiming ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void minHeapToArrayTest() {
		String[] expectedResult = { "testing", "minheap", "test", "aiming","sitting", "crying", "running" };

		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		String[] actualResult = heap.toArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void minHeapToArrayIngCheckTest() {
		String[] expectedResult = { "testing", "aiming", "sitting", "crying","running" };

		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		Heap ingDecorator = new IngHeapDecorator(heap);
		String[] actualResult = ingDecorator.toArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void maxHeapToArrayTest() {
		String[] expectedResult = { "crying", "test", "minheap", "testing","running", "sitting", "aiming" };

		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		String[] actualResult = heap.toArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void maxHeapToArrayIngCheckTest() {
		String[] expectedResult = { "crying", "testing", "running", "sitting","aiming" };

		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		Heap ingDecorator = new IngHeapDecorator(heap);
		String[] actualResult = ingDecorator.toArray();
		assertArrayEquals(expectedResult, actualResult);
	}

	@Test
	public void HeapAddTest() {

		heap.setHeapType(new MinHeap());

		heap.add("reading");
		heap.add("aoops");
		heap.add("aiming");

		expectedResult = "reading aiming aoops ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);

		heap.add("sitting");

		expectedResult = "sitting reading aiming aoops ";
		actualResult = heap.toString();
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void HeapSizeTest() {

		int expectedHeapSize=10;

		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("maintaining");
		heap.add("testing");
		heap.add("planning");
		heap.add("minheap");
		heap.add("script");
		heap.add("Heap");
		heap.add("creating");
		heap.add("sitting");

		int actualHeapSize=heap.size();
		assertEquals(expectedHeapSize, actualHeapSize);
	}

	@Test
	public void HeapClearTest() {

		expectedResult="";
		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("script");
		heap.add("Heap");
		heap.add("creating");
		heap.add("sitting");

		heap.clear();

		actualResult=heap.toString();
		assertEquals(expectedResult, actualResult);
	}

	@Test
	public void HeapIteratorTest() {
		expectedResult = "testing minheap test aiming sitting crying running ";
		actualResult= new String();
		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");
		Iterator iterator= heap.heapIterator();
		while(iterator.hasNext()){
			actualResult+=iterator.next().toString()+ " ";
		}
		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void HeapIngIteratorTest() {
		int i =0;
		String[] expectedResult = { "testing", "aiming", "sitting", "crying","running" };
		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		IngFilter ingIterator=new IngFilter(heap.heapIterator());

		String[] actualResult = new String[heap.getIngElementCount()];
		while(ingIterator.hasNext()){
			actualResult[i]=ingIterator.next().toString();
			i++;
		}
		assertArrayEquals(expectedResult, actualResult);

	}
}