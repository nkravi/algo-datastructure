package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import leethcode.datastructure.TreeNode;

public class MostFrequentSubtreeSum {

	private int getCountBySubTree(TreeNode node,Map<Integer,Integer> countFreq){
		if(node == null){
			return 0;
		}else{
			int left = getCountBySubTree(node.left,countFreq);
			int right = getCountBySubTree(node.right,countFreq);
			int sum = node.val+left+right;
			if(!countFreq.containsKey(sum)){
				countFreq.put(sum, 0);
			}
			countFreq.put(sum, countFreq.get(sum)+1);
			return sum;
		}
	}
	
	private int getMosttValue(Map<Integer,Integer> map){
		int max = Integer.MIN_VALUE;
		for(Integer k:map.keySet())
			max = Math.max(max,map.get(k));
		return max;
	}
	
	private List<Integer> getKeysByVal(Map<Integer,Integer> map,int val){
		List<Integer> keys = new ArrayList<>();
		for(Integer k: map.keySet()){
			if(map.get(k)==val) keys.add(k);
		}
		return keys;
	}
	
	private int[] listToArray(List<Integer> lst){
		int[] ints = new int[lst.size()];
		int i=0;
		for(Integer l: lst){
			ints[i++] = l.intValue();
		}
		return ints;
	}
	
	public int[] findFrequentTreeSum(TreeNode root) {
		if(root == null)return null;
		Map<Integer,Integer> countFreq = new HashMap<>();
		getCountBySubTree(root,countFreq);
		int mostFreq = getMosttValue(countFreq);
		return listToArray(getKeysByVal(countFreq,mostFreq));        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] parent = {1,2,3,4};
		TreeNode root = TreeNode.createNodeFromArray(parent);
		int[] vals = new MostFrequentSubtreeSum().findFrequentTreeSum(root);
		for(int v:vals) System.out.println(v);

	}

}
