package leetcode201to250;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray_215 
{
	
	//Sol 3: Selection Sort
	//Something like BST. When doing partition, we know there are T numbers <= n-T numbers,Then compare T and K to 
	//decide where to go next.
	public int findKthLargest_3(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
	
	//Sol 2:
	//Change the comparator get sort from large to small: Attention the argument of compare should
	//not be generic. So instead of (int i1, inti2) you should use (Integer i1, Integer i2)
    public int findKthLargest_2(int[] nums, int k) 
    {
        if(nums==null || nums.length<k || k<0) return -1;
        int n = nums.length;
        PriorityQueue<Integer> prioqueue = new PriorityQueue<Integer>(k, new Comparator<Integer>()
      {
            @Override
            public int compare(Integer i1,Integer i2)
            {
                return i2-i1;
            }
      });
        
        for(int i=0; i<n; i++)
        {
            prioqueue.offer(nums[i]);
        }
        
        int result = 0;
        for(int c=0; c<k; c++)
        {
            result = prioqueue.poll();

        }
        return result;
    }
	
	//Sol 1: PriorityQueue generic to find the minimum element, get the number as the opposite way
	//Attention using this solution you cannot designate the size of the comparator!!!
    public int findKthLargest_1(int[] nums, int k) 
    {
        if(nums==null || nums.length<k || k<0) return -1;
        int n = nums.length;
        PriorityQueue<Integer> prioqueue = new PriorityQueue<Integer>();
        
        for(int i=0; i<n; i++)
        {
            prioqueue.offer(nums[i]);
        }
        
        int result = 0;
        int count = n-k+1;
        for(int c=0; c<n-k+1; c++)
        {
            result = prioqueue.poll();

        }
        return result;
    }	

}
