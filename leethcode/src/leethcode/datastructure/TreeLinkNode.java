package leethcode.datastructure;

public class TreeLinkNode {
	public int val;
	public TreeLinkNode left, right, next;
	public TreeLinkNode(int x) { val = x; }
	
	
	public static void print(TreeLinkNode root){
		for(TreeLinkNode node = root;node != null;node=node.left){
			for(TreeLinkNode n = node;n != null;n=n.next){
				System.out.print(n.val+" ");
			}
			System.out.println();
		}
	}
	
	private static void createTree(TreeLinkNode node,Integer[] parent,Integer current){
		//root = new TreeNode(parent[current]);
		if(node == null) return;
		TreeLinkNode left = null;
		TreeLinkNode right = null;
		if(current*2+1 < parent.length  && parent[current*2+1] != null){
			left = new TreeLinkNode(parent[current*2+1]);
		}
		if( current*2+2 < parent.length && parent[current*2+2] != null){
			right = new TreeLinkNode(parent[current*2+2]);
		}
		node.left = left;
		node.right = right;
		createTree(node.left,parent,current*2+1);
		createTree(node.right,parent,current*2+2);
	}
	
	public static TreeLinkNode createTree(Integer[] parent){
		TreeLinkNode ptroot = new TreeLinkNode(parent[0]);
		TreeLinkNode root = ptroot;
		createTree(ptroot,parent,0);
		return root;
	}
}
