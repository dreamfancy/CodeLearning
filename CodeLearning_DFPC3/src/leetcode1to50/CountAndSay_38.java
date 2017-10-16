package leetcode1to50;

public class CountAndSay_38 {
	
	//My Solution 2:
	//The only difference from solution 1 is that StringBuilder also has charAt() method
    public String countAndSay_2(int n) {
        if(n<=0) return new String();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        StringBuilder cur = sb;

        for(int j=1; j<n; j++)
        {
            sb = new StringBuilder();
            int count = 0;
            for(int i=0; i<cur.length(); i++)
            {
                if(i==0 || cur.charAt(i)==cur.charAt(i-1))
                    count++;
                else
                {
                    sb.append(count).append(cur.charAt(i-1));
                    count = 1;
                }                
            }
            sb.append(count).append(cur.charAt(cur.length()-1));
            cur = sb;
        }
        
        return cur.toString();
    }
	
	
	//My Solution 1:
    public String countAndSay_1(int n) 
    {
        if(n<=0) return new String();
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        String cur = sb.toString();

        for(int j=1; j<n; j++)
        {
            sb = new StringBuilder();
            int count = 0;
            for(int i=0; i<cur.length(); i++)
            {
                if(i==0 || cur.charAt(i)==cur.charAt(i-1))
                    count++;
                else
                {
                    sb.append(count).append(cur.charAt(i-1));
                    count = 1;
                }                
            }
            sb.append(count).append(cur.charAt(cur.length()-1));
            cur = sb.toString();
        }
        return cur;   
    }
}
