package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class BinaryTreeLongestConsecutiveSequence {
	
	
	private int DFS(TreeNode node,int depth,int next){
		if(node == null){
			return depth;
		}
		
		int left =0;
		int right =0;
		if(next == node.val){
			left = DFS(node.left,depth+1,next+1);
		}else{
			left = DFS(node.left,1,node.val+1);
		}
		
		if(next == node.val){
			right = DFS(node.right,depth+1,next+1);
		}else{
			right = DFS(node.right,1,node.val+1);
		}
		
		return Math.max(depth,Math.max(left, right));
		
	}
	
	 public int longestConsecutive(TreeNode root) {
		 
		  if(root == null) return 0;
	        return DFS(root,0,root.val+1);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer [] parent = {1};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new BinaryTreeLongestConsecutiveSequence().longestConsecutive(root));

	}

}
