package easyquestions;

public class IslandPerimeter {
	
	public int silandPerimeter(int[][] grid)
	{
		int count = 0;
		for(int i=0; i<grid.length; i++)
		{
			for (int j=0; j<grid[i].length;j++)
			{
				if(grid[i][j] == 1)
				{
					if(j==0)
					{
						count++;
					}
					else if(grid[i][j-1]==0)
					{
						count ++;
					}
					
					if(i==0)
					{
						count++;
					}
					else if(grid[i-1][j] == 0)
					{
						count++;
					}
					
					if(i==grid.length-1)
					{
						count++;
					}
					else if(grid[i+1][j] == 0)
					{
						count++;
					}
					if(j==grid[i].length-1)
					{
						count++;
					}
					else if(grid[i][j+1] == 0)
					{
						count++;
					}
				}
			}
		}
		return count;
	}
	
}
