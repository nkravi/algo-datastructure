package leethcode.easy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class SymmetricTree {

	private void inOrderLeft(TreeNode node,List<TreeNode> traversal){
		if(node != null ){
			traversal.add(node);
			inOrderLeft(node.left,traversal);
			
			inOrderLeft(node.right,traversal);
		}else{
			traversal.add(null);
		}
		
	}
	
	
	private void inOrderRight(TreeNode node,List<TreeNode> traversal){
		if(node != null ){
			traversal.add(node);
			inOrderRight(node.right,traversal);
			
			inOrderRight(node.left,traversal);
		}else{
			traversal.add(null);
		}
		
	}
	
	
	private  boolean isSame(List<TreeNode> l1,List<TreeNode> l2){
		if(l1.size() != l2.size()) {
			return false;
		}
		
		Iterator<TreeNode> iL1 = l1.iterator();
		Iterator<TreeNode> iL2 = l2.iterator();
		
		while(iL1.hasNext() && iL2.hasNext()){
			TreeNode v1 = iL1.next();
			TreeNode v2 = iL2.next();
			if(v1 == null && v2 == null) continue;
			if(v1 == null && v2 != null) return false;
			if(v1 != null && v2 == null) return false;
			
			if(v1.val != v2.val){
				return false;
			}
		}
		return true;
	}
	
	public boolean isSymmetric(TreeNode root) {
		
	   if(root == null) return true;
	   
	   if(root.left == null && root.right == null) return true;
	   
	   if(root.left != null && root.right == null) return false;
	   
	   if(root.right !=null && root.left == null) return false;
	   
	   
	   List<TreeNode> leftRes = new ArrayList<>();
	   List<TreeNode> rightRes = new ArrayList<>();
	   TreeNode onlyLeft = root.left;
	   TreeNode onlyRight = root.right;
	   
	   inOrderLeft(onlyLeft,leftRes);
	   inOrderRight(onlyRight,rightRes);
	   /*
	   leftRes.forEach((x)-> {
		   if(x == null){
			   System.out.println("Null");
		   }else{
			   System.out.println(x.val);
		   }
		   });
	   System.out.println();
	   rightRes.forEach((x)-> {
		   if(x == null){
			   System.out.println("Null");
		   }else{
			   System.out.println(x.val);
		   }
		   });*/
	   return isSame(leftRes,rightRes);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[] vals = {1,2,2,3,4,4,3};
		//Integer[] vals = {1,2,2,null,3,null,3};
		
		//Integer[] vals = {1,2};
		Integer[] vals = {1,2,3,3,null,2,null};
		TreeNode root = TreeNode.createNodeFromArray(vals);
		System.out.println(new SymmetricTree().isSymmetric(root));
	}

}
