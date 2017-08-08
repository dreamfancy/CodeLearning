package string;

public class CountAndSay_38 
{
	//DP Solution
	public String countAndSay_Iter(int n) 
    {
    	String cur = "1";
    	if(n==1) return cur;	
    	for(int i=2; i<=n; i++)
    	{
    		cur = countAndSay_helper(cur);
    	}
    	
    	return cur;
    }
	
	
	//Recursion Solution
    public String countAndSay_recur(int n) 
    {
    	if(n==1) return "1";	
    	return countAndSay_helper(countAndSay_recur(n-1));
    	
    }

    public String countAndSay_helper(String ori) 
    {
        //String ori = new String(Integer.toString(n));
        StringBuilder sb = new StringBuilder();
        
        char pre = ori.charAt(0);
        int count = 1;
        
        for(int i=1; i<ori.length(); i++)
        {
            if(ori.charAt(i) == pre)
            {
                count++;
                continue;
            }
            
            sb.append(count).append(pre);
            count = 1;
            pre = ori.charAt(i);
        }
        
        sb.append(count).append(pre);
        
        return sb.toString();
    }
    
    
    
    
    
	//Another solution for the interview question
    public String countAndSay_helper(int n) 
    {
        String ori = new String(Integer.toString(n));
        StringBuilder sb = new StringBuilder();
        
        char pre = ori.charAt(0);
        int count = 1;
        
        for(int i=1; i<ori.length(); i++)
        {
            if(ori.charAt(i) == pre)
            {
                count++;
                continue;
            }
            
            sb.append(count).append(pre);
            count = 1;
            pre = ori.charAt(i);
        }
        
        sb.append(count).append(pre);
        
        return sb.toString();
    }

    
    
    
    public static void intToString(int n)
    {
    	//String res = new String(Integer.toBinaryString(n));
    	String res = new String(Integer.toString(n));
    	System.out.println(res);
    	
    }
    
    /*
    public static void main(String[] args)
    {
    	intToString(100);
    }
    */
}
