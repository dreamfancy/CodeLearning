package leetcode101to130;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows==0) return result;
        List<Integer> firstRow  = new ArrayList<Integer>();
        firstRow.add(1);
        result.add(firstRow);
        if(numRows==1) return result;
        List<Integer> preRow = new ArrayList<Integer>();
        preRow.add(1);
        preRow.add(1);
        result.add(preRow);
        if(numRows==2) return result;
        
        for(int i=3; i<=numRows; i++)
        {
            List<Integer> curRow  = new ArrayList<Integer>();
            curRow.add(1);
            for(int j=0; j<preRow.size()-1; j++)
            {
                curRow.add(preRow.get(j) + preRow.get(j+1));
            }
            curRow.add(1);
            result.add(curRow);
            preRow = curRow;
        }
        return result;
    }
}
