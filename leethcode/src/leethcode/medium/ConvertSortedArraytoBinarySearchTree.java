package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class ConvertSortedArraytoBinarySearchTree {
	
	private TreeNode sortedArrayToBST(int[] nums,int start,int end){
		if(start > end){
			return null;
		}else{
			int middle = start + (end-start)/2;
			TreeNode node = new TreeNode(nums[middle]);
			node.left = sortedArrayToBST(nums,start,middle-1);
			node.right = sortedArrayToBST(nums,middle+1,end);
			return node;
		}
	}
	
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums == null || nums.length ==0) return null;
		return sortedArrayToBST(nums,0,nums.length-1);
    }

	static int getHeight(TreeNode node){
		return getHeight(node,0);
	}
	
	static int getHeight(TreeNode node,int height){
		if(node == null){
			return height;
		}else{
			int left = getHeight(node.left,height+1);
			int right = getHeight(node.right,height+1);
			return Math.max(left, right);
			
		}
		
	}
	
	
	public static void main(String[] args) {
		int nums[] = {1,2,3,4,5,6};
		TreeNode root = new ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(nums);
		TreeNode.PrinInorder(root);
		System.out.println(ConvertSortedArraytoBinarySearchTree.getHeight(root));
		
	}

}
