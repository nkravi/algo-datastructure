package leethcode.medium;
import java.util.*;

import leethcode.datastructure.TreeNode;

public class PathSumII {

	
	private void dfs(TreeNode node,int currentSum,int finalSum,String track,List<String> res){
		if(node == null){
			track = "";
			return;
		}
		track += node.val +"\t";
		currentSum = currentSum + node.val;
		if(node.left == null && node.right == null){
			if(currentSum == finalSum){
				res.add(track);
				track = "";
				return;
			}
		}
		dfs(node.left, currentSum , finalSum,track,res); 
		dfs(node.right, currentSum, finalSum,track,res);

		
	}
	
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> res = new ArrayList<>();
		List<String> tmpRes = new ArrayList<>(); 
		dfs(root,0,sum, "",tmpRes);
		
		for(String s: tmpRes){
			List<Integer> l = new ArrayList<>();
			for(String i: s.split("\t")){
				l.add(Integer.parseInt(i));
			}
			res.add(l);
		}
	     return res;   
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer[] parent = {1,2,2};
		int sum = 3;
		TreeNode root =TreeNode.createNodeFromArray(parent);
		List<List<Integer>> res = (new PathSumII().pathSum(root, sum));
		for(List<Integer> l: res){
			for(Integer i: l){
				System.out.print(i+"\t");
			}
			System.out.println();
		}
	}

}
