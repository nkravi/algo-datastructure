package leethcode.medium;

import java.util.Stack;

import leethcode.datastructure.TreeNode;

public class BinarySearchTreeIterator {
	    private Stack<TreeNode> stack;
	    public BinarySearchTreeIterator(TreeNode root) {
	    	stack = new Stack<>();
	    	if(root != null)
	    		stack.push(root);
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }
	    
	    private boolean isLeaf(TreeNode node){
	    	return node.left == null && node.right == null;
	    }
	    private boolean hasLeft(TreeNode node){
	    	return node.left != null;
	    }
	    
	    private void fillStack(TreeNode node){
	    	if(node == null) return;
	    	if(isLeaf(node)){
	    		stack.push(node);
	    		return;
	    	}else{
	    		if(hasLeft(node)){
	    			//go far left
	    			TreeNode leftNode = node.left;
	    			node.left = null;
	    			stack.push(node);
	    			fillStack(leftNode);
	    		}else{
	    			TreeNode rightNode = node.right;
	    			node.right = null;
	    			fillStack(rightNode);
	    			stack.push(node);
	    		}
	    	}
	    }
	    
	    

	    /** @return the next smallest number */
	    public int next() {
	    	if(hasNext()){
	    		TreeNode node = stack.pop();
		    	fillStack(node);
		    	return stack.pop().val;
	    	}
	    	return -1;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {4,2,6,1,3,5,7};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		
		BinarySearchTreeIterator bt = new BinarySearchTreeIterator(root);
		while(bt.hasNext()){
			System.out.println(bt.next());
		}
	}

}
