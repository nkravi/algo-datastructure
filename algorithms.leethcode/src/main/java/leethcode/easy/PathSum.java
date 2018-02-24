package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class PathSum {
	
	private boolean dfs(TreeNode node,int currentSum,int finalSum){
		if(node == null){
			return false;
		}
		currentSum = currentSum + node.val;
		System.out.println(currentSum);
		if(node.left == null && node.right == null){
			if(currentSum == finalSum){
				return true;
			}
		}
		return dfs(node.left, currentSum , finalSum) || dfs(node.right, currentSum, finalSum);

		
	}
	
	
	
	public boolean hasPathSum(TreeNode root, int sum) {
		return dfs(root,0,sum);
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {-2,null,-3};
		int sum = -5;
		TreeNode root =TreeNode.createNodeFromArray(parent);
		System.out.println(new PathSum().hasPathSum(root, sum));

	}

}
