package leetcode201to250;

public class ShortestWordDistance_243 
{
    public int shortestDistance(String[] words, String word1, String word2) 
    {
        if(words==null || words.length==0) return -1;
        
        boolean foundfirst = false;
        boolean foundsecond = false;
        int first = -1;
        int second = -1;
        int curmin = Integer.MAX_VALUE;
        for(int i=0; i<words.length; i++)
        {
            if(words[i].equals(word1))
            {
                first = i;
                foundfirst = true;
                if(foundfirst && foundsecond)
                     curmin =  Math.min(curmin,Math.abs(first-second));
            }
            else if (words[i].equals(word2))
            {
                second = i;
                foundsecond = true;
                if(foundfirst && foundsecond)
                    curmin =  Math.min(curmin,Math.abs(first-second));
            }       
       }
        return curmin;       
    }
	

}
