package leetcode201to250;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_3_216 
{
    public List<List<Integer>> combinationSum3(int k, int n) 
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(k<=0 || 9*k<n || k>n) return result;
        List<Integer> cursol = new ArrayList<Integer>();
        
        combinationSum3Helper(k,n,1,cursol,result);
        return result;
    }
    
    public void combinationSum3Helper(int k, int n, int cur, List<Integer> cursol, List<List<Integer>> result)
    {
        if(k==0 && n==0)
        {
            result.add(new ArrayList<Integer>(cursol));
            return;
        }
        else if(k==0 || cur>9 || n<0) return;
        
        for(int i=cur; i<=9; i++)
        {
            cursol.add(i);
            combinationSum3Helper(k-1,n-i,i+1,cursol,result);
            cursol.remove(cursol.size()-1);
        }
        return;
    }

}
