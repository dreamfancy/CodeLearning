package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence_60 
{
	
	//Official Solution
    public String getPermutation_2(int n, int k) {
        List<Integer> nums=new ArrayList<>();
        for(int i=1; i<=n; i++) nums.add(i);
        int[] fact = new int[n+1];
        fact[0]=1;
        for(int i=1; i<=n; i++) fact[i]=i*fact[i-1];
        k--;
        StringBuilder sb = new StringBuilder();
        for(int i=n; i>0; i--){
            int idx=k/fact[i-1];
            k=k%fact[i-1];
            sb.append(nums.get(idx));
            nums.remove(idx);
        }
        return sb.toString();
    }

	//My Original Solution: Pass but ugly
    public String getPermutation_1(int n, int k) 
    {
        if(k<=0 || n<=0) return "";
        if(n==1)
        {
            return k==1 ? "1" : "";
        }
        boolean[] digits = new boolean[n];
        StringBuilder sb = new StringBuilder();
        k--;   //!!!Important !!! Sync the real number to array index
        for(int digit=1; digit<=n; digit++)  //Use for loop becuase the operation should be done n times only!!!
        {
            int cur = k/jiecheng(n-digit);  //!!!Why k-- Analyze this sentence
            int curNum = getKthLeftDigit(cur+1,digits);
            System.out.println(curNum);
            sb.append(curNum);
            k = k%jiecheng(n-digit);
        }
        
        return sb.toString();
    }
    
    public int getKthLeftDigit(int cur, boolean[] digits)
    {
        for(int i=0; i<digits.length; i++)
        {
            if(digits[i]==false)
            {
                cur--;
            }
            if(cur==0)
            {
                digits[i] = true;
                return i+1;
            }
        }
        
        return -1;
    }
    
    public int jiecheng(int n)
    {
        if(n==0 || n==1) return 1;
        return n*jiecheng(n-1);
    }
}

