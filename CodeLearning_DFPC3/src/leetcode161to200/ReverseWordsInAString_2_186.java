package leetcode161to200;

public class ReverseWordsInAString_2_186 
{
    public void reverseWords(char[] str) {
        if(str==null || str.length<2) return;
        int n = str.length;
        reverse(str,0,n-1);
        int left = 0, right = 0;
        while(str[left]==' ') left++;
        right = left;
        while(right<n)
        {
            while(right<n && str[right]!=' ') right++;
            reverse(str,left,right-1);
            if(right==n) break;
            left = right;
            while(left<n && str[left]==' ')left++;
            right = left;
                
        }
        
    }
    
    private void reverse(char[] str, int start, int end)
    {
        while(start<end)
        {
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
    }
}
