package leethcode.medium;


import static org.junit.Assert.*;

import org.junit.Test;

import leethcode.datastructure.TreeNode;

public class ConstructBinaryTreefromPreorderandInorderTraversal {
	
	private static int counter = 0;
	private class Tuple{
		private Node _1;
		private Node _2;
		Tuple(Node _1,Node _2){
			this._1 = _1;
			this._2 = _2;
		}
	}
	private class Node{
		private int[] vals;
		private Node left;
		private Node right;
		
		Node(int[] vals){
			this.vals = vals;
		}
	}
	
	private int findIndex(int [] array,int val){
		int index = -1;
		
		for(int i=0;i< array.length;i++){
			if(array[i] == val){
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	private Tuple split(int[] array, int val){
		int index = findIndex(array,val);
		int [] left = new int[index];
		int [] right = new int[array.length - (index+1)];
		
		for(int r=0,l=0,i=0;i< array.length;i++){
			if(i < index ){
				left[l] = array[i];
				l++;
			}
			if(i > index){
				right[r] = array[i];
				r++;
			}
		}
		
		Node leftNode = new Node(left);
		Node rightNode = new Node(right);
		
		return new Tuple(leftNode,rightNode);
	}
	
	private void Traverse(Node node, int[] preorder){
		if(node.vals.length == 0){
			return;
		}
		Tuple t= split(node.vals,preorder[counter]);
		node.vals = new int[1];
		node.vals[0] = preorder[counter];
		node.left = t._1;
		node.right = t._2;
		counter++;
		Traverse(node.left,preorder);
		Traverse(node.right,preorder);
	}
	
	private void copy(Node node,TreeNode tree){
		if( node.vals.length == 0){
			return;
		}
		//System.out.println(node.vals[0]);
		tree.val = node.vals[0];
		
		TreeNode left = (node.left.vals.length == 0) ? null : new TreeNode(-1);
		TreeNode right = (node.right.vals.length == 0) ? null : new TreeNode(-1);
		
		tree.left = left;
		tree.right = right;
		
		copy(node.left,tree.left);
		copy(node.right,tree.right);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder == null || preorder.length == 0){
			return null;
		}
		if(inorder == null || inorder.length == 0){
			return null;
		}
		Node root = new Node(inorder);
		Traverse(root,preorder);
		TreeNode treeRoot = new  TreeNode(root.vals[0]);
		copy(root,treeRoot);
		return treeRoot;
        
    }

	@Test
	public void findIndexTest(){
		int a[] = {1,2,3,4,5};
		assertEquals(this.findIndex(a, 3),2);
	}
	
	@Test
	public void splitTest(){
		int a[] = {1,2,3,4,5};
		int left[] = {1,2,3,4};
		int right[] = {};
		Tuple t = this.split(a, 5);
		assertArrayEquals(t._1.vals,left);
		assertArrayEquals(t._2.vals,right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []preOrder = {2,1};
		int []inOrder = {1,2}; 
		
		TreeNode root = new ConstructBinaryTreefromPreorderandInorderTraversal().buildTree(preOrder,inOrder);
		TreeNode.PrinInorder(root);
	}

}
