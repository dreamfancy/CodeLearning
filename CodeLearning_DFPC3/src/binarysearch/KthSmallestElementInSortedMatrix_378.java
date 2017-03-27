package binarysearch;

import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix_378 {
	
	/*
	//Priority Queue
    public int kthSmallest_2(int[][] matrix, int k) 
	{
    	
    	int n = matrix.length;
        PriorityQueue<int[]> heap=new PriorityQueue<int[]>(new Comparator<int[]>(){
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });		
		int[] peak = new int[3];
		heap.offer(first);
		
		while(k-->0)
		{
			peak = heap.poll();
			if(peak[1]+1<n)
			{
				heap.offer(new int[]{matrix[peak[1]+1][peak[2]],peak[1]+1,peak[2]});
			}
            if(peak[1]==0&&peak[2]+1<n){
                heap.offer(new int[]{matrix[peak[1]][peak[2]+1],peak[1],peak[2]+1});
            }
		}
	
	
	return peak[0];
	
	}
	*/
	//Binary search on "Result",row-column taking turn scan to get 
	//how many elements are below the value in the matrix
    public int kthSmallest_1(int[][] matrix, int k) {
    	
    	int n = matrix.length;
    	int start = matrix[0][0];
    	int end = matrix[n-1][n-1];
    	
    	while(start<end)
    	{
    		int mid = start + ((end-start)>>1);
    		int count = binarySearch(matrix,mid);
    		if(count<k)
    			start = mid+1;
    		else
    			end = mid;
    		//Attention why end need to have mid but start should be mid+1;
    		//This depends on the feature of Integer divider /
    		
    	}
    	return start;
     	
    }
    
    private int binarySearch(int[][]matrix, int target)
    {
    	int n = matrix.length;
    	int i=n-1,j=0,count=0;
    	
    	while(i>=0 &&j<n)
    	{
    		if(matrix[i][j]<=target)	
    		{
    			j++;
    			count+=i+1;
    		}
    		else
    		{
    			i--;
    		}
    	}
    	return count;
    }
	
	
	
	
	//My Attempt: Thought is ok but something is wrong (missing from the algorithm)
    public int kthSmallest(int[][] matrix, int k) {
    	
    	int n = matrix.length;

    	if(k>n*n || k<=0) return -1;
    	
    	int cur = 1;
    	while(cur<=n)
    	{
    		if(cur*cur<=k && (cur+1)*(cur+1)>k)
    			break;
    		cur++;
    	}
    	
    	if(cur*cur == k) return matrix[cur-1][cur-1];
    	
    	int a=0,b=0;
    	int count = k - cur*cur;
    	while(a!=(cur+1) && b!=(cur+1))
    	{
    		if(matrix[a][cur] < matrix[cur][b])
    		{
    			a++;
    			count--;
    			System.out.println("a: "+ count);
    			if(count==0) return matrix[--a][cur];
    		}
    		else if(matrix[a][cur] >= matrix[cur][b])
    		{
    			b++;
    			count--;
    			System.out.println("b: "+ count);

    			if(count==0) return matrix[cur][--b];
    		}	
    	}
    	if(a==(cur+1))
    	{
    		while(count!=0)
    		{
    			b++;
    			count--;
    		}
    		return matrix[cur][b];
    	}
    	
    	if(b==(cur+1))
    	{
    		while(count!=0)
    		{
    			a++;
    			count--;
    		}
    		return matrix[a][cur];
    	}	
    	return -1;
    }
    	

}
