package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class MinimumDepthofBinaryTree {

	private int minDepth = Integer.MAX_VALUE;
	
	void dfs(TreeNode node,int depth){
		if(node == null)
			return;
		if(node.left == null && node.right == null && depth < minDepth){
			//System.out.println(depth);
			minDepth = depth;
		}
		dfs(node.left,depth+1);
		dfs(node.right,depth+1);
		
	}
	
	public int minDepth(TreeNode root) {
		dfs(root,1);
        return (minDepth == Integer.MAX_VALUE)? 0: minDepth;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumDepthofBinaryTree mdfs = new MinimumDepthofBinaryTree();
		Integer[] parent = {10,5,15,null,null,6,20};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(mdfs.minDepth(root));

	}

}
