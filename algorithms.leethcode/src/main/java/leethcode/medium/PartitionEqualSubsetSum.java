package leethcode.medium;

public class PartitionEqualSubsetSum {
	
	private int calSum(int[] nums){
		int sum = 0;
		for(int i:nums) sum+=i;
		return sum;
	}

	private boolean canPartition(int[] nums,int elemUsed,int currPtr,int currTotal,int target){
		System.out.println(target+" "+elemUsed+" "+currTotal);
		if(target == currTotal && elemUsed == nums.length/2){
			return true;
		}
		if(currPtr >= nums.length){
			return false;
		}
		return canPartition(nums,elemUsed+1,currPtr+1,currTotal+nums[currPtr],target) || canPartition(nums,elemUsed,currPtr+1,currTotal,target);

	}
	 public boolean canPartition(int[] nums) {
	
	       if(nums.length%2 != 0 ) return false;
	       int sum  = calSum(nums);
	       if(sum%2 != 0) return false;
	       return canPartition(nums,0,0,0,sum/2);
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,5,11,5};
		System.out.println(new PartitionEqualSubsetSum().canPartition(nums));

	}

}
