package leetcode161to200;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum_3_DSdesign_170 
{
	//sol 3: use HashMap + list
    private List<Integer> list = new ArrayList<Integer>();
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
	public void add(int number) {
	    if (map.containsKey(number)) map.put(number, map.get(number) + 1);
	    else {
	        map.put(number, 1);
	        list.add(number);
	    }
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    for (int i = 0; i < list.size(); i++){
	        int num1 = list.get(i), num2 = value - num1;
	        if ((num1 == num2 && map.get(num1) > 1) || (num1 != num2 && map.containsKey(num2))) return true;
	    }
	    return false;
	}
	
	
	
	
	/*
	//sol 2: More space, less time
	Set<Integer> valueset;
	Set<Integer> sumset;
	
    public TwoSum_3_DSdesign_170() {
        // The following two lines are Wrong!!! Think about why!!!
    	//Set<Integer> valueset = new HashSet<Integer>();
        //Set<Integer> sumset = new HashSet<Integer>();    
    	valueset = new HashSet<Integer>();
    	sumset = new HashSet<Integer>();
     
    }
    
    public void add(int number) {
    	if(valueset.contains(number))
    	{
    		sumset.add(number*2);
    	}
    	else
    	{
    		Iterator<Integer> iter = valueset.iterator();
    		while(iter.hasNext())
    		{
    			sumset.add(iter.next()+number);
    		}
    		valueset.add(number);
    	}
    	
    }
    
    public boolean find(int value) {
       return sumset.contains(value);
    }
	*/
	
	
	//Sol 1: Less space, more time. will overtime
	/*
    List<Integer> list;
    public TwoSum_3_DSdesign_170() {
     list = new ArrayList<Integer>();   
    }
    
    public void add(int number) {
        list.add(number);
    }
    
    public boolean find(int value) {
        boolean flag = false;
        for(int num: list)
        {
            if(list.contains(value-num)) 
            {
                if((value-num)==num && flag==false) 
                {
                    flag = true;
                }
                else return true;
            }
        }
        return false;
    }
    */
	
}
