public class BinarySearchTree
{
	public BSTNode root;
	
	public void insert(University_Node UNI)
	{
            BSTNode n = new BSTNode(UNI);
            if(root == null)
            {
                root = n;
            }
            else
            {
                BSTNode temp = root;
                BSTNode prev = null;
                while(temp!= null)
                {
                    if(temp.uni.rank > n.uni.rank )
                    {
                        prev = temp;
                        temp = temp.left;
                    }
                    else if(temp.uni.rank <= n.uni.rank)
                    {
                        prev = temp;
                        temp = temp.right;
                    }

                }
                if(prev.uni.rank > n.uni.rank )
                {
                    prev.left = n;
                }

                else if(prev.uni.rank <= n.uni.rank)
                {
                    prev.right = n;
                }
            }
		
	}
	
        String str = "";
	public String LNR(BSTNode n) // required recursive implementation //O(n)
         { 
            if(n==null)
            {
             return "";
            }
            else 
            {
            LNR(n.left); 
            str = str + n.toString() + "\n \n";
            LNR(n.right);
            return str;
            }
         }
}
