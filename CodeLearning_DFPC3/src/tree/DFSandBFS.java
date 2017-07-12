package tree;

import java.util.List;

public class DFSandBFS 
{
	
	//DFS_1:
	public void helper_1(char[] array, StringBuilder sb, int index, List<String> result)
	{
		if(index==array.length)
		{
			result.add(sb.toString());
			return;
		}
		sb.append(array[index]);
		helper_1(array,sb,index+1,result);
		
		sb.deleteCharAt(sb.length()-1);
		helper_1(array,sb,index+1,result);
	}
	
	//DFS_2:
	public void helper_2(char[] array, StringBuilder sb, int index, List<String> result)
	{
		if(index==array.length)
		{
			result.add(sb.toString());
			return;
		}
		for(int i=index; i<array.length; i++)
		{
			sb.append(array[i]);
			helper_2(array,sb,index+1,result);
			sb.deleteCharAt(sb.length()-1);
		}
		return; 
	}

	//  BFS:
}
