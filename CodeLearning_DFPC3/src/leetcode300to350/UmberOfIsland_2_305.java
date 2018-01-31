package leetcode300to350;

import java.util.ArrayList;
import java.util.List;

public class UmberOfIsland_2_305 
{
    public List<Integer> numIslands2(int m, int n, int[][] positions) 
    {
        List<Integer> result = new ArrayList<Integer>();
    
        UnionFind uf = new UnionFind(m,n);
        for(int a=0; a<positions.length; a++)
        {
            uf.addElement(positions[a][0],positions[a][1]);
            result.add(uf.count);
        }
        
        return result;
        
    }
    
    
    class UnionFind
	{
		int count = 0;
		int[] id;
        int[][] grid;
		int m;
		int n;
		public UnionFind(int _m, int _n)
		{
            m = _m;
            n = _n;
            grid = new int[m][n];
			id = new int[m*n];
			for(int i=0; i<m*n; i++)
			{
				id[i] = i;
			}
		}
		
        public void addElement(int y, int x)
        {
            count++;
            grid[y][x] = 1;

            if(y>0 && grid[y-1][x]==1) union(y*n+x,(y-1)*n+x);
            if(x>0 && grid[y][x-1]==1) union(y*n+x,y*n+x-1);
            if(y<(m-1) && grid[y+1][x]==1) union(y*n+x,(y+1)*n+x);
            if(x<(n-1) && grid[y][x+1]==1) union(y*n+x,y*n+x+1);
        }
        
		public int find(int p)
		{
			while(p!=id[p])
			{
				id[p] = id[id[p]];
				p = id[p];
			}
			return p;
		}
		/*
		public boolean isConnected(int p, int q)
		{
			int pRoot = find(p);
			int qRoot = find(q);
			if(pRoot!=qRoot) return false;
			return true;
		}
        */
        
		public boolean union(int p, int q)
		{
			int pRoot = find(p);
			int qRoot = find(q);
			if(pRoot==qRoot) return false;
			id[pRoot] = qRoot;
			count--;
			return true;
		}
	}
	
	
	
	//Sol 1: BFS so complicated so disgard
    public List<Integer> numIslands2_1(int m, int n, int[][] positions) 
    {
        List<Integer> result = new ArrayList<Integer>();
        int[][] array = new int[m][n];
        int count = 0;
        
        
        for(int i=0; i<positions.length; i++)
        {
            int y = positions[i][0];
            int x = positions[i][1];
            int left = 0;
            int top = 0;
            int right = 0;
            int bottom = 0;
            
            if(array[y][x] != 0) continue;
            if(x>0 && array[y][x-1]!=0) left = array[y][x-1];
            if(y>0 && array[y-1][x]!=0) top = array[y-1][x];
            if(x<(n-1) && array[y][x+1]!=0) right = array[y][x+1];
            if(y<(m-1) && array[y+1][x]!=0) bottom = array[y+1][x];
    
            //Try To do DFS below but the logic is so complicated!
            
        }
		return result;
    }
}
