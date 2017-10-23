package leetcode51to100;

import java.util.Stack;

public class SimplifyPath_71 
{
	
	
	
	
	//My Solution Good! Especially use sb.insert(0,str);
    public String simplifyPath(String path) 
    {
        if(path==null || path.length()==0) return "/";
        String[] arr = path.split("/");
        if(arr.length==0) return "/";
        if(arr.length==1) return path;
        
        Stack<String> st = new Stack<String>();
        System.out.println(arr.length);
        for(int i=0; i<arr.length; i++)
        {
            if(arr[i].length()==0 || arr[i].equals(".")) continue;
            else if(arr[i].equals(".."))
            {
                if(!st.isEmpty()) st.pop();
            }
            else
            {
                st.push(arr[i]);
            }
        }
        if(st.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty())
        {
            sb.insert(0,st.pop());
            sb.insert(0,"/");
        }
        
        return sb.toString();
    }

}
