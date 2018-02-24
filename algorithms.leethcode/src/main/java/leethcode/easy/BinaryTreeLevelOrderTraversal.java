package leethcode.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

class Node{
	Integer order;
	TreeNode node;
	Node(Integer order,TreeNode node){
		this.order = order;
		this.node = node;
	}
}

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
	  List<List<Integer>>   lorder = new ArrayList<List<Integer>>();
	  Queue<Node> q = new LinkedList<Node>();
	  if(root == null) return lorder;
	  q.add(new Node(0,root)); 
	  while(!q.isEmpty()){
		  Node n = q.remove();
		  if(n == null || n.node == null) continue;
		  List<Integer> item = null;
		  if(n.order > lorder.size()-1){
			  lorder.add( new ArrayList<Integer>());
		  }
		  item = lorder.get(n.order);
		  item.add(n.node.val);
		  lorder.set(n.order, item);
		  q.add(new Node(n.order+1,n.node.left));
		  q.add(new Node(n.order+1,n.node.right));  
	  }
	  return lorder;	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {3,9,20,null,null,15,7};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		 List<List<Integer>> out= new BinaryTreeLevelOrderTraversal().levelOrder(root);
		 for(List<Integer> l : out){
			 for(Integer i: l){
				 System.out.print(i+"\t");
			 }
			 System.out.println();
		 }
	}
}
