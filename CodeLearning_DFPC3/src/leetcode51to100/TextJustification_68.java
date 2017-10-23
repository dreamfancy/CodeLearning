package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class TextJustification_68 
{
	//After reading solution 1, I recited the code again
    public List<String> fullJustify(String[] words, int maxWidth) 
    {
        List<String> result = new ArrayList<String>();
        if(words==null || words.length==0) return result;
        int n = words.length;
        int start = 0;
        int end = 1;
        int curlen = 0;
        int intervals = 0;
        while(start<n)
        {
            curlen = words[start].length();
            intervals = 0;
            while(end<n && (curlen+intervals+1+words[end].length())<=maxWidth)
            {
                curlen += words[end].length();
                intervals++;
                end++;
            }
            
            if((end-start)==1)
            {
                StringBuilder sb = new StringBuilder();
                sb.append(words[start]);
                for(int i=curlen; i<maxWidth; i++)
                {
                    sb.append(" ");
                }
                result.add(sb.toString());
            }
            else if(end==n)
            {
                StringBuilder sb = new StringBuilder(words[start]);
                for(int j=(start+1); j<n; j++)
                {
                    sb.append(" ").append(words[j]);
                }
                for(int k=(curlen+intervals); k<maxWidth; k++)
                {
                    sb.append(" ");
                }
                result.add(sb.toString());
            }
            else
            {
                StringBuilder sb = new StringBuilder(words[start]);
                int basicspace = (maxWidth-curlen)/(end-start-1);
                int firstnmorespace = (maxWidth-curlen)%(end-start-1);
                
                for(int i=0; i<firstnmorespace; i++)
                {
                    for(int j=0; j<(basicspace+1); j++)
                    {
                        sb.append(" ");
                    }
                    sb.append(words[start+1+i]);
                }
                
                for(int p=(start+firstnmorespace+1); p<end; p++)
                {
                    for(int q=0; q<basicspace; q++)
                    {
                        sb.append(" ");
                    }
                    sb.append(words[p]);
                }
                result.add(sb.toString());
            }
            start = end;
            end = end+1;
            
        }
        return result;
    }
	
	
	
	
	
	//Solution 1==only solution == best solution
    public List<String> fullJustify_1(String[] words, int maxWidth) 
    {
        List<String> result = new ArrayList<String>();
        if(words==null || words.length==0 || maxWidth<=0) 
        {
            if(maxWidth<=0)
            {
                result.add("");
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                addNSpace(sb, maxWidth);
                result.add(sb.toString());
            }
            return result;            
        }
        
        int n = words.length;
        int[] wordlen = new int[n];
        for(int i=0; i<n; i++)
        {
            wordlen[i] = words[i].length();
        }
        int start = 0;
        int cur = 0;
        int end = 1;   //Why end here !!! shuangzhizhen!
        while(start<n)
        {
        	int intervalnum = 0;
        	int curlen = wordlen[start];
        	while(end<n && intervalnum+curlen+1+wordlen[end]<=maxWidth)
        	{
        		intervalnum++;
        		curlen += wordlen[end];
        		end++;
        	}
        	if(end==n)
        	{
        		StringBuilder sb = new StringBuilder(words[start]);
        		for(int k=start+1; k<end; k++)
        		{
        			sb.append(" " + words[k]);
        		}
        		for(int k=curlen+intervalnum; k<maxWidth; k++)
        		{
        			sb.append(" ");
        			result.add(sb.toString());
        		}
        	}
        	else if(end-start==1)
        	{
        		StringBuilder sb = new StringBuilder(wordlen[start]);
        		for(int i=wordlen[start]; i<maxWidth; i++)
        		{
        			sb.append(" ");
        		}
        		result.add(sb.toString());
        	}
        	else
        	{
        		int space = (maxWidth-curlen)/(end-start-1);
        		int remains = (maxWidth-curlen)%(end-start-1);
        		StringBuilder sb = new StringBuilder(words[start]);
        		for(int k=start+1; k<end; k++)
        		{
        			for(int l=0; l<space; l++) sb.append(" ");
        			if(remains-->0) sb.append(" ");
        			sb.append(words[k]);
        		}
        	}
        	
        	start = end;
        	end = end+1;
        }
        return result;
    }
	
	//My Original Solution: Not Working  !!!Why Wrong
    public List<String> fullJustify_Wrong(String[] words, int maxWidth) 
    {
        List<String> result = new ArrayList<String>();
        if(words==null || words.length==0 || maxWidth<=0) 
        {
            if(maxWidth<=0)
            {
                result.add("");
            }
            else
            {
                StringBuilder sb = new StringBuilder();
                addNSpace(sb, maxWidth);
                result.add(sb.toString());
            }
            return result;            
        }
        
        int num = words.length;
        int[] wordlen = new int[num];
        for(int i=0; i<num; i++)
        {
            wordlen[i] = words[i].length();
        }
        
        int start = 0;
        int cur = 0;
        int curlen = 0;
        int prelen = 0;
        while(cur<num)
        {
            if(cur!=start) curlen++;          
            curlen += wordlen[cur];
    
            if(curlen>maxWidth)
            {
                processOneLine(words,start,cur-1,maxWidth,prelen,result);
                start = cur;
                curlen = 0;
                prelen = 0;
            }
            else
            {
                prelen = curlen;
                cur++;
            }                
        }
        return result;
    }
    public void processOneLine(String[] words, int start, int cur, int maxWidth, int curlen, List<String> result)
    {
        if(start==cur)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(words[start]);
            addNSpace(sb,maxWidth-words[start].length());
            result.add(sb.toString());
            return;
        }
        int numIntervals = cur-start;
        int wordlen = curlen-numIntervals;
        int interval = maxWidth-wordlen;
        int spaceNum = interval/numIntervals;
        int plusOneCount = interval%numIntervals;
        
        StringBuilder sb = new StringBuilder();
        for(int i=start; i<cur; i++)
        {
            sb.append(words[i]);
            if((i-start)<plusOneCount) addNSpace(sb,spaceNum+1);
            else addNSpace(sb,spaceNum);
        }
        sb.append(words[cur]);
        result.add(sb.toString());
    }
    public void addNSpace(StringBuilder sb, int n)
    {
        for(int i=0; i<n; i++)
        {
            sb.append(" ");
        }
        
    }


}
