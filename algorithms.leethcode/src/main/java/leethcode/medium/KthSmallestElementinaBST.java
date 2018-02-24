package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class KthSmallestElementinaBST {

	private void inOrder(TreeNode node,int k,int[] count){
		if(node == null || count[0]>k){
			return;
		}
		inOrder(node.left,k,count);
		count[0] = count[0] + 1;
		if(count[0] == k){
			count[1] = node.val;
			return;
		}
		inOrder(node.right,k,count);
	}
	public int kthSmallest(TreeNode root, int k) {
		int[] count = new int[2];
		count[0] = 0;
		count[1] = -1;
		inOrder(root,k,count);
		return count[1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {4, 2, 5, 1, 3};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		int k =2;
		System.out.println(new KthSmallestElementinaBST().kthSmallest(root, k));
	}

}
