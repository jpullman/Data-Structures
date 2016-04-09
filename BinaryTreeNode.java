public class BinaryTreeNode<T> 
{
	protected T element;
	protected BinaryTreeNode<T> left, right;
	
	public BinaryTreeNode (T obj) //Creates a new node with specified data
	{
		element = obj;
		left = null;
		right = null;
	}
	
	public BinaryTreeNode (T obj, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) //Creates a new node with specified data
	{
		element = obj;
		if (left == null)
			this.left = null;
		else
			this.left = left.getRootNode();
		
		if (right == null)
			this.right = null;
		else
			this.right = right.getRootNode();
	}
	
	public int numChildren() //Returns number of children without null value
	{
		int children = 0;
		if (left != null)
			children += 1 + left.numChildren();
		
		if (right != null)
			children += 1 + right.numChildren();
		return children;
	}
	
	public T getElement() //Returns element of node
	{
		return element;
	}
	
	public BinaryTreeNode<T> getRight() //returns right child of node
	{
		return right;
	}
	
	public BinaryTreeNode<T> getLeft() //returns left child of node
	{
		return left;
	}
	
	public void setRight (BinaryTreeNode<T> node) //Sets right child of node
	{
		right = node;
	}
	
	public void setLeft (BinaryTreeNode<T> node)//Sets left child of node
	{
		left = node;
	}
	

	
	
	
	
	
	
}
