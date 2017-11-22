package leetcode161to200;

public class TwoSum_2_InputArraySorted_167 
{
    public int[] twoSum(int[] numbers, int target) 
    {
        int[] result = new int[2];
        if(numbers==null || numbers.length<2) return result;
        int left = 0;
        int right = numbers.length-1;
        while(left<right)
        {
            if((numbers[left]+numbers[right])==target)
            {
                result[0] = left+1;
                result[1] = right+1;
                return result;
            }
            else if((numbers[left]+numbers[right])<target)
            {
                left++;
            }
            else right--;
        }
        return result;
    }

}
