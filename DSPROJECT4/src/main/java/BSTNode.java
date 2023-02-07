
public class BSTNode 
{
	public University_Node uni;
	public BSTNode left;
	public BSTNode right;
	
	public BSTNode(University_Node n)
	{
		uni = n;
	}
	
	public String toString()
	{
		return uni.toString();
	}
	
	
}
