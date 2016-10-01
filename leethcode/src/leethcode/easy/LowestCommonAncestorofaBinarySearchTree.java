package leethcode.easy;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class LowestCommonAncestorofaBinarySearchTree {
	
	
	private void findNode(TreeNode ptr,TreeNode node,List<TreeNode> track){
		track.add(ptr);
		if(ptr == null || ptr.val == node.val){
			return;
		}else if(ptr.val > node.val){
			findNode(ptr.left,node,track);
		}else{
			findNode(ptr.right,node,track);
		}
		
	}
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		 List<TreeNode> trackP = new LinkedList<>();
		 List<TreeNode> trackQ = new LinkedList<>();
		 findNode(root,q,trackQ);
		 findNode(root,p,trackP);
		 Iterator<TreeNode> pIter = trackP.iterator();
		 Iterator<TreeNode> qIter = trackQ.iterator();
		 TreeNode val = null;
		 while(qIter.hasNext() && pIter.hasNext()){
			 TreeNode tmp = qIter.next();
			 if(tmp != pIter.next())
				 break;
			 val = tmp;
		 }
		return val;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {6,2,8,0,4,7,9};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		//TreeNode.PrinInorder(root);
		
		TreeNode res = new LowestCommonAncestorofaBinarySearchTree().lowestCommonAncestor(root, new TreeNode(6), new TreeNode(7));
		//TreeNode.PrinInorder(root);
		System.out.println(res.val);

	}

}
