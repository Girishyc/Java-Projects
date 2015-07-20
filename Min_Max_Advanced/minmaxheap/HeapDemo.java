package aoop.assignment2.minmaxheap;

/**
 * HeapBuilderDemo class demonstrate how normal Min/Max Heap works
 * @author girishchaudhari.
 * 
 */

public class HeapDemo {

	public static void main(String[] args) {

		Heap heap = new Heap();

		System.out.println("MinHeap Tree Element In InOrder: \n");

		//  Strategy  set as  MinHeap type
		heap.setHeapType(new MinHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		System.out.println("Min Heap Size: "+heap.size());
		System.out.println(heap);
		System.out.println("Min Heap Ing Elements: ");
		Heap ingHeapElements = new IngHeapDecorator(heap);
		System.out.println(ingHeapElements);

		heap.clear();

		System.out.println("\nMaxHeap Tree Element In InOrder: \n");

	    //  Strategy  set as  MaxHeap type
		heap.setHeapType(new MaxHeap());

		heap.add("crying");
		heap.add("test");
		heap.add("running");
		heap.add("testing");
		heap.add("sitting");
		heap.add("minheap");
		heap.add("aiming");

		System.out.println("Max Heap Size: "+heap.size());
		System.out.println(heap);
		System.out.println("Max Heap Ing Elements: ");
		ingHeapElements = new IngHeapDecorator(heap);
		System.out.println(ingHeapElements);

	}

}
