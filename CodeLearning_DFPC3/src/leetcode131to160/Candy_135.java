package leetcode131to160;

public class Candy_135 
{
    public int candy(int[] ratings) 
    {
        if(ratings==null || ratings.length==0) return 0;
        if(ratings.length==1) return 1;
        
        int n = ratings.length;
        int[] candy = new int[n];
        
        for(int i=0; i<n; i++)
        {
            candy[i] = 1;
        }
        
        for(int j=1; j<n; j++)
        {
            if(ratings[j]>ratings[j-1])
            {
                candy[j] = candy[j-1] + 1;
            }
        }
        for(int k=n-2; k>=0; k--)
        {
            if(ratings[k]>ratings[k+1])
            {
                if(candy[k]<=candy[k+1])
                {
                    candy[k] = candy[k+1] + 1;
                }
            }
        }
        
        int sum = 0;
        for(int l=0; l<n; l++)
        {
            sum += candy[l];
        }
        
        return sum;
    }

}
