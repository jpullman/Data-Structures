import java.util.*;


public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterator<T>
{

	protected BinaryTreeNode<T> root;
	protected int modCount;
	private Iterator<T> iterator;
	
	public LinkedBinaryTree() //Creates empty tree
	{
		root = null;
	}

	public LinkedBinaryTree(T element)
	{
		root = new BinaryTreeNode<T> (element); //Creates tree with specific element as the root
		iterator = iteratorInOrder();
	}

	public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right)//Creates tree with children
	{
		root = new BinaryTreeNode<T> (element);
		root.setLeft (left.root);
		root.setRight (right.root);
		iterator = iteratorInOrder();
	}
	
	public BinaryTreeNode<T> getRootNode() //Returns root node
	{
		return root;
	}
	

	public boolean isempty() //Checks if tree is empty
	{
		if(root == null)
		{
	    return true;
		}
	    else
	    {
	    return false;
	    }
		
	}

	@Override
	public int size() //Returns number of nodes in tree
	{
		return 1 + root.numChildren();
	}

	@Override
	public boolean contains(T targetElement) //Checks if specified element is in tree
	{
		BinaryTreeNode<T> current = findNode(targetElement, root);
		if (current.getElement() == targetElement)
		{
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}

	@Override
	public BinaryTreeNode<T> find(T targetElement) //Finds specified element
	{
		BinaryTreeNode<T> current = findNode(targetElement, root);
		if (current == null)
		{
			System.out.println("No Match found");
			return null;
		}
		return (current);
	}
	
	private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) //Finds specified node
	{
		if (next == null)
			return null;
		
		if (next.getElement().equals(targetElement))
			return next;
		BinaryTreeNode<T> temp = findNode(targetElement, next.getLeft());
		
		if (temp == null)
			temp = findNode(targetElement, next.getRight());
		
		return temp;
	}

	@Override
	public Iterator<T> iteratorInOrder() //Helper function for in order iterator
	{
		ArrayList<T> inOrder = new ArrayList<>();
		buildInOrderIterator(root,inOrder);
		return inOrder.iterator();
	}
	
	protected void buildInOrderIterator(BinaryTreeNode<T> node, ArrayList<T> inOrderList) //In order Iterator
	{
		if (node == null)
			return;
		buildInOrderIterator(node.getLeft(), inOrderList);
		inOrderList.add(node.getElement());
		buildInOrderIterator(node.getRight(), inOrderList);
		
	}

	@Override
	public T getRootElement() //returns root element
	{
		return root.getElement();
	}


	@Override
	public Iterator<T> iteratorPreOrder() //Helper function for Pre-Order Iterator
	{
		ArrayList<T> preOrder = new ArrayList<>();
		buildIteratorPreOrder(root,preOrder);
		return preOrder.iterator();
	}
	
	protected void buildIteratorPreOrder(BinaryTreeNode<T> node, ArrayList<T> preOrderList) //pre-order iterator
	{
		if (node == null)
			return;
		preOrderList.add(node.getElement());
		buildInOrderIterator(node.getLeft(), preOrderList);
		buildInOrderIterator(node.getRight(), preOrderList);
	}

	
	@Override
	public Iterator<T> iteratorPostOrder() //Helper function for Post Order Iterator
	{
		ArrayList<T> postOrder = new ArrayList<>();
		buildIteratorPostOrder(root,postOrder);
		return postOrder.iterator();
	}
	
	protected void buildIteratorPostOrder(BinaryTreeNode<T> node, ArrayList<T> postOrderList) //Post Order Iterator
	{
		if (node == null)
			return;
		buildInOrderIterator(node.getLeft(), postOrderList);
		buildInOrderIterator(node.getRight(), postOrderList);
		postOrderList.add(node.getElement());
	}
	
	@Override
	public boolean hasNext() //Returns true if there is another element
	{
		return iterator.hasNext();
	}

	@Override
	public T next() //Returns next element
	{
		return iterator.next();
	}
	
	@Override
	public Iterator<T> iterator() //returns level order iterator sequence
	{
		return iteratorLevelOrder();
	}

	@Override
	public Iterator<T> iteratorLevelOrder() //returns tree in level order
	{
		ArrayList<T> levelOrder = new ArrayList<>();
		ArrayList<BinaryTreeNode<T>> queue = new ArrayList<>();
		BinaryTreeNode<T> current;
		queue.add(getRootNode());
		while (queue.isEmpty() == false)
		{
			current = queue.remove(0);
			if (current != null){
			queue.add(current.getLeft());
			queue.add(current.getRight());
			levelOrder.add(current.getElement());
			}
		}
		
		
		
		return levelOrder.iterator();
	}


}