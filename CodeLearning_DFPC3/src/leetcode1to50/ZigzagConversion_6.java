package leetcode1to50;

public class ZigzagConversion_6 
{
	//My Solution_Use this
	//Note 1: As stringBuilder array, when genrate the result, you can directly use the first one 
	//Note 2: for loop the middle section can have && for more than one conditions
    public String convert(String s, int numRows) 
    {
        if(s==null || s.length()==0) return s;
        
        int len = s.length();
        //int numCols = len/2;
        
        //char[][] charArr = new char[numRows][numCols];
        StringBuilder[] sbArray = new StringBuilder[numRows];
        for(int i=0; i<sbArray.length; i++)
        {
        	sbArray[i] = new StringBuilder();
        }

        int cur = 0;
    
        while(cur<len)
        {
            for(int j=0; (j<numRows) && (cur<len); j++)
            {
            	sbArray[j].append(s.charAt(cur++));
               //if(cur==len) return printcharArray(sbArray);
            }
            for(int j=numRows-2; (j>0) && (cur<len); j--)
            {
            	sbArray[j].append(s.charAt(cur++));
                //if(cur==len) return printcharArray(sbArray);
            }
        }
        
            return printcharArray(sbArray);
    }
    
    public String printcharArray(StringBuilder[] sbArray)
    {
    	//StringBuilder result = new StringBuilder();
         
        for(int i=1; i<sbArray.length; i++)
        {
           sbArray[0].append(sbArray[i]);
        }
        return sbArray[0].toString();  //substring no upper case but toString S is upper case
        
    }

    
    //Leetcode TopRated Solution: Not recommend
    //But remember:
    //Without initialize the char array, each element is '\u0000'
    
    public String convert_LCTopRated(String s, int numRows) {
        if(numRows  == 1 ) {
            return s;
        }
        int len = s.length();
        int row = 2 * numRows - 2;
        int col = len % row == 0 ? len / row : len / row + 1;
        char[][] matrix = new char[row][col];
        char[] array = s.toCharArray();
        int r = 0;
        int c = 0;
        for(int i = 0; i < array.length; i++) {
            if(r == row) {
                r = 0;
                c = c + 1;
            }
            matrix[r++][c] = array[i];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < col; j++) {
                if(matrix[i][j] == '\u0000') {
                    continue;
                }
                if(i == 0 || i == numRows - 1) {
                    sb.append(matrix[i][j]);
                } else {
                    sb.append(matrix[i][j]);
                    if(matrix[2 * (numRows - 1) - i][j] != '\u0000') {
                         sb.append(matrix[2 * (numRows - 1) - i][j]);
                    }
                }
            }
        }
        return sb.toString();
    }
}
