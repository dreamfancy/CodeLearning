package dp;

public class MaximumSquare_221 
{
	
	//It is a char[][] matrix!!! Be alert!
	//Attention! what is to return ! It is side * side
    public int maximalSquare(char[][] matrix) 
    { 
        int squareside = 0;
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return 0;
        int m = matrix[0].length;
        int n = matrix.length;
        int[][] dp = new int[n][m];
        
        for(int i=0; i<m; i++)
        {
            if(matrix[0][i]=='1') 
            {
                dp[0][i] = 1;
                squareside = 1;
                System.out.println("Here 1");
            }
        }
        
        for(int j=0; j<n; j++)
        {
            if(matrix[j][0]=='1') 
            {
                dp[j][0] = 1;
                squareside = 1;
                System.out.println("Here 2");

            }
        }
        
        for(int k=1; k<n; k++)
        {
            for(int l=1; l<m; l++)
            {
                if(matrix[k][l]=='0') dp[k][l] = 0;
                else
                {
                    System.out.println("Here 3");
                    dp[k][l] = Math.min(Math.min(dp[k-1][l],dp[k-1][l-1]),dp[k][l-1])+1;
                    if(squareside<dp[k][l]) squareside = dp[k][l];
                }
            }
        }
        return squareside * squareside;
    }

}
