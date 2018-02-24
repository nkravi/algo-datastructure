package leethcode.medium;

public class MaximumSubarray {
	
	
	public int maxSubArray(int[] nums) {
		
		int local = nums[0];
		int global = nums[0];
		
		for(int i=1;i< nums.length;i++){
			local = Math.max(nums[i], local+nums[i]);
			if(local > global)	global = local;
		}
		
		return global;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaximumSubarray ms = new MaximumSubarray();
		int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(ms.maxSubArray(nums));

	}

}
