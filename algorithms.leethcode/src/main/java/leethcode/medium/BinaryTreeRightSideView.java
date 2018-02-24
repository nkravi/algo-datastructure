package leethcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

public class BinaryTreeRightSideView {
	
	private class Tuple{
		int level;
		TreeNode node;
		Tuple(int level,TreeNode node){
			this.level =level;
			this.node =node;
		}
	}
	public List<Integer> rightSideView(TreeNode root) {
		if(root == null){
			throw new IllegalArgumentException("root cannot be null");
		}
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(0,root));
		int currentLevel = -1;
		List<Integer> result = new ArrayList<>();
		while(!queue.isEmpty()){
			Tuple t = queue.remove();
			if(t.level != currentLevel){
				result.add(t.node.val);
				currentLevel = t.level;
			}
			if(t.node.right !=null) queue.add(new Tuple(t.level+1,t.node.right)); 
			if(t.node.left !=null) queue.add(new Tuple(t.level+1,t.node.left)); 
		}
		return result;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeRightSideView btsw = new BinaryTreeRightSideView();
		Integer[] parent = {1,2,3,null,4};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		btsw.rightSideView(root).forEach(e-> System.out.println(e));
	}

}
