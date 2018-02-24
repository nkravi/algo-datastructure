package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import leethcode.datastructure.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	
	class Tuple{
		TreeNode node;
		int colNum;
		Tuple(TreeNode node,int colNum){
			this.node = node;
			this.colNum = colNum;
		}
	}
	
	public List<List<Integer>> verticalOrder(TreeNode root) {
		if(root == null) return new ArrayList<List<Integer>>();
        int min = 0;
		int max = 0;
		Queue<Tuple> queue = new LinkedList<Tuple>();
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		queue.add(new  Tuple(root,0));
		
		while(!queue.isEmpty()){
			Tuple node = queue.remove();
			List<Integer> vals = map.containsKey(node.colNum) ? map.get(node.colNum) : new ArrayList<Integer>();
			vals.add(node.node.val);
			map.put(node.colNum, vals);
			if(node.node.left != null){
				queue.add(new Tuple(node.node.left,node.colNum-1));
				min=Math.min(min,node.colNum-1);
			}
			if(node.node.right != null){
				queue.add(new Tuple(node.node.right,node.colNum+1));
				max=Math.max(max,node.colNum+1);
			}
		}
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i=min;i<=max;i++){
			if(map.containsKey(i)){
				List<Integer> ints = map.get(i);
				res.add(ints);
			}
		}
		return res;
    }

	public static void main(String[] args) {
		
		Integer[] parent = {1,2,3,4,5};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		List<List<Integer>> res = new BinaryTreeVerticalOrderTraversal().verticalOrder(root);
		for(List<Integer> r: res){
			System.out.println();
			for(Integer i: r){
				System.out.print(i+"\t");
			}
			
			
		}
		
	}

}
