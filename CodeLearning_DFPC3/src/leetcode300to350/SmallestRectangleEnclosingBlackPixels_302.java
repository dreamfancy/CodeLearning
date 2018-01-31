package leetcode300to350;

public class SmallestRectangleEnclosingBlackPixels_302 
{
	
	//Sol 2: Matrix: Binary Search
    public int minArea(char[][] image, int x, int y) 
    {
        if(image==null || image.length==0 || image[0].length==0) return 0;
       
        int m = image.length;
        int n = image[0].length;
        int left = searchLowerValue(image,0,y,true);
        int right = searchHigherValue(image,y,n-1,true);
        int top = searchLowerValue(image,0,x,false);
        int bottom = searchHigherValue(image,x,m-1,false);
        
        return (right-left+1) * (bottom-top+1);
        
    }
    
    private int searchLowerValue(char[][] image, int left, int right, boolean isHor)
    {
        while(left+1<right)
        {
            int mid = left + (right-left)/2;
            if(hasValue(image,mid,isHor))
            {
                right = mid;
            }
            else
            {
                left = mid;
            }
        }
        if(hasValue(image,left,isHor))
        {
            return left;
        }
        return right;
    }
    
    private int searchHigherValue(char[][] image, int left, int right, boolean isHor)
    {
         while(left+1<right)
        {
            int mid = left + (right-left)/2;
            if(hasValue(image,mid,isHor))
            {
                left = mid;
            }
            else
            {
                right = mid;
            }
        }
        if(hasValue(image,right,isHor))
        {
            return right;
        }
        return left;
    }
    
    private boolean hasValue(char[][] image, int x, boolean isHor)
    {
        if(!isHor)
        {
            for(int i=0; i<image[0].length; i++)
            {
                if(image[x][i]=='1') return true;
            }
        }
        else
        {
            for(int i=0; i<image.length; i++)
            {
                if(image[i][x]=='1') return true;
            }
        }
        return false;
    }
	
	
	
	//Sol 1: My solution Time Exceed Limit 
    public int minArea_1(char[][] image, int x, int y) 
    {
        if(image==null || image.length==0 || image[0].length==0) return 0;
        int[] bound = {x,x,y,y};
        helper(image,x,y,bound);
        System.out.println(bound[0] +" " + bound[1] + " " + bound[2] + " " + bound[3]);
        int wide = bound[1]-bound[0]+1;
        int tall = bound[3]-bound[2]+1;
        return wide*tall;
    }
    
    private void helper(char[][] image, int x, int y, int[] bound)
    {
        if(x<bound[0]) bound[0] = x;
        if(x>bound[1]) bound[1] = x;
        if(y<bound[2]) bound[2] = y;
        if(y>bound[3]) bound[3] = y;
        
        if(x>0 && image[x-1][y]=='1')
        {
            image[x][y]='0';
            helper(image,x-1,y,bound);
            image[x][y]='1';
        }
        if(y>0 && image[x][y-1]=='1')
        {
            image[x][y]='0';
            helper(image,x,y-1,bound);
            image[x][y]='1';
        }
        if(x<(image.length-1) && image[x+1][y]=='1')
        {
            image[x][y]='0';
            helper(image,x+1,y,bound);
            image[x][y]='1';
        }
        if(y<(image[0].length-1) && image[x][y+1]=='1')
        {
            image[x][y]='0';
            helper(image,x,y+1,bound);
            image[x][y]='1';
        }
    }

}
