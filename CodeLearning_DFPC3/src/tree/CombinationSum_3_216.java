package tree;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_3_216 
{
	 public List<List<Integer>> combinationSum3(int k, int n) 
	 {
		 List<List<Integer>> res = new ArrayList<List<Integer>>();
		 if(k<1 || n<1) return res;
		 List<Integer> sol = new ArrayList<Integer>();
		 
		 helper_2(k,n,1,sol,res);
		 return res;
	 }
	 
	 //Solution 3: DFS 2
	 public void helper_3(int leftNum,int leftVal,int curNum,List<Integer> sol,List<List<Integer>> res)
	 {
		 if(leftNum==0 && leftVal==0)
		 {
			 res.add(new ArrayList<Integer>(sol));
			 return;
		 }
		 else if(leftVal<0 || leftNum==0 || curNum>9)
		 {
			 return;
		 }
		 

		 sol.add(curNum);
		 helper_3(leftNum-1,leftVal-curNum,curNum+1,sol,res);
		 sol.remove(sol.size()-1);
		 helper_3(leftNum,leftVal,curNum+1,sol,res);

		 return;
	 }
	 
	 
	 
	 
	 //Solution 2: DFS 1 Optimized: For those generic variables, since it will not be impacted by called sub-function
	 //Please directly write + or - in the argument of the sub-function
	 //Attention the difference of curNum and i
	 public void helper_2(int leftNum,int leftVal,int curNum,List<Integer> sol,List<List<Integer>> res)
	 {
		 if(leftNum==0 && leftVal==0)
		 {
			 res.add(new ArrayList<Integer>(sol));
		 }
		 else if(leftVal<0 || leftNum==0 || curNum>9)
		 {
			 return;
		 }
		 
		 for(int i=curNum; i<=9; i++)
		 {
			 sol.add(i);
			 helper_2(leftNum-1,leftVal-i,i+1,sol,res);
			 sol.remove(sol.size()-1);
		 } 
		 return;
	 }
	 
	 //Solution 1: DFS 1 My initial solution of helper:
	 public void helper_1(int leftNum,int leftVal,int curNum,List<Integer> sol,List<List<Integer>> res)
	 {
		 if(leftNum==0 && leftVal==0)
		 {
			 res.add(new ArrayList<Integer>(sol));
		 }
		 else if(leftVal<0 || leftNum==0 || curNum>9)
		 {
			 return;
		 }
		 
		 for(int i=curNum; i<=9; i++)
		 {
			 leftVal = leftVal - i;
			 leftNum--;
			 sol.add(i);
			 helper_1(leftNum,leftVal,i+1,sol,res);
			 sol.remove(sol.size()-1);
			 leftNum++;
			 leftVal = leftVal + i;
		 } 
		 return;
	 }
    
	
	
	
}
