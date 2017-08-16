package string;

public class TimeToWords_Glassdoor {
	public String timeToWords(String time)
	{
		if(time==null || time.length()==0) return null;
		String[] data = {"One", "Two", "Three", "Twenty-Nine"};
		String[] str = time.split(":");
		
		if(str.length != 2) return null;
		StringBuilder sb = new StringBuilder();
		
		int hour=0,min=0;
		try  //If letters, then catch exception
		{
			hour = Integer.parseInt(str[0]);
			min = Integer.parseInt(str[1]);
		}
		catch(Exception e)
		{
			System.out.println("Input has error");
		}
		if(hour>12 || hour<=0 || min<0 || min>29) return null;

		
		if(min==0)
		{
			sb.append(data[hour-1]).append(" o’clock");
		}
		else if(min==30)
		{
			sb.append("half past ").append(data[hour-1]);
		}
		else if(min==15)
		{
			sb.append("quarter past ").append(data[hour-1]);
		}
		else if(min==45)
		{
			sb.append("quarter to ").append(data[hour-1]);
		}
		else if(min>0 && min<30)
		{
			sb.append(data[min-1]).append(" past ").append(data[hour-1]);
		}
		else
		{
			sb.append(data[min-1]).append(" to ").append(data[hour-1]);
		}
		return sb.toString();
		
	}

}
