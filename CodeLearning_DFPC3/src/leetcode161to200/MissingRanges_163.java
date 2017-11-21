package leetcode161to200;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges_163 {
    //Sol 1:
	//The first element and last element can be considered seperately
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        if(nums == null) return list;
        int n = nums.length;
        for(int i = 0; i <= n; i++) {
            int lt = (i == 0) ? lower : nums[i - 1] + 1;
            int gt = (i == n) ? upper : nums[i] - 1;
            addRange(list, lt, gt);
        }
        return list;
    }
    private void addRange(List<String> list, int lo, int hi) {
        if(lo > hi) return;
        else if(lo == hi) list.add(String.valueOf(lo));
        else list.add(lo + "->" + hi);
    }
}
