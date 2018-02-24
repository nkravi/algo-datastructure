package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class CountCompleteTreeNodes {

	
	//public static int count = 0;
	
	void DFS(TreeNode node,int[] a){
		if(node == null){
			return;
		}
		DFS(node.left,a);
		DFS(node.right,a);
		a[0] = a[0]+1;
	}
	
	public int countNodes(TreeNode root) {
		int [] a = new int[1];
		a[0] = 0;
		DFS(root,a);
		return a[0];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,3,4,5,6,7,8};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new CountCompleteTreeNodes().countNodes(root));

	}

}
