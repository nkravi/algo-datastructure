package leethcode.hard;

import java.util.ArrayList;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class SerializeandDeserializeBinaryTree {

	int current =0;
	public TreeNode inversePreOrder(TreeNode node,String[] arr){
		
		if(current >= arr.length) return null;
		String s =  arr[current];
		current++;
		if(!s.trim().equals("Null")){
			node = new TreeNode(Integer.parseInt(s));
			node.left = inversePreOrder(node.left,arr);
			node.right = inversePreOrder(node.right,arr);
			
		}
		return node;
	}
	
	public void preOrder(TreeNode node,List<Integer> res){
		if(node == null) {
			res.add(null);
			return;
		};
		res.add(node.val);
		preOrder(node.left,res);
		preOrder(node.right,res);
	}
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	List<Integer> lst = new ArrayList<Integer>();
    	preOrder(root,lst);
    	String s = "";
    	for(Integer i: lst){
    		String c = (i ==null)? "Null" : Integer.toString(i);
    		s = s+ c +"\t";
    	}
    	
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	TreeNode root= null;
    	TreeNode node = root;
    	return inversePreOrder(node,data.split("\t"));
        //return root;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent ={1,2,3,4,5};
		SerializeandDeserializeBinaryTree sdb = new SerializeandDeserializeBinaryTree();
		TreeNode root = TreeNode.createNodeFromArray(parent);
		String data = sdb.serialize(root);
		System.out.println(data);
		root = sdb.deserialize(data);
		System.out.println(sdb.serialize(root));
	}

}
