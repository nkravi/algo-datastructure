package leethcode.medium;

public class SearchInsertPosition {
	int[] nums;
	int target;
	int index;
	
	void bst(int start,int end){
		int i = (start+end)/2;
		if(start >= end || nums[i] == target){
			index = i;
			return;
		}
		//index = i;
		if(nums[i] < target){
			bst(i+1,end);
		}else{
			bst(start,i-1);
		}
	}
	
	 public int searchInsert(int[] nums, int target) {
		  this.nums = nums;
		  this.target = target;
		  bst(0,nums.length-1);
		  if(target >  nums[index]) index++;
	      return index;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition sip = new SearchInsertPosition();
		int[] nums = {1,3,5,7};
		//int[] nums = {1};
		int target = 0;
		System.out.println(sip.searchInsert(nums, target));

	}

}
