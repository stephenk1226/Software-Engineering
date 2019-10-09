import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	@Test
	public void testOne() {
		
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = new LCA.Node(1);
		binaryTree.root.left = new LCA.Node(7);
		binaryTree.root.left.left =  new LCA.Node(2);
		binaryTree.root.left.right = new LCA.Node(6);
		binaryTree.root.right = new LCA.Node(5);
		binaryTree.root.right.left = new LCA.Node(3);
		binaryTree.root.right.right = new LCA.Node(9);
		
		/*
		 * 
		 * 					  1
		 *				   /     \
		 * 			      7		  5 
		 *              /   \    /  \
		 * 			   2	 6	3    9
		 *
		 */		   
		
		assertEquals(7,binaryTree.findLCA(2, 6));
		assertEquals(7,binaryTree.findLCA(6, 2));
		assertEquals(5, binaryTree.findLCA(3, 9));
		assertEquals(5, binaryTree.findLCA(9, 3));
		assertEquals(1, binaryTree.findLCA(2, 3));
		assertEquals(1, binaryTree.findLCA(7, 5));
	}

	@Test 
	public void testTwo() {
		
		//Test using the example from the lecture slides 
		
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = new LCA.Node(1);
		binaryTree.root.left = new LCA.Node(2);
		binaryTree.root.left.left =  new LCA.Node(4);
		binaryTree.root.left.left.left =  new LCA.Node(6);
		binaryTree.root.right = new LCA.Node(3);
		binaryTree.root.right.left = new LCA.Node(5);
		binaryTree.root.right.left.right = new LCA.Node(8);
		binaryTree.root.right.left.left = new LCA.Node(7);
		binaryTree.root.right.left.left.right = new LCA.Node(10);
		binaryTree.root.right.left.left.right.left = new LCA.Node(9);
		binaryTree.root.right.left.left.right.right = new LCA.Node(11);
		binaryTree.root.right.left.left.right.right.right = new LCA.Node(12);
		
		
		/*
		 * 						  1
		 * 						/	\
		 * 					   2	 3
		 * 					  /     /
		 * 					 4     5
		 * 					/     / \
		 * 				   6     7   8
		 * 	                      \
		 * 						   10
		 * 						  /  \
		 *                       9    11
		 *                              \
		 *                               12
		 */					      
		
		
		
		assertEquals(5, binaryTree.findLCA(12, 8));
		assertEquals(5, binaryTree.findLCA(9, 8));
		assertEquals(10, binaryTree.findLCA(9, 12));
		assertEquals(1, binaryTree.findLCA(6, 7));
		assertEquals(5, binaryTree.findLCA(7, 8));
				
		
	}
}
