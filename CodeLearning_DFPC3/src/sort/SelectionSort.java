package sort;

public class SelectionSort {
	
	public int[] selectionSort(int[] arr)
	{
		//if(arr==null) return null;
		//if(arr.length<=1) return arr;
		
		if(arr==null || arr.length<=1) return arr;
		
		int j,minInd;//,minVal;
		for(int i=0; i<arr.length-1;i++)
		{	
			minInd=i;
			for(j=i+1;j<arr.length-1;j++)
			{
				if(arr[j]<arr[minInd])
				{
					arr[minInd] = arr[j];
					minInd=j;
				}
			}
			if(minInd!=i)
			{
				int temp = arr[i];
				arr[i] = arr[minInd];
				arr[minInd] = temp;
			}
			
		}
		return arr;
	}
}
