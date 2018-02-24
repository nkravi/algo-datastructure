package leethcode.datastructure;

public class TreeNode {
	
	
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	private static void createTree(TreeNode node,Integer[] parent,Integer current){
		//root = new TreeNode(parent[current]);
		if(node == null) return;
		TreeNode left = null;
		TreeNode right = null;
		if(current*2+1 < parent.length  && parent[current*2+1] != null){
			left = new TreeNode(parent[current*2+1]);
		}
		if( current*2+2 < parent.length && parent[current*2+2] != null){
			right = new TreeNode(parent[current*2+2]);
		}
		node.left = left;
		node.right = right;
		createTree(node.left,parent,current*2+1);
		createTree(node.right,parent,current*2+2);
	}
	
	public static TreeNode createNodeFromArray(Integer[] parent){
		TreeNode ptroot = new TreeNode(parent[0]);
		TreeNode root = ptroot;
		createTree(ptroot,parent,0);
		return root;
	}
	public static void PrintTree(TreeNode root){
		
		System.out.println(root.left.val);
		System.out.println(root.val);
		System.out.println(root.right.val);
	}
	
	
	public static void PrinInorder(TreeNode node){
		if(node == null) return;
		PrinInorder(node.left);
		System.out.println(node.val);
		PrinInorder(node.right);
	}
	
	public static boolean compare(TreeNode node1,TreeNode node2){
		if(node1== null && node2 == null){
			return true;
		}
		if(node1 == null || node2 == null){
			return false;
		}else if(node1.val != node2.val){
			 return false;
		}else{
			return compare(node1.left, node2.left) && compare(node1.right, node2.right);
		}
	}
}
