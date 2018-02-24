package leethcode.easy;

public class RemoveDuplicatesfromSortedArray {

	private void swap(int nums[], int i,int j){
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public int removeDuplicates(int[] nums) {
		if(nums == null || nums.length ==0){
			return 0;
		}
		
		int ptr1 = 0;
		int ptr2 = 0;
		
		while(ptr2 < nums.length){
			if(nums[ptr1] != nums[ptr2]){
				ptr1++;
				swap(nums,ptr1,ptr2);
			}
			ptr2++;
		}
		return ptr1+1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {1,1,2,2,3,4,5};
		int k = new RemoveDuplicatesfromSortedArray().removeDuplicates(nums);
		for(int i= 0;i<k;i++){
			System.out.print(nums[i] + "\t");
		}
		
	}

}
