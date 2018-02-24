package leethcode.easy;



import leethcode.datastructure.TreeNode;

public class SameTree {
	
	
	private boolean traverse(TreeNode node1,TreeNode node2){
		if(node1 == null && node2 == null){
			return true;
		}
		if(node1 != null && node2 == null){
			return false;
		}
		if(node2 != null && node1 == null){
			return false;
		}
		if(node1.val != node2.val ){
			return false;
		}
		boolean tmp1 = traverse(node1.left, node2.left);
		boolean tmp2 = traverse(node1.right, node2.right);
		return tmp1 && tmp2;
	}
	public boolean isSameTree(TreeNode p, TreeNode q) {
       return traverse(p,q); 
    }
	public static void main(String[] args) {
		Integer[] parentP = {1,2,3,null};
		Integer[] parentQ = {1,2,3,null};
		TreeNode p = TreeNode.createNodeFromArray(parentP);
		TreeNode q = TreeNode.createNodeFromArray(parentQ);
		System.out.println(new SameTree().isSameTree(p, q));

	}

}
