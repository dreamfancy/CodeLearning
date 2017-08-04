package string;

public class RegularExpressionMatching_10 
{
	
	//Why use recursion: * has uncertain possibilities
    public boolean isMatch(String s, String p) 
    {
    	/*
    	if(p==null || p.length()==0)
    	{
    		if(s==null || s.length()==0) return true;
    		else return false;
    	}
    	*/
    	
    	if(p.isEmpty()) return s.isEmpty();
    	
    	if(p.length()==1 || p.charAt(1)!='*')
    	{
    		if(s.isEmpty()) return false;
    		if(p.charAt(0)=='.' || p.charAt(0)==s.charAt(0))
    		{
    			return isMatch(s.substring(1),p.substring(1));
    		}
    		else return false;
    	}
    	else
    	{
    		if(p.charAt(1)=='*')
    		{
    			while(s!=null && s.length()!=0 && (p.charAt(0)==s.charAt(0) || p.charAt(0)=='.'))
    			{
    				if (isMatch(s,p.substring(2))==true) return true;
    				else
    				{
    					s = s.substring(1);
    				}
    			}
    		}
    		
    		
    	}
	    return isMatch(s,p.substring(2));

    }
    	/*
    	char[] stringchar = s.toCharArray();
    	char[] patternchar = p.toCharArray();
    	
    	int i=0;
    	int j=0;
    	int slength = s.length();

    	while(i<s.length() && j<p.length())
    	{
    		if(p.charAt(j)!='.' && p.charAt(j)!='*')
    		{
    			if(s.charAt(i)!=s.charAt(j)) return false;
    			i++;
    			j++;
    			continue;
    		}
    		else if(p.charAt(j)=='.')
    		{
    			i++;
    			j++;
    		}
    		else if(p.charAt(j)=='*')
    		{
    			while((p.charAt(j)=='*') || (p.charAt(j)=='.'))
    			{
    				if(j==(p.length()-1)) return true;
    				if(i==s.length()) return false;
    				else if(p.charAt(j)=='*') j++;
    				else if(p.charAt(j)=='.')
    				{
    					i++;
    					j++;
    				}
    			}
    			
    			char curJ = p.charAt(j);
    			
    			while()
    			
    		
    		}
    	}
    	*/
    
    	
    	
    


}
