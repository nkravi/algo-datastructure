package leethcode.medium;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		if(nums == null || nums.length ==0){
			return -1;
		}
		int low = 0;
		int high = nums.length - 1;
		int len = nums.length;
		if(nums.length == 1) return 0;
		if(nums.length == 2){
			return (nums[0] > nums[1]) ? 0: 1 ;
		}
		
		
		while(low <= high){
			int middle = low + (high-low)/2;
			if(middle == 0 && (nums[middle] > nums[middle+1])){
				return middle;
			}
			if(middle == len-1 && (nums[middle] > nums[middle-1])){
				return middle;
			}
			if((nums[middle] > nums[middle+1]) && nums[middle] > nums[middle-1]){
				return middle;
			}
			if(nums[middle+1] > nums[middle]){ //go right
				low = middle +1;
			}else{ //go left
				high = middle -1;
			}
		}
		
		
		return -1;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,2,3,1};
		System.out.println(new FindPeakElement().findPeakElement(nums));

	}

}
