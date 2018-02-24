package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class ValidateBinarySearchTree {
	
	private boolean isBST = true;
	private Integer pVal ;
	
	private void isValid(TreeNode node){
		if(node == null || isBST == false)
			return;
		isValid(node.left);
		if(pVal != null && pVal >= node.val){
			isBST = false;
			return;
		}else{
			pVal = node.val;
		}
		//System.out.println(node.val);
		isValid(node.right);
	}
	
	
	 public boolean isValidBST(TreeNode root) {
		 isValid(root);
		 return isBST;	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidateBinarySearchTree bst = new ValidateBinarySearchTree();
		Integer[] parent = {10,5,15,null,null,6,20};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		//System.out.println(root.left.val);
		System.out.println(bst.isValidBST(root));

	}

}
