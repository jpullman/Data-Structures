import java.util.Iterator;

public interface BinaryTreeADT<T> 
{
	public T getRootElement(); //Returns root element
	
	public boolean isempty(); //Returns true if tree is empty, or false if it is not
	
	public int size(); //Returns the number of elements in the tree
	
	public boolean contains(T targetElement); //Returns true if tree contains the specified element, and false if not
	
	public BinaryTreeNode<T> find(T targetElement);//Returns a where the specified element is located

	public String toString(); //Returns the tree in string form
	
	public Iterator<T> iterator(); //Returns an iterator over the elements
	
	public Iterator<T> iteratorInOrder(); //Returns an iterator for in order traversal
	
	public Iterator<T> iteratorPreOrder(); //Returns an iterator for pre-order traversal
	
	public Iterator<T> iteratorPostOrder(); //Returns an iterator for post order traversal
	
	public Iterator<T> iteratorLevelOrder(); //Returns an iterator for Level order traversal
	
}
