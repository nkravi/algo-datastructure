package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
	
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> s = new HashMap<Integer,Integer>();
		int ans[] = new int[2];
		for(int i=0;i<nums.length;i++){
			Integer v = s.get(target-nums[i]);
			if(v == null){
				s.put(nums[i], i);
			}else{
				ans[0] = v;
				ans[1] = i;
			}
		}
		return ans;
		
	        
	}
	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int[] res = new TwoSum().twoSum(nums, 9);
		System.out.println(res[0]+","+res[1]);
	}
}
