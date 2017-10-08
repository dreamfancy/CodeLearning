package leetcode1to50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_18 
{
	//Official solution 2:
	//Another way of jianzhi (break for unnecessary approach)
	public List<List<Integer>> fourSum_2(int[] num, int target) {
	    ArrayList<List<Integer>> ans = new ArrayList<>();
	    if(num.length<4)return ans;
	    Arrays.sort(num);
	    for(int i=0; i<num.length-3; i++){
	        if(num[i]+num[i+1]+num[i+2]+num[i+3]>target)break; //first candidate too large, search finished
	        if(num[i]+num[num.length-1]+num[num.length-2]+num[num.length-3]<target)continue; //first candidate too small
	        if(i>0&&num[i]==num[i-1])continue; //prevents duplicate result in ans list
	        for(int j=i+1; j<num.length-2; j++){
	            if(num[i]+num[j]+num[j+1]+num[j+2]>target)break; //second candidate too large
	            if(num[i]+num[j]+num[num.length-1]+num[num.length-2]<target)continue; //second candidate too small
	            if(j>i+1&&num[j]==num[j-1])continue; //prevents duplicate results in ans list
	            int low=j+1, high=num.length-1;
	            while(low<high){
	                int sum=num[i]+num[j]+num[low]+num[high];
	                if(sum==target){
	                    ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
	                    while(low<high&&num[low]==num[low+1])low++; //skipping over duplicate on low
	                    while(low<high&&num[high]==num[high-1])high--; //skipping over duplicate on high
	                    low++; 
	                    high--;
	                }
	                //move window
	                else if(sum<target)low++; 
	                else high--;
	            }
	        }
	    }
	    return ans;
	}
	
	//My Solution == Official Solution 1! It is good. Please revisit!
    public List<List<Integer>> fourSum(int[] nums, int target) 
    {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if(nums==null || nums.length<=3) return result;
    	
    	Arrays.sort(nums);
    	
    	for(int i=0; i<nums.length-3; i++)
    	{
    		if(i!=0 && nums[i]==nums[i-1]) continue;  //Revisit
    		for(int j=i+1; j<nums.length-2; j++)
    		{
        		if(j!=(i+1) && nums[j]==nums[j-1]) continue;

    			int left = j+1;
    			int right = nums.length-1;
    			while(left<right)
    			{
    				if((nums[i]+nums[j]+nums[left]+nums[right])==target)
    				{
    					List<Integer> sol = new ArrayList<Integer>();
    					sol.add(nums[i]);
    					sol.add(nums[j]);
    					sol.add(nums[left]);
    					sol.add(nums[right]);
    					result.add(sol);
        				while(left<right && nums[left]==nums[left+1]) left++;  //Revisit
        				while(left<right && nums[right]==nums[right-1]) right--;
        				left++;
                        right--;
    				}
    				else if ((nums[i]+nums[j]+nums[left]+nums[right])<=target)
    				{
    					left++;
    					
    				}
    				else 
    				{
    					right--;
    				}
    			}
    		}
    	}
    	
    	return result;
    	
        
    }

}
