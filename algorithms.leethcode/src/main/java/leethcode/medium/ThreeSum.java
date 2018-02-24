package leethcode.medium;

import java.util.*;

public class ThreeSum {

	class Triplets{
		private int _0;
		private int _1;
		private int _2;
		Triplets(int a, int b, int c){
			this._0 = Integer.min(c,Integer.min(a, b));
			this._2 = Integer.max(c, Integer.max(a, b));
			this._1 = (a+b+c) - (this._0+this._2);	
		}
		
		@Override
		public
		int hashCode(){
			String str = this._0+""+this._1+""+this._2;
			return str.hashCode();
		}
		@Override
		public boolean equals(Object o){
			Triplets other = (Triplets) o;
			return other.hashCode() == this.hashCode();
			
		}
		public List<Integer> toList(){
			List<Integer> lst= new ArrayList<>();
			lst.add(this._0);
			lst.add(this._1);
			lst.add(this._2);
			return lst;
		}
	}
	
	public List<List<Integer>> threeSum(int[] nums) {
		Set<Triplets> set = new HashSet<>();
		List<List<Integer>> res = new ArrayList<>();
	    if(nums == null || nums.length < 3) return res;
	    Arrays.sort(nums);
	    int len = nums.length;
	    for(int i = 0; i < len; i++) {
	        int target = 0 - nums[i];
	        int j = i + 1, k = len - 1;
	        while(j < k) {
	            if(nums[j] + nums[k] == target) {
	            	set.add(new Triplets(nums[i], nums[j], nums[k]));
	            	j++;k--;
	            } else if(nums[j] + nums[k] < target) {
	                j++;
	            } else {
	                k--;
	            }
	        }
	    }
		for (Triplets t: set){
			res.add(t.toList());
		}
	    return res;    
	}
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = (new ThreeSum().threeSum(nums));
		for(List<Integer> l: res){
			System.out.println();
			for(Integer i: l){
				System.out.print(i+"\t");
			}
		}
	}

}
