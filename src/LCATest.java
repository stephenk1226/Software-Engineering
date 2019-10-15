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
		assertEquals(-1, binaryTree.findLCA(300, 1));
		assertEquals(-1, binaryTree.findLCA(1, 300));
				
	}
	
	
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
	@Test
	public void testNull() {
		
		LCA.NoParent binaryTree = new LCA.NoParent();
		binaryTree.root = null;
		/*
		 * 			null
		 * 			/  \
		 */
		assertEquals(-1, binaryTree.findLCA(0, 0));
		
		LCA.DagNode head = null;
		LCA.DagNode secondNode = null;
        LCA.DagNode thirdNode = null;
        assertEquals(null, LCA.findLCADag(head, secondNode, thirdNode));
        
		
		
	}
	
	@Test
    public void standardDAGTest() {
        LCA.DagNode head = new LCA.DagNode(1);
        LCA.DagNode secondNode = new LCA.DagNode(3);
        LCA.DagNode thirdNode = new LCA.DagNode(5);
        LCA.DagNode fourthNode = new LCA.DagNode(7);
        LCA.DagNode fifthNode = new LCA.DagNode(9);
        head.edges.add(secondNode);
        head.edges.add(thirdNode);
        head.edges.add(fourthNode);
        head.edges.add(fifthNode);
        assertEquals(head, LCA.findLCADag(head, secondNode, fifthNode));
    }
	
	
}
