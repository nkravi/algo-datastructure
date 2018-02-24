package leethcode.medium;

import java.util.ArrayList;
import java.util.List;

import leethcode.datastructure.TreeNode;

public class HouseRobberIII {
	
	private void sumByLevelOrder(TreeNode node,List<Integer> sums, int level){
		if(node == null){
			return;
		}
		if(level < sums.size()){
			sums.set(level,sums.get(level) + node.val);
		}else{
			sums.add(node.val);
		}
		sumByLevelOrder(node.left,sums,level+1);
		sumByLevelOrder(node.right,sums,level+1);
	}
	
	
	private int f(int n,List<Integer> nums,Integer[] mem){
		if(n <= 0){
			return 0;
		}else{
			if(mem[n] != null){
				return mem[n];
			}else{
				mem[n] = Math.max(f(n-1, nums,mem),f(n-2,nums,mem)+ nums.get(n-1));
			}
			return mem[n];
		}
	}
	
	private int getMax(List<Integer> nums){
		Integer[] mem = new Integer[nums.size()+1]; 
		return f(nums.size(),nums,mem);
	}
	
	public int rob(TreeNode root) {
		List<Integer> sums = new ArrayList<Integer>();
		sumByLevelOrder(root, sums, 0);
		return getMax(sums);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {2,1,3,null,4};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		System.out.println(new HouseRobberIII().rob(root));
		
	}

}
