package leetcode51to100;

import java.util.ArrayList;
import java.util.List;

public class GrayCode_89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n<0) return res;
        res.add(0);
        if(n==0) return res;
        res.add(1);
        if(n==1) return res;

        for(int i=2; i<=n; i++)
        {
            int curmark = 1<<(i-1);
            int curlen = res.size();
            for(int j=curlen-1; j>=0; j--)
            {
                res.add(curmark | res.get(j));
            }
        }    
        return res;
    }
}
