package leetcode1to50;

public class MultiplyStrings_43 
{
    public String multiply(String num1, String num2) 
    {
        if(num1==null || num2==null) return "";
        
        int m = num1.length();
        int n = num2.length();
        if(m==0 || n==0) return "";
        
        int[] data1 = new int[m];
        int[] data2 = new int[n];
        
        for(int i=0; i<m; i++)
        {
            data1[i] = num1.charAt(i)-'0';
        }
        
        for(int j=0; j<n; j++)
        {
            data2[j] = num2.charAt(j)-'0';
        }
        
        int[] res = new int[m+n];
        
        for(int p=m-1; p>=0; p--)
        {
            for(int q=n-1; q>=0; q--)
            {
                int product = data1[p] * data2[q] + res[p+q+1];
                res[p+q+1] += product%10; //REvisit !!!Why there is + here !!!
                res[p+q] += product/10;   //REvisit !!!Why there is + here !!!
            }
        }
         StringBuilder sb = new StringBuilder();
        
        //if(res[0] != 0) sb.append(res[0]);
        /*
        for(int k=0; k<(m+n); k++)
        {
            if(res[k]==0 && sb.length()==0) continue;
        
            
            sb.append(res[k]);
        }
        */
    
        for(int c : res)
        {
        	if(c==0 && sb.length()==0) continue;
        	sb.append(c);
        }
        if(sb.length()==0) return "0";
        
        return sb.toString();
        
    }
}
