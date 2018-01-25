package leetcode251to300;

public class HIndex_2_275 
{
    public int hIndex(int[] citations) 
    {
        //Assuming the citations already getting sorted
        if(citations==null || citations.length==0) return 0;
        int len = citations.length;
        if(len==1) return citations[0]>=1 ? 1:0;
        int low = 0, high = len - 1;
        
        while(low<high-1)
        {
            int mid = low + (high-low)/2;
            if(citations[mid]==(len-mid)) return (len-mid);
            else if(citations[mid]<(len-mid)) low = mid;
            else high = mid;
        }
        if(citations[low]>=(len-low)) return len-low;
        else if(citations[high]>=len-high) return len-high; 
        
        return 0;
    }	

}
