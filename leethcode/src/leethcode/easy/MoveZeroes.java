package leethcode.easy;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {
		if(nums == null || nums.length <=1){
			return;
		}
		int ptr1 = 0;
		int ptr2 = 1;
		while(ptr2<nums.length){
			if(nums[ptr1] != 0){
				ptr1++;ptr2++;
			}else{
				if(nums[ptr2] == 0){
					ptr2++;
				}else{
					int tmp = nums[ptr1];
					nums[ptr1] = nums[ptr2];
					nums[ptr2] = tmp;
					ptr1++;
					ptr2++;
				}
			}	
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1};
		new MoveZeroes().moveZeroes(nums);
		for(int i:nums){
			System.out.print(i+"\t");
		}
	}

}
