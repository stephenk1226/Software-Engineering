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
		
		assertEquals(7,binaryTree.findLCA(2, 6));
		assertEquals(7,binaryTree.findLCA(6, 2));
		assertEquals(5, binaryTree.findLCA(3, 9));
		assertEquals(5, binaryTree.findLCA(9, 3));
		assertEquals(1, binaryTree.findLCA(2, 3));
		assertEquals(1, binaryTree.findLCA(7, 5));
	}

}
