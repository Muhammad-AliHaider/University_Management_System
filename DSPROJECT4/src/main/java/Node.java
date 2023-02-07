
public class Node {
	
	String Name;
	Node[] SecLayer;
	Node[] ThirdLayer;

	BinarySearchTree UniTree;
	
	public Node(String Name, BinarySearchTree UniTree)
	{
		this.Name = Name;
		this.UniTree = UniTree;
	}
	
	public Node(String Name, boolean t)
	{
		this.Name = Name;
		if(t == true)
		{
			this.UniTree = new BinarySearchTree();
		}
	}
	
	public Node(String Name,Node[] SecLayer)
	{
		this.Name = Name;
		this.SecLayer = SecLayer;
		this.UniTree = new BinarySearchTree();
	}
	
	public Node(String Name,Node[] SecLayer ,Node[] ThirdLayer )
	{
		this.Name = Name;
		this.SecLayer = SecLayer;
		this.ThirdLayer = ThirdLayer;
		this.UniTree = new BinarySearchTree();
	}
	

}
