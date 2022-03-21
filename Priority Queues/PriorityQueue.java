
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) {
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) {
		if (numElements == size) {
			// Expand the buffer allocated for the heap to another buffer that is twice as big.

			Interval newHeap[] = new Interval[(size + 2) * 2];

			for (int i = 1; i <= size; ++i) {
				newHeap[i] = heap[i];
			}
	
			size = size * 2;
			heap = newHeap;
		}
		// Insert without buffer expansion here.

		heap[numElements] = k;
		siftup(numElements);
		numElements++;

	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		
		Interval heap1 = heap[1];
		swap(1, (numElements - 1));

		Interval removeHeap = heap[i];
		siftdown(1);
				

		return heap1; // Replace this statement with returning the max element (root) in the heap.
	}
	
	private int left(int x) {
		int a = (2x + 1);
		
		return a;
	}

	private int right(int x) {
		int b = (2x + 2);
	}

	private void swap(int x, int y) {
		Interval swapHeap = heap[i];
		heap[i] = heap[j];
		heap[j] = swapHeap;
	}

	private void siftup(int x) {
		
	}

	
	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
}
