package leethcode.medium;

public class MaximumProductSubarray {
	
	public int maxProduct(int[] nums) {
		int localMax = nums[0];
		int globalMax = nums[0];
		int localMin = nums[0];
		
		for(int i=1;i< nums.length;i++){
			int temp = localMax;
			localMax = Math.max(Math.max(localMin*nums[i], localMax*nums[i]),nums[i]);
			localMin = Math.min(Math.min(temp*nums[i], localMin*nums[i]),nums[i]);
			
			if(localMax > globalMax) globalMax = localMax;
		}
		
		return globalMax;
		
        
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MaximumProductSubarray msp = new MaximumProductSubarray();
		int []nums = {2,3,2,4};
		System.out.println(msp.maxProduct(nums));

	}

}
