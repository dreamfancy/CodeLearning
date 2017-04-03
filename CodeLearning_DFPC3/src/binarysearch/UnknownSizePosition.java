package binarysearch;

public class UnknownSizePosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Not Sure if my solution is correct
	/*
	public long getPositionFromUnknownSize(MyArray myarray, int t)
	{
		if(myarray.get(0)==null) return -1;
		else if(myarray.get(0)==t) return 0;
		else if(myarray.get(1)==null) return -1;
		
		int start=0, end=1;
		while(myarray.get(end)!=null && myarray.get(end)<t)
		{
			if(myarray.get(end)<t)
			{
				start = end+1;
			}
			end = end*2;
		}
	
		int mid;
		while(start<end-1)
		{
			mid = start + (end-start)/2;
			if(myarray.get(mid)==t) return mid;
			else if (myarray.get(mid)<t)
			{
				start = mid;
			}
			else
			{
				end = mid;
			}
		}
		if(myarray.get(start)==t) return start;
		else if(myarray.get(end)==t) return end;
		else return -1;	
	}
	*/
}
