package first100;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class PermutationSequence_60 
{
	//Solution 4:
	public String getPermutation_4(int n, int k) {
	    int pos = 0;
	    List<Integer> numbers = new ArrayList<>();
	    int[] factorial = new int[n+1];
	    StringBuilder sb = new StringBuilder();
	    
	    // create an array of factorial lookup
	    int sum = 1;
	    factorial[0] = 1;
	    for(int i=1; i<=n; i++){
	        sum *= i;
	        factorial[i] = sum;
	    }
	    // factorial[] = {1, 1, 2, 6, 24, ... n!}
	    
	    // create a list of numbers to get indices
	    for(int i=1; i<=n; i++){
	        numbers.add(i);
	    }
	    // numbers = {1, 2, 3, 4}
	    
	    k--;
	    
	    for(int i = 1; i <= n; i++){
	        int index = k/factorial[n-i];
	        sb.append(String.valueOf(numbers.get(index)));
	        numbers.remove(index);
	        k-=index*factorial[n-i];
	    }
	    
	    return String.valueOf(sb);
	}
	
	//Solution 3: Program Creek solution 2
	public String getPermutation_3(int n, int k) {
		boolean[] output = new boolean[n];
		StringBuilder buf = new StringBuilder("");
 
		int[] res = new int[n];
		res[0] = 1;
 
		for (int i = 1; i < n; i++)
			res[i] = res[i - 1] * i;
 
		for (int i = n - 1; i >= 0; i--) {
			int s = 1;
 
			while (k > res[i]) {
				s++;
				k = k - res[i];
			}
 
			for (int j = 0; j < n; j++) {
				if (j + 1 <= s && output[j]) {
					s++;
				}
			}
 
			output[s - 1] = true;
			buf.append(Integer.toString(s));
		}
 
		return buf.toString();
	}
	
	
	//Solution 2: Program Creek solution 1
	public String getPermutation_2(int n, int k) {
		 
		// initialize all numbers
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		for (int i = 1; i <= n; i++) {
			numberList.add(i);
		}
 
		// change k to be index
		k--;
 
		// set factorial of n
		int mod = 1;
		for (int i = 1; i <= n; i++) {
			mod = mod * i;
		}
 
		String result = "";
 
		// find sequence
		for (int i = 0; i < n; i++) {
			mod = mod / (n - i);
			// find the right number(curIndex) of
			int curIndex = k / mod;
			// update k
			k = k % mod;
 
			// get number according to curIndex
			result += numberList.get(curIndex);
			// remove from list
			numberList.remove(curIndex);
		}
 
		return result.toString();
	}
	
	
	
	//My Solution 1: Still not working Logic below is too complex to succeed.
    public String getPermutation_1(int n, int k) 
    {
    	if(n<1 || n>9) return null;
    	
    	int[] jiecheng = new int[n+1];
    	getJieCheng(jiecheng);
    	
    	if(k > jiecheng[n-1]) return null;
    	
    	Set<Integer> leftNums = new TreeSet<Integer>();
    	for(int i=0; i<n; i++)
    	{
    		leftNums.add(i+1);
    	}
    	StringBuilder sb = new StringBuilder();
    	
    	int curp = 1;
    	while(curp<=n-1 && k>0)
    	{
    		int pos = k/jiecheng[n-curp];
            System.out.println("This is the current pos : " + pos);
            if(jiecheng[n-curp]==1) pos--;
    		int curv = getCurDigit(leftNums,pos);
            System.out.println("This is the current digit : " + curv);
    		sb.append(curv);
            System.out.println("This is the current number of difit : " + curp);
            k = k%jiecheng[n-curp];
       		curp++;

    	}
        sb.append(getCurDigit(leftNums,k-1));
        if(!leftNums.isEmpty())
        {
            sb.append(getCurDigit(leftNums,0));
        }
    	return sb.toString();
    }
    
    public int getCurDigit(Set<Integer> leftNums, int pos)
    {
    	Iterator<Integer> iter = leftNums.iterator();
    	for(int i=0; i<pos; i++)
    	{
    		iter.next();
    	}
    	int curDigit = iter.next();
    	leftNums.remove(curDigit);
    	return curDigit;
    }
    public void getJieCheng(int[] result)
    {
    	result[0] = 1;
    	if(result.length==1) return;
    	result[1] = 1;
    	if(result.length==2) return;
    	
    	for(int i=2; i<result.length; i++)
    	{
    		result[i] = result[i-1] * i;
    	}
    }
    /*
    public static void main(String[] args)
    {
    	int[] result = new int[9];
    	getJieCheng(result);
    	for(int i=1; i<9; i++)
    	{
    		//System.out.println(jiecheng(i,result));
    		System.out.println(result[i]);
    	}
    }
	*/
    

}
;