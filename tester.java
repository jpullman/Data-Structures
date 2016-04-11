import java.util.Iterator;

public class tester {
		public static void main (String args[])
		{
			BackPainExpert test = new BackPainExpert();
			
			//test.diagnose();
			LinkedBinaryTree<String> treeTest = test.getTree();
			Iterator<String> treeIterator = null;
			String element;
			
			System.out.println("------------");
			System.out.println("------------");
			System.out.println("PreOrder");
			System.out.println("------------");
			
			treeIterator = treeTest.iteratorPreOrder();
			while (treeIterator.hasNext()){
				element = treeIterator.next();
				System.out.println(element);
			}
			
			System.out.println("------------");
			System.out.println("PostOrder");
			System.out.println("------------");
			
			treeIterator = treeTest.iteratorPostOrder();
			while (treeIterator.hasNext()){
				element = treeIterator.next();
				System.out.println(element);
			}
			
			System.out.println("------------");
			System.out.println("InOrder");
			System.out.println("------------");
			
			treeIterator = treeTest.iteratorInOrder();
			while (treeIterator.hasNext()){
				element = treeIterator.next();
				System.out.println(element);
			}
			
			System.out.println("------------");
			System.out.println("searchTest");
			System.out.println("------------");
			
			System.out.println(treeTest.find("Do you have a sore throat or runny nose?").getElement());
			System.out.println(treeTest.find("Dog?"));
		
			System.out.println("------------");
			System.out.println("countTest");
			System.out.println("------------");
			
			System.out.println(treeTest.size());
			
			System.out.println("------------");
			System.out.println("linkedBinaryTreeIterator Interface");
			System.out.println("------------");
			
			treeIterator = treeTest;
			while (treeIterator.hasNext()){
				element = treeIterator.next();
				System.out.println(element);
			}
			
			System.out.println("------------");
			System.out.println("levelOrderIterator");
			System.out.println("------------");
			
			treeIterator = treeTest.iteratorLevelOrder();
			while (treeIterator.hasNext()){
				element = treeIterator.next();
				System.out.println(element);
			}
	}
}
