package leethcode.easy;


import leethcode.datastructure.TreeNode;

public class MergeTwoBinaryTrees {
	
	
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null)
            return t2;
        if (t2 == null)
            return t1;
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
        
    }
	
	public static void main(String[] args){
		System.out.println("code in");
		Integer[] node1= {1,3,2,5};
		Integer[] node2 = {2,1,3,null,4,null,7};
		TreeNode t1 = TreeNode.createNodeFromArray(node1);
		TreeNode t2 = TreeNode.createNodeFromArray(node2);
		
		TreeNode result = new MergeTwoBinaryTrees().mergeTrees(t1, t2);
		//System.out.println(result.left.val);
		TreeNode.PrinInorder(result);
	}

}
