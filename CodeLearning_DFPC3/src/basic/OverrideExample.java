package basic;

public class OverrideExample {

	
	 
	interface MyList
	{
		public void delete(int index);
	}
	  
	class MyArrayList implements MyList
	{
		@Override
		public void delete(int index)
		{
			//do something
		}
	}
	
	
	//Integer.ValueOf(1);
	
	
}
