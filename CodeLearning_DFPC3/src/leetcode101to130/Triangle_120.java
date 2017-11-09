package leetcode101to130;

import java.util.List;

public class Triangle_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) return 0;
        int levelnum = triangle.size();
        List<Integer> nextlevel = triangle.get(levelnum-1);
        for(int i=levelnum-2; i>=0; i--)
        {
            List<Integer> curlevel = triangle.get(i);
            int intnum = curlevel.size();
            for(int j=0; j<intnum; j++)
            {
                curlevel.set(j,curlevel.get(j)+ Math.min(nextlevel.get(j),nextlevel.get(j+1)));
            }
            nextlevel = curlevel;
        }
        return triangle.get(0).get(0);
    }
}
