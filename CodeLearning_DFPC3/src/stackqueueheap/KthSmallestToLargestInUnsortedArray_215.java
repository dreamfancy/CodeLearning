package stackqueueheap;

public class KthSmallestToLargestInUnsortedArray_215 
{
	//Solution 1: Minheap -> Size n
	/*
	 * O(nlogn): add one by one
	 * *************************
	 * Step 1: O(n): Heapify
	 * Step 2: Keep pop out k times O(klogn)
	 * Time O(n + klogn)
	 * Space O(n)
	 */
	
	//Solution 2: Heap ->  Size k
	/* Maxheap
	 * Heapify the first k elements from the input array O(k).
	 * Loop the remaining elements, if value of the element x is smaller than 
	 * heap top, update x into the heap: O((n-k)logk)
	 * so totally Time (k+(n-k)logk)
	 * Space O(k) 
	 * 
	 */
	
	//Solution 3: Sort and return kth element 
	/*Time O(nlogn)  
	 *SpaceO(1) 
	 * 
	 */
	
	//Solution 4: Quick Selection / Quicksort Partition
	
}
