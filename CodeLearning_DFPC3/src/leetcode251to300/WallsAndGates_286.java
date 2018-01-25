package leetcode251to300;

public class WallsAndGates_286 
{
    public void wallsAndGates(int[][] rooms) 
    {
        if(rooms==null || rooms.length==0 || rooms[0].length==0) return;
        
        int rowlen = rooms.length;
        int collen = rooms[0].length;
        
        for(int i=0; i<rowlen; i++)
        {
            for(int j=0; j<collen; j++)
            {
                if(rooms[i][j]==0)
                {
                    expendcurgate(rooms, i, j, 0);
                }
            }
        }        
    }
    
    private void expendcurgate(int[][] room, int i, int j, int num)
    {
        if(i>0 && room[i-1][j]>0 && room[i-1][j]>(num+1))
        {
            room[i-1][j] = num+1;
            expendcurgate(room,i-1,j,num+1);
        }
        if(i<room.length-1 && room[i+1][j]>0 && room[i+1][j]>(num+1))
        {
            room[i+1][j] = num+1;
            expendcurgate(room,i+1,j,num+1);
        }
        if(j>0 && room[i][j-1]>0 && room[i][j-1]>(num+1))
        {
            room[i][j-1] = num+1;
            expendcurgate(room,i,j-1,num+1);
        }
        if(j<room[0].length-1 && room[i][j+1]>0 && room[i][j+1]>(num+1))
        {
            room[i][j+1] = num+1;
            expendcurgate(room,i,j+1,num+1);
        }
    }
	

}
