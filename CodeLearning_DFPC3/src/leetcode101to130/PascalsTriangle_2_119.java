package leetcode101to130;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_2_119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex = rowIndex+1;
        List<Integer> firstRow  = new ArrayList<Integer>();
        if(rowIndex==0) return firstRow;
        firstRow.add(1);
        if(rowIndex==1 || rowIndex==0) return firstRow;
        List<Integer> preRow = new ArrayList<Integer>();
        preRow.add(1);
        preRow.add(1);
        if(rowIndex==2) return preRow;
        
        for(int i=3; i<=rowIndex; i++)
        {
            List<Integer> curRow  = new ArrayList<Integer>();
            curRow.add(1);
            for(int j=0; j<preRow.size()-1; j++)
            {
                curRow.add(preRow.get(j) + preRow.get(j+1));
            }
            curRow.add(1);
            preRow = curRow;
        }
        return preRow;
    }
}
