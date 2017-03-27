package basic;
/*
What is the difference of StringBuilder and StringBuffer:
StringBuilder is unSync so it is faster;
StringBuffer is sync so it is slower. 
Commonly we can use StringBuffer 

 
 
 
 */
public class StringBuilderAndStringBuffer {

	public void basicOpsOfStringBuilderAndStringBuffer()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(123);
		sb.append("a");
		sb.append("chaoyang");
		
		System.out.println(sb.charAt(3));
		System.out.println(sb);
		System.out.println(sb.toString());
		
		System.out.println("########################");

		
		sb.delete(1, 3);
		System.out.println(sb);
		
		sb.insert(0, "haha");
		System.out.println(sb);
		
	}
	
	
	public static void checkSpeedOfStringBufferAndStringBuilder() 
	{
        int N = 77777777;
        long t;

        {
            StringBuffer sb1 = new StringBuffer();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb1.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }

        {
            StringBuilder sb2 = new StringBuilder();
            t = System.currentTimeMillis();
            for (int i = N; i --> 0 ;) {
                sb2.append("");
            }
            System.out.println(System.currentTimeMillis() - t);
        }
    }
	
}
