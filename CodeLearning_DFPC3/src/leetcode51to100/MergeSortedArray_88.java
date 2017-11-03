package leetcode51to100;

public class MergeSortedArray_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        
        int cur = m+n-1;
        int curm = m-1;
        int curn = n-1;
        
        while(cur>=0)
        {
            if(curm>=0 && curn>=0)
            {
                if(nums1[curm]>=nums2[curn])
                {
                    nums1[cur--] = nums1[curm--];
                }
                else
                {
                    nums1[cur--] = nums2[curn--];
                }
            }
            else if(curn>=0)
            {
                nums1[cur--] = nums2[curn--];   
            }
            else break;
        }
        
    }
}
