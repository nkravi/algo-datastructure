package leethcode.easy;


public class HouseRobber {
	public int rob(int[] nums) {
		
		if(nums == null || nums.length ==0 ) return 0;
		if(nums.length == 1) return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		
		int[] robs = new int[nums.length];
		robs[0] = nums[0];
		robs[1] = nums[1];
		
		int maxVal =  robs[0];
		
		for(int i=2;i<robs.length;i++){
			robs[i] = Math.max(maxVal+nums[i], robs[i-1]);
			maxVal = Math.max(maxVal, robs[i-1]);
			
		}
		
		//IntStream.range(2, nums.length).forEach(i -> {robs[i] = Math.max(robs[i-2]+nums[i], robs[i-1]);});
		return robs[robs.length-1];
    }

	public static void main(String[] args) {
		int[] nums = {2,1,1,2};

		System.out.println(new HouseRobber().rob(nums));

	}
}
