package leethcode.medium;

import leethcode.datastructure.TreeNode;

public class BinarySearchTreeIterator {
	    TreeNode next = null;
	    public BinarySearchTreeIterator(TreeNode root) {
	        this.next = root;
	    }

	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	      return next != null;
	        
	    }

	    /** @return the next smallest number */
	    public int next() {
	    	if(hasNext()){
	    		int val = next.val;
	    		next = next.left;
	    		return val;
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
