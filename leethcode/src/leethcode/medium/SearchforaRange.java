package leethcode.medium;

public class SearchforaRange {
	
	private int index;
	private int[] nums;
	private int target;
	void bst(int start,int end){
		int i = (start+end)/2;
		if(start >= end || nums[i] ==target){
			index =i;
			return;
		}
		if(nums[i] < target){
			bst(i+1,end);
		}else{
			bst(start,i-1);
		}
	}
	public int[] searchRange(int[] nums, int target) {
		this.nums = nums;
		int range[] = new int[2];
		range[0] = -1;
		range[1] = -1;
		//search for lower limit
		this.target = target -1;
		bst(0,nums.length-1);
		int lower = this.index;
		
		//search for higher range
		this.target = target +1;
		bst(0,nums.length-1);
		int higher = this.index;
		
		
		for(int i=lower; i <= higher; i++){
			if(nums[i] == target){
				if(range[0] == -1){
					range[0] = i;
					range[1] = i;
				}else{
					range[1] = i;
				}
			}
		}
		return range;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchforaRange sfr = new SearchforaRange();
		int nums[] = {2,2};
		int target = 1;
		int res[] =sfr.searchRange(nums, target);
		System.out.println(res[0]+"<-"+"->"+res[1]);
		
	}

}
