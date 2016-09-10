package leethcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

public class InvertBinaryTree {

	private TreeNode BFS(TreeNode root){
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			TreeNode node = queue.remove();
			if(node == null)
				continue;
			TreeNode tmp = node.left;
			node.left = node.right;
			node.right = tmp;
			if(node.left != null) queue.add(node.left);
			if(node.right != null) queue.add(node.right);
		}
		return root;
	}
	
	 public TreeNode invertTree(TreeNode root) {
	     if(root == null) return null;
		 return BFS(root);
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer parent[] = {1,2,3,4,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		TreeNode.PrinInorder(root);
		TreeNode res = new InvertBinaryTree().invertTree(root);
		System.out.println("---------------");
		TreeNode.PrinInorder(res);
	}

}
