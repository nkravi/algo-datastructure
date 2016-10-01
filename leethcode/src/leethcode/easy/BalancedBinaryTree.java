package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class BalancedBinaryTree {
	
	private void inOrder(TreeNode node,int depth,Integer [] minMax){
		if(node == null){
			minMax[0] = Integer.min(minMax[0], depth);
			minMax[1] = Integer.max(minMax[1], depth);
			return;
		}
		inOrder(node.left,depth+1,minMax);
		inOrder(node.right,depth+1,minMax);
	}
	
	public boolean isBalanced(TreeNode root) {
		if(root == null) return true;
		Integer[] minMax = new Integer[2];
		minMax[0] = Integer.MAX_VALUE;
		minMax[1] = Integer.MIN_VALUE;
		inOrder(root,0,minMax);
		System.out.println(minMax[0]+"   "+minMax[1]);
	    return Math.abs(minMax[0]-minMax[1]) <= 1;    
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new BalancedBinaryTree().isBalanced(root));
	}

}
