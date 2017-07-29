package bitoperation;

public class ContainsDuplicateInChars_217_ext {

	public boolean check(char[] array) throws Exception
	{
		if(array==null || array.length==0) throw new IllegalArgumentException() ;
		int[] bits = new int[8];
		
		for(char i : array)
		{
			int row = i/32;
			int col = i%32;
			if((bits[row] & (1<<col))!=0) return false;
			bits[row] = array[row] | (1<<col);
		}
		
		return true;
	}
}
