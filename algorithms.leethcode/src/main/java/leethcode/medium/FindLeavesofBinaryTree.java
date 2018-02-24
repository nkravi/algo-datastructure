package leethcode.medium;

import java.util.ArrayList;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class FindLeavesofBinaryTree {
	
	class Tuple{
		TreeNode parent;
		TreeNode node;
		Tuple(TreeNode parent,TreeNode node){
			this.parent = parent;
			this.node = node;
		}
	}
	
	void DFS(TreeNode parent,TreeNode node,List<Tuple> leaves){
		
		if(node == null) return;
		DFS(node,node.left,leaves);
		DFS(node,node.right,leaves);
		if(node.left == null && node.right == null){
			leaves.add(new Tuple(parent,node));
		}	
	}
	
	List<Integer> removeLeaves(TreeNode root){
		List<Tuple> leaves = new ArrayList<>();
		DFS(root,root,leaves);
		List<Integer> valLeaves = new ArrayList<>();
		for(Tuple t: leaves){
			int val = -1;
			if(t.parent.left == t.node){
				val = t.node.val;
				t.parent.left = null;
			}else{
				val = t.node.val;
				t.parent.right = null;
			}
			valLeaves.add(val);
		}
		
		return valLeaves;
	}
	
	public List<List<Integer>> findLeaves(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null){
			return null;
		}
		
		while(root.left != null || root.right!= null){
			List<Integer> leaves = removeLeaves(root);
			res.add(leaves);
		}
		List<Integer> rootVal = new ArrayList<Integer>();
		rootVal.add(root.val);
		res.add(rootVal);
		return res;
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,3,4,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		List<List<Integer>> res = (new FindLeavesofBinaryTree().findLeaves(root));
		
		for(List<Integer> l: res){
			System.out.println();
			for(Integer i: l){
				System.out.print(i+"\t");
			}
		}
	    //TreeNode.PrinInorder(root);
	}

}
