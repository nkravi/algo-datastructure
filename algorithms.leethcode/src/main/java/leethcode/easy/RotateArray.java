package leethcode.easy;

public class RotateArray {
	
	public void rotate(int[] nums, int k) {
		
		int[] tmp = new int[nums.length];
		
		for(int i=0; i< nums.length;i++){
			int index = (i+k)%nums.length;
			tmp[index] = nums[i];
		}
		
		for(int i=0;i< nums.length;i++){
			nums[i] = tmp[i];
		}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,2,3,4,5,6,7};
		int k =3;
		new RotateArray().rotate(nums, k);
		for(int i: nums){
			System.out.print(i+"\t");
		}

	}

}
