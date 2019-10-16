import static org.junit.Assert.*;

import org.junit.Test;

public class LCATest {

	//Test using a small balanced Binary Search Tree
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

	//Test using the example from the lecture slides 
	@Test 
	public void testTwo() {
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
		assertEquals(-1, binaryTree.findLCA(300, 1));
		assertEquals(-1, binaryTree.findLCA(1, 300));	
	}
	
	//Test using  a binary Search Tree with two nodes
	@Test 
	public void testThree() {
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = new LCA.Node(1);
		binaryTree.root.right = new LCA.Node(4);
	
		/*
		 * 				1
		 * 				 \	
		 *                4
		 */
		
		assertEquals(1, binaryTree.findLCA(4,1));
		assertEquals(1, binaryTree.findLCA(1,4));
	}
	
	//Test with a Binary Search Tree with it's root as null
	@Test
	public void testNull() {
		
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = null;
		assertEquals(-1, binaryTree.findLCA(0, 0));
		
	}
	
	//Test with a unbalanced Binary Search Tree
	@Test 
	public void unbalancedBSTTest() {
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = new LCA.Node(12);
		binaryTree.root.right = new LCA.Node(23);
		binaryTree.root.right.left = new LCA.Node(16);
		binaryTree.root.right.right = new LCA.Node(49);
		binaryTree.root.right.right.left = new LCA.Node(34);
		binaryTree.root.right.right.left.right = new LCA.Node(42);
		binaryTree.root.right.right.left.right.right = new LCA.Node(45);
		
		/*					12
		 * 					  \
		 *                    23
		 *                  /    \
		 *                 16     49
		 *                        /
		 *                      34 
		 *                        \
		 *                         42
		 *                           \
		 *                            45
		 */ 
		
		assertEquals (23, binaryTree.findLCA(16, 45));
		assertEquals (42, binaryTree.findLCA(42, 45));
		assertEquals (23, binaryTree.findLCA(16, 49));
	}
	
	//Test with a large balanced Binary Search Tree
	@Test 
	public void largeBSTTest() {
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = new LCA.Node(25);
		//left side of binary tree
		binaryTree.root.left = new LCA.Node(20);
		binaryTree.root.left.right = new LCA.Node(22);
		binaryTree.root.left.left = new LCA.Node(10);
		binaryTree.root.left.left.left = new LCA.Node(5);
		binaryTree.root.left.left.left.left = new LCA.Node(1);
		binaryTree.root.left.left.left.right = new LCA.Node(8);
		binaryTree.root.left.left.right = new LCA.Node(12);
		binaryTree.root.left.left.right.right = new LCA.Node(15);
		//right side of binary tree 
		binaryTree.root.right = new LCA.Node(36);
		binaryTree.root.right.left = new LCA.Node(30);
		binaryTree.root.right.left.left = new LCA.Node(28);
		binaryTree.root.right.right = new LCA.Node(40);
		binaryTree.root.right.right.left = new LCA.Node(38);
		binaryTree.root.right.right.right = new LCA.Node(48);
		binaryTree.root.right.right.right.left = new LCA.Node(45);
		binaryTree.root.right.right.right.right = new LCA.Node(50);
		
		/*
		 * 								   25
		 * 							   /        \
		 * 							20	        36
		 * 						   /  \        /  \
		 * 						 10    22     30   40
		 * 						/  \         /     / \
		 * 					   5    12     28    38   48
		 * 					  / \    \                / \
		 * 					 1   8    15			45   50
		 * 
		 */
		
		assertEquals(5, binaryTree.findLCA(1, 8));
		assertEquals(10, binaryTree.findLCA(1, 15));
		assertEquals(20, binaryTree.findLCA(10, 22));
		assertEquals(25, binaryTree.findLCA(8, 50));
		assertEquals(36, binaryTree.findLCA(28, 48));
		assertEquals(48, binaryTree.findLCA(45, 50));
	}
}
