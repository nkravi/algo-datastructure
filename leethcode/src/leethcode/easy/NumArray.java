package leethcode.easy;

public class NumArray {
	int nums[];
	public NumArray(int[] nums) {
		this.nums = nums;
	}

	public int sumRange(int i, int j) {
		int sum = 0;
		for(int k=i;k<=j;k++)
			sum +=nums[k];
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {-2, 0, 3, -5, 2, -1};
		NumArray nm = new NumArray(input);
		System.out.println(nm.sumRange(0, 2));
		System.out.println(nm.sumRange(2, 5));
		System.out.println(nm.sumRange(0, 5));
	}

}
