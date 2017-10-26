package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length==0) return result;
        
        List<Integer> cursol = new ArrayList<Integer>();
        
        subsets(nums,0,cursol,result);
        return result;
        
    }
    
    public void subsets(int[] nums, int cur, List<Integer> cursol, List<List<Integer>> result)
    {
        if(cur>nums.length) return;
        if(cur==nums.length)
        {
            result.add(new ArrayList<Integer>(cursol));
            return;
        }
        
        subsets(nums,cur+1,cursol,result);
        cursol.add(nums[cur]);
        subsets(nums,cur+1,cursol,result);
        cursol.remove(cursol.size()-1);
    }
}
