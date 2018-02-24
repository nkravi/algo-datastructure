package leethcode.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ThirdMaximumNumber {
	
	private boolean isValNotin(int val, List<Integer> vals){
		return !vals.contains(val);
	}
	public int thirdMax(int[] nums) {
		if(nums == null || nums.length ==0){
			return -1;
		}
		List<Integer> vals = new ArrayList<>();
		for(int i=0 ; i< 3; i++){
			boolean isFound = false;
			int max = Integer.MIN_VALUE;
			for(int k=0;k<nums.length;k++){
				if(nums[k] >= max && isValNotin(nums[k],vals)){
					max = nums[k];
					isFound = true;
				}
			}
			if(isFound)
				vals.add(max);
		}
		
		return (vals.size() >= 3) ?Collections.min(vals): Collections.max(vals);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,2,3,3};
		System.out.println(new ThirdMaximumNumber().thirdMax(nums));
		

	}

}
