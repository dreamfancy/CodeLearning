package leetcode161to200;

import java.util.ArrayList;
import java.util.List;

public class TwoSum_3_DSdesign_170 
{
    List<Integer> list;
    public TwoSum_3_DSdesign_170() {
     list = new ArrayList<Integer>();   
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        list.add(number);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
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
}
