package basic;

public class Point 
{
	int i;
	int j;
	int val;
	
	public Point(int _i, int _j, int _val)
	{
		i = _i;
		j = _j;
		val = _val;
	}
	@Override
	public boolean equals(Object p2)
	{
		return (i==((Point)p2).i && j==((Point)p2).j);
	}
}
