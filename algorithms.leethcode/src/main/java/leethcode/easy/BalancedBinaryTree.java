package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class BalancedBinaryTree {
	
	
	public int calHeight(TreeNode node,int height,boolean[] violate){
		if(node == null || height == Integer.MAX_VALUE){
			return height;
		}
		
		int leftNodeHeight = calHeight(node.left, height+1,violate);
		int rightNodeHeight = calHeight(node.right,height+1,violate);
		
		int diff = Math.abs(leftNodeHeight-rightNodeHeight);
		if(diff > 1){
			violate[0] = true;
			return Integer.MAX_VALUE;
		}
		return Integer.max(leftNodeHeight, rightNodeHeight);
		
	}
	
	public boolean isBalanced(TreeNode root) {
		boolean [] violate = new boolean[1];
		violate[0] = false;
		calHeight(root,0,violate);
		//System.out.println(height);
		return !violate[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new BalancedBinaryTree().isBalanced(root));
	}

}
