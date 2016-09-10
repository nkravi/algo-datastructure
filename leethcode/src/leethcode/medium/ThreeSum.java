package leethcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	private List<Integer> sortedList(int a, int b, int c){
		List<Integer> sorted = new ArrayList<Integer>();
		int[] arr = new int[3];
		arr[0] = a;
		arr[1] = b;
		arr[2] = c;
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length;i++)
			sorted.add(arr[i]);
		
		return sorted;
	}
	private void sumPair(int nums[], int sumIndex,Set<List<Integer>> res){
		//List<List<Integer>> res = new ArrayList<List<Integer>>();
		int sum = -1*nums[sumIndex];
		Set<Integer> set = new HashSet<Integer>();
		
		for(int i=0;i<nums.length;i++){
			if(i==sumIndex)
				continue;
			int pair = sum - nums[i];
			if(set.contains(pair)){
				List<Integer> triples = sortedList(nums[i],pair,nums[sumIndex]);
				res.add(triples);
				set.remove(pair);
			}else{
				set.add(nums[i]);
			}
		}
	}
	
	
	 public List<List<Integer>> threeSum(int[] nums) {
		 
		 Set<List<Integer>> ans = new HashSet<List<Integer>>();
		 for(int i=0;i<nums.length;i++){
			 sumPair(nums,i,ans);
		 }
		return  new ArrayList<List<Integer>>(ans); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSum threesum = new ThreeSum();
		int [] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> result = threesum.threeSum(nums);
		for(List<Integer> l : result){
			System.out.println();
			for(int i: l){
				System.out.print(i+"\t");
			}
		}
		
		
	}

}
