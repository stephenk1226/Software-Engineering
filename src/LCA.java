import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class LCA {
	
	public static class Node {
		int data;
		Node left, right;
		
		Node(int value)
		{
			data = value;
			left = right = null;
		}
	}
	
	public static class NoParent
	{
		Node root; 
	    private List<Integer> path1 = new ArrayList<>(); 
	    private List<Integer> path2 = new ArrayList<>(); 
	  
	    
	    int findLCA(int n1, int n2)
	    { 
	        path1.clear(); 
	        path2.clear(); 
	        return findLCAInternal(root, n1, n2); 
	    } 
	  
	    private int findLCAInternal(Node root, int n1, int n2)
	    { 
	  
	        if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) 
	        { 
	            System.out.println((path1.size() > 0) ? "Node 1 is present" : "Node 1 is missing"); 
	            System.out.println((path2.size() > 0) ? "Node 2 is present" : "Node 2 is missing"); 
	            return -1; 
	        } 
	  
	        int i; 
	        for (i = 0; i < path1.size() && i < path2.size(); i++) 
	        {       
	            if (!path1.get(i).equals(path2.get(i))) 
	                break; 
	        } 
	  
	        return path1.get(i-1); 
	    } 
	    
	    private boolean findPath(Node root, int n, List<Integer> path) 
	    {  
	        if (root == null) 
	        { 
	            return false; 
	        } 
	         
	        path.add(root.data); 
	  
	        if (root.data == n) 
	        { 
	            return true; 
	        } 
	  
	        if (root.left != null && findPath(root.left, n, path)) 
	        { 
	            return true; 
	        } 
	  
	        if (root.right != null && findPath(root.right, n, path)) 
	        { 
	            return true; 
	        }
	        
	        path.remove(path.size()-1); 
	  
	        return false; 
	    }
	}    
	
	
	public static class DagNode {
        int value;
        ArrayList<DagNode> edges;

        DagNode(int value)
        {
            this.value = value;
            edges = new ArrayList<>();
        }

        DagNode(int value, ArrayList<DagNode> edges) 
        {
            this.value = value;
            this.edges = edges;
        }
    }
	
	public static DagNode findLCADag(DagNode head, DagNode firstNode, DagNode secondNode) {
        DagNode LCA = null;
        ArrayList<DagNode> nodes = new ArrayList<>();
        addNodesToListDAG(nodes, head);
        boolean isAncestor[] = new boolean[nodes.size()];
        for (int i = 0; i < isAncestor.length; i++)
            isAncestor[i] = false;
        for (int i = 0; i < nodes.size(); i++) {
            if (checkIfAncestorDAG(nodes.get(i), firstNode, secondNode))
            {
                isAncestor[i] = true;
            }
        }
        for (int i = 0; i < nodes.size(); i++)
        {
            if(isAncestor[i])
                LCA = nodes.get(i);
        }
        return LCA;
    }
	
	public static boolean checkIfAncestorDAG(DagNode node, DagNode firstNode) {
        if (node == null)
            return false;
        if (node == firstNode)
            return true;
        else {
            for (int i = 0; i < node.edges.size(); i++) {
                if (checkIfAncestorDAG(node.edges.get(i), firstNode)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfAncestorDAG(DagNode node, DagNode firstNode, DagNode secondNode) {
        if (checkIfAncestorDAG(node, firstNode) && checkIfAncestorDAG(node, secondNode))
        {
        	 return true;
        }
        return false;
    }
 
    public static void addNodesToListDAG(ArrayList<DagNode> nodes, DagNode root) {
        if (root != null) 
        {
            LinkedList<DagNode> queue = new LinkedList<>();
            queue.add(root);
            DagNode current;
            while (queue.size() != 0) {
                current = queue.get(0);
                for (int i = 0; i < current.edges.size(); i++) {
                    queue.add(current.edges.get(i));
                }
                nodes.add(current);
                queue.remove(0);
            }
        }
    }
    
	public static void main(String[] args) {
		
	}

}
