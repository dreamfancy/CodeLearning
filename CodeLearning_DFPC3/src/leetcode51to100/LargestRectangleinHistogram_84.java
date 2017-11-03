package leetcode51to100;

import java.util.Stack;

public class LargestRectangleinHistogram_84 {
    public int largestRectangleArea(int[] heights) {
        if(heights==null || heights.length==0) return 0;
        if(heights.length==1) return heights[0];
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();
        int i=0;
        //Some cases i++ while some other case i does not change
        //In this way, we can reduce using while in inner loop!!!
        while(i<heights.length)
        {
            if(st.isEmpty() || heights[i]>=heights[st.peek()])
            {
                st.push(i);
                i++;
            }
            else 
            {
                int p = st.pop();
			    int h = heights[p];
			    int w = st.isEmpty() ? i : (i - st.peek() - 1);
			    max = Math.max(h * w, max);
            }
        }
        while(!st.isEmpty())
        {
            int p = st.pop();
            int h = heights[p];
            int w = st.isEmpty() ? i : (i - st.peek() - 1);
			max = Math.max(h * w, max);            
        }
    return max;
    }
}
