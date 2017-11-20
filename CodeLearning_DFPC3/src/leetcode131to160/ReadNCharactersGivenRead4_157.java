package leetcode131to160;

public class ReadNCharactersGivenRead4_157 
{
	public int read4(char[] buffer)
	{
		return 0;
	}
	
    public int read(char[] buf, int n) 
    {
       char[] buffer = new char[4];
       int cur = 0;
       boolean end= false;
       while(cur<n && !end)
       {
           int curcount = read4(buffer);
           if(curcount<4) end = true;
           int length = Math.min(n-cur, curcount);
           for(int i=0; i<length; i++)
           {
               buf[cur+i] = buffer[i]; 
           }
           cur = cur+length;
       }
       return cur;
    }
}
