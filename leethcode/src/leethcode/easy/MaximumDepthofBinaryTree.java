package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class MaximumDepthofBinaryTree {

	private int maxDepth = 0;
	
	void dfs(TreeNode node,int depth){
		if(node == null)
			return;
		if(node.left == null && node.right == null && depth > maxDepth){
			//System.out.println(depth);
			maxDepth = depth;
		}
		dfs(node.left,depth+1);
		dfs(node.right,depth+1);
		
	}
	
	public int maxDepth(TreeNode root) {
		dfs(root,1);
        return maxDepth;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaximumDepthofBinaryTree mdfs = new MaximumDepthofBinaryTree();
		Integer[] parent = {10,5,15,null,null,6,20};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(mdfs.maxDepth(root));
	}

}
