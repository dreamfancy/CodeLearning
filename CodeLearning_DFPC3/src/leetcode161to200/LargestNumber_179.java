package leetcode161to200;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber_179 
{
	//Sol 3:
    public String largestNumber(int[] nums) {
        if(nums==null || nums.length==0) return "";
        if(nums.length==1) return nums[0]+"";
        
        int n = nums.length;
        String[] data = new String[n];
        for(int i=0; i<n; i++)
        {
        	data[i] = String.valueOf(nums[i]);
        	
        }
        
        Arrays.sort(data,new Comparator<String>()
                    {
                        @Override
                        public int compare(String data1, String data2)
                        {
                            String s1 = data1+""+data2;
                            String s2 = data2+""+data1;
                            //To avoid overflow as the questions declares, do not change String to Integer!
                            //int i1 = Integer.parseInt(s1);
                            //int i2 = Integer.parseInt(s2);
                            
                            int cur = 0;
                            while(cur<s1.length() && cur<s2.length()) // From how s1 and s2 composes, the s1 length() and s2 length() should be same
                            {
                                if(s1.charAt(cur)>s2.charAt(cur)) return 1;
                                else if(s1.charAt(cur)<s2.charAt(cur)) return -1;
                                else cur++;
                            }
                            return 0; 
                        }
                    });
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=data.length-1; i>=0; i--)
        {            
            if(data[i].equals("0") && flag==false && i!=0) continue;
            sb.append(data[i]);
            flag = true;
        }
        return sb.toString();       
    }
	
	
	
	//sol 2:change int to Integer to make sure the Comparator generic is object
	//But still bad as Integer will overflow. So the best solution is
	//to change int array to String array to compare, see sol 3
    public String largestNumber_2(int[] nums) {
        if(nums==null || nums.length==0) return "";
        if(nums.length==1) return nums[0]+"";
        
        int n = nums.length;
        Integer[] data = new Integer[n];
        for(int i=0; i<n; i++)
        {
        	data[i] = new Integer(nums[i]);
        	
        }
        
        Arrays.sort(data,new Comparator<Integer>()
                    {
                        @Override
                        public int compare(Integer num1, Integer num2)
                        {
                            String s1 = num1+""+num2;
                            String s2 = num2+""+num1;
                            int i1 = Integer.parseInt(s1);
                            int i2 = Integer.parseInt(s2);
                            return i1-i2;
                        }
                    });
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--)
        {
            sb.append(nums[i]);
        }
        return sb.toString();
            
    }
	
	
	//Sol 1: build the comparator based on int!!!
	//Why it is wrong!!!
	//https://stackoverflow.com/questions/3699141/how-to-sort-an-array-of-ints-using-a-custom-comparator
    /*
    public String largestNumber_sol1_wrong(int[] nums) {
        if(nums==null || nums.length==0) return "";
        if(nums.length==1) return nums[0]+"";
        
        int n = nums.length;
        
        Arrays.sort(nums,new Comparator<Integer>()
                    {
                        @Override
                        public int compare(Integer num1, Integer num2)
                        {
                            String s1 = num1+""+num2;
                            String s2 = num2+""+num1;
                            int i1 = Integer.parseInt(s1);
                            int i2 = Integer.parseInt(s2);
                            return i1-i2;
                        }
                    });
        StringBuilder sb = new StringBuilder();
        for(int i=nums.length-1; i>=0; i--)
        {
            sb.append(nums[i]);
        }
        return sb.toString();
            
    }
    */
}
