package leethcode.easy;

public class HouseRobber {
	public int rob(int[] nums) {
		if( nums == null || nums.length ==0 )
			return 0;
		int cost[] = new int[nums.length];
		if (nums.length == 2) {
			return nums[0] > nums[1] ? nums[0] : nums[1];
		} else if (nums.length == 1) {
			return nums[0];
		} else {
			cost[0] = nums[0];
			cost[1] = nums[0] > nums[1] ? nums[0] : nums[1];
			for (int i = 2; i < nums.length; i++) {
				cost[i] = Math.max(nums[i] + cost[i - 2], cost[i - 1]);

			}
			return cost[nums.length - 1];
		}
	}

	public static void main(String[] args) {
		int[] nums = {  };

		System.out.println(new HouseRobber().rob(nums));

	}
}
