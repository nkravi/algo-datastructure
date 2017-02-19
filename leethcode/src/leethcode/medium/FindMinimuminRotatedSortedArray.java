package leethcode.medium;

public class FindMinimuminRotatedSortedArray {
	
	private int converge(int[] nums, int low, int high){
			return 0;
	}
	
	public int findMin(int[] nums) {
		return converge(nums,0,nums.length-1);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,4,5,1};
		System.out.println(new FindMinimuminRotatedSortedArray().findMin(nums));

	}

}
