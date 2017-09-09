package first100;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class NextPermutation_31 
{
	//Solution : Official optimize the logic of my solution_2 below:
    public void official(int[] nums) 
    {
    	if(nums==null || nums.length<2) return;
        if(nums.length==2)
        {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        
        int last = nums.length-1;
    	int p1 = 0;
    	
    	for(int i= nums.length-2; i>=0; i--)
    	{
    		if(nums[i]<nums[i+1])
    		{
    			p1 = i;
    			break;
    		}
    	}
    	
    	int p2 = 0;
    	for(int j= nums.length-1; j>p1; j--)
    	{
    		if(nums[j]>nums[p1])
    		{
    			p2 = j;
    			break;
    		}
    	}
    	
    	if(p1==0 && p2==0)
    	{
    		reverse(nums,0,nums.length-1);
    		return;
    	}
    	
    	int temp = nums[p1];
    	nums[p1] = nums[p2];
    	nums[p2] = temp;
    	
    	reverse(nums,p1+1,nums.length-1);
    }
    
    public void reverse(int[] nums, int left, int right){
        while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
	//Solution : My solution 2
	//Logical good but need to optimize to avoid mistakes
	//Think the complete logic with fake code first, then implement code
    public void nextPermutation_MySoltion_2(int[] nums) 
    {
    	if(nums==null || nums.length<2) return;
        if(nums.length==2)
        {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
        
        int last = nums.length-1;
    	int p1 = last;
    	int pre = nums[last];
    	while(p1>=0 && nums[p1]>=pre)
    	{
       		pre = nums[p1];
    		p1--;
    	}
    	if(p1<0) p1++;
        int point1;
        int point2;
        
        //if(nums[p1]>=nums[p1+1])
        //{
    	    point1 = nums[p1];
            point2 = nums[p1+1];
    	
    	    int p2 = last;
    	    while(p2>=0 && nums[p2]<=point1) p2--;
            if(p2<0) p2++;
    	
    	//int point2 = nums[p2];
        
        int left, right;
        
    	if(p1!=0 || p2!=0)
        {
    	    int temp = nums[p1];
    	    nums[p1] = nums[p2];
    	    nums[p2] = temp;
            
            left = p1+1;
    	    right = last;
        }
        else
        {
            left = 0;
            right = last;
        }
    	
    	
    	
    	while(left<right)
    	{
    		int temp1 = nums[left];
    		nums[left] = nums[right];
    		nums[right] = temp1;
    		left++;
    		right--;
    	}
    }
	
	
	
	//My Solution 1: With extra space treeMap
	//Logic is wrong, invalid
    public void nextPermutation_mysolution(int[] nums) 
    {
    	if(nums==null || nums.length<2) return;
        if(nums.length==2)
        {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
            return;
        }
    	int cur = nums.length-1;
    	int max = nums[nums.length-1];
        int min = nums[nums.length-1];
    	//Set<Integer> treeSet = new TreeSet<Integer>();
    	Map<Integer,Integer> treeMap = new TreeMap<Integer,Integer>();
    	//treeMap.put(nums[nums.length-1],1);
        boolean incr = false;
        boolean decr = false;
    
    	while(cur>=0 && (incr==false || decr == false))
    	{
    		if(nums[cur]>max) 
            {
                decr = true;
                max = nums[cur];
            }
            if(nums[cur]<min) 
            {
                incr = true;
                min = nums[cur];
            }
    		if(treeMap.containsKey(nums[cur]))
    		{
    			treeMap.put(nums[cur], treeMap.get(nums[cur])+1);
    		}
    		else
    		{
    			treeMap.put(nums[cur], 1);
    		}
    		cur--;
    	}
        cur++;
    
        System.out.println("incr: " + incr + "   decr: " +decr);
        System.out.println("current cur is " + cur);

        if(decr==false)
        {
        	int pos = nums.length-1;
        	while(pos>=0 && nums[pos]==nums[pos-1])
        	{
        		pos--;
        	}
        	if(pos>0)
        	{
        		int temp = nums[pos];
        		nums[pos] = nums[pos-1];
        		nums[pos-1] = temp;
        	}
        	return;
        }
       
    	Set<Integer> keySet = treeMap.keySet();
    	Iterator<Integer> iter = keySet.iterator();
    	while(iter.hasNext())
    	{
    		int val = iter.next();
            System.out.println();
            System.out.print(val +"  ");
            System.out.println();

    		int count = treeMap.get(val);
    		for(int i=0; i<count; i++)
    		{
                System.out.println("cur is" + cur);
    			nums[cur++] = val;
    		}
    	}
    	
    }
}
