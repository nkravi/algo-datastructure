package leethcode.easy;

public class RemoveElement {
	
	private void swap(int[] nums,int i,int j){
		int tmp  = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}
	public int removeElement(int[] nums, int val) {
	   int ptr1 = 0;
	   int ptr2 = 0;
		
	   while(ptr2<nums.length){
		   if(nums[ptr1] == val){
			   ptr2++;
		   }else{
			   ptr1++;
			   if(nums[ptr2] !=  val && nums[ptr1] == val){
				   swap(nums,ptr1,ptr2);
				   ptr1++;
				   ptr2++;
			   }else{
				   ptr2++;
			   }
			   
		   }
	   }
	   
	   
       return ptr1; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4};
		int val = 3;
		int limit = new RemoveElement().removeElement(nums, val);
		for(int i=0;i<limit;i++)
			System.out.println(nums[i]);

	}

}
