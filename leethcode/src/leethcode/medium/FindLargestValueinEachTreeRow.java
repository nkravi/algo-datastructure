package leethcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

public class FindLargestValueinEachTreeRow {
	private class Tuple{
		private TreeNode node;
		private int level;
		Tuple(TreeNode node,int level){
			this.node = node;
			this.level = level;
		}
	}
	public List<Integer> largestValues(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(root,0));
		
		while(!queue.isEmpty()){
			Tuple tmp = queue.remove();
			if(tmp.node == null)continue;
			Integer largest = (tmp.level < res.size())?res.get(tmp.level):null;
			
			if(largest == null ){
				res.add(tmp.level, tmp.node.val);
			}else if(largest < tmp.node.val){
				res.set(tmp.level, tmp.node.val);
			}
			queue.add(new Tuple(tmp.node.left,tmp.level+1));
			queue.add(new Tuple(tmp.node.right,tmp.level+1));
		}
		
		return res;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer parent[] = {1,3,2,5,3,null,9};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		List<Integer> res = new FindLargestValueinEachTreeRow().largestValues(root);
		for(int r:res){
			System.out.print(r+"\t");
		}
	}

}
