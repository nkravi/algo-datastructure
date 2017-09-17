package leethcode.medium;

import java.util.LinkedList;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

public class FindBottomLeftTreeValue {
	private class Tuple{
		private TreeNode node;
		private int depth;
		Tuple(TreeNode node,int depth){
			this.node = node;
			this.depth = depth;
		}
	}
	
	 public int findBottomLeftValue(TreeNode root) {
		 Queue<Tuple> queue = new LinkedList<Tuple>();
		 int currentDepth = 0;
		 queue.add(new Tuple(root,currentDepth));
		 TreeNode result = root;
		 
		 while(!queue.isEmpty()){
			 Tuple tmpTuple = queue.remove();
			 if(tmpTuple.node == null) continue;
			 
			 if(tmpTuple.depth > currentDepth){
				 currentDepth = tmpTuple.depth;
				 result = tmpTuple.node;
			 }
			 
			 queue.add(new Tuple(tmpTuple.node.left,tmpTuple.depth+1));
			 queue.add(new Tuple(tmpTuple.node.right,tmpTuple.depth+1));
		 }
		 
		 return result.val;
	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] parent = {1,2,3};
		Integer[] parent = {1,2,3,4,null,5,6,7};
		//Integer[] parent = {1,null,2};
		TreeNode node = TreeNode.createNodeFromArray(parent);
        System.out.println(new FindBottomLeftTreeValue().findBottomLeftValue(node));
	}

}
