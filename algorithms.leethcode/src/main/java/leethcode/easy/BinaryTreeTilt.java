package leethcode.easy;

import leethcode.datastructure.TreeNode;

public class BinaryTreeTilt {
	
	private int findTilt(TreeNode node,int[] res) {
		
		if(node == null){
			return 0;
		}
		int left = findTilt(node.left,res);
		int right = findTilt(node.right,res);
		int abs = Math.abs(left-right);
		res[0]+=abs;
	    return left+right+node.val;    
	}
	
	public int findTilt(TreeNode root){
		int[] res = new int[1];
		findTilt(root,res);
		return res[0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer parent[] = {1,2,3};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new BinaryTreeTilt().findTilt(root));

	}

}
