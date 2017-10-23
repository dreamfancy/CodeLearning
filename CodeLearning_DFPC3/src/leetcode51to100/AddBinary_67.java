package leetcode51to100;

public class AddBinary_67 {
	
	
	//My Solution:
    public String addBinary(String a, String b) {
        if(a==null || a.length()==0) return b;
        if(b==null || b.length()==0) return a;
        
        int alen = a.length();
        int blen = b.length();
        String shortstr = alen<=blen ? a : b;
        String longstr = alen>blen ? a : b;
        int minlen = shortstr.length();
        int maxlen = longstr.length();
        StringBuilder sb = new StringBuilder();
        int next = 0;
        for(int i=0;i<minlen; i++)
        {
            int sum = shortstr.charAt(minlen-1-i)-'0' + longstr.charAt(maxlen-1-i)-'0' + next;
            System.out.println(sum);
            sb.append(sum%2);
            next = sum/2;
        }
        System.out.println(next);
        for(int i=minlen; i<maxlen; i++)
        {
            int sum = longstr.charAt(maxlen-1-i) -'0' + next;
            sb.append(sum%2);
            next = sum/2;
        }
        if(next==1) sb.append(1);
        
        return sb.reverse().toString();
        
    }
}
