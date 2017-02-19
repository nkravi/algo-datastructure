package leethcode.medium;


public class TargetSum {
	
	private int calSum(int[] nums,int target,char[] sign){
		int total = 0;
		for(int i=0; i< sign.length;i++){
			if(sign[i] == '+'){
				total += nums[i];
			}else{
				total += nums[i]*-1;
			}
		}
		return total;
	}
	
	private boolean isTargetAchived(int[] nums,int target, String sign){
		if(nums.length == 0) return false;
		return calSum(nums,target,sign.toCharArray()) == target;
	}
	
	private int findTargetSumWays(int[] nums,int target, String sign,int i,char curr,Integer[] plus,Integer[] minus){
		if(sign.length() == nums.length){
			return (isTargetAchived(nums,target,sign))? 1: 0;
		}else{
			if(curr == '+' && plus[i] != null){
				return plus[i];
			}else if(curr == '-' && minus[i] != null){
				return minus[i];
			}
			else{
				plus[i] =  findTargetSumWays(nums,target,sign+"+",i+1,'+',plus,minus); 
				minus[i] = findTargetSumWays(nums,target,sign+"-",i+1,'-',plus,minus);
				return plus[i] + minus[i];
			}
		}
	}	
	 public int findTargetSumWays(int[] nums, int target) {
		 return findTargetSumWays(nums,target,"",0,'K',new Integer[nums.length],new Integer[nums.length]);
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {};
		int target = 3;
		System.out.println(new  TargetSum().findTargetSumWays(nums, target));

	}

}
