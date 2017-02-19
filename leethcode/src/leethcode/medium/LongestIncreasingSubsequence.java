package leethcode.medium;

public class LongestIncreasingSubsequence {

	
	 public int lengthOfLIS(int[] nums) {
		if(nums == null || nums.length == 0) return 0; 
		
	    int max = 1;
	    int[] lis = new int[nums.length];
	    lis[0] = 1; 
	    
	    for(int i=1; i< nums.length;i++){
	    	int currentMax = 1;
	    	for(int j=0; j< i; j++){
	    		if(nums[i] > nums[j]){
		    		currentMax = Math.max(lis[j]+1,currentMax);
	    		}
	    	}
	    	lis[i] = currentMax;
	    	max = Math.max(currentMax, max);
	    }
	    
	    
	    return max;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));

	}

}
