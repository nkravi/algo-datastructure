package leethcode.medium;

import javax.sound.midi.Synthesizer;

public class MaximumSizeSubarraySumEqualsk {
	
	private int count=-1;
	private int k;
	
	private void print(int[] nums,int start,int end){
		System.out.println(start+"\t"+end);
		/*for(int i=start;i<=end;i++){
			System.out.print(nums[i]);
		}
		System.out.println();*/
	}
	
	private int divideAndConquer(int[] nums,int start, int end){
		//divide
	    
	    	if(start >= end){
	    		//System.out.println(nums[start]);
	    		return nums[start];
	    	}
	 
		int half = start+(end-start)/2;
		int left = divideAndConquer(nums,start,half);
		int right = divideAndConquer(nums,half+1,end);
		int tmp = 0;
		System.out.println(left +"\t"+right);
		if(k==left){
			tmp = half-start+1;
			count = (count > tmp)?count:tmp;
		}
		if(k==right){
			tmp = end-half+1+1;
			count = (count > tmp)?count:tmp;
		}
		if(k==left+right){
			tmp = end-start+1;
			count = (count > left+right)?count:left+right;
		}
		return left+right;
		
	}
	
	
	 public int maxSubArrayLen(int[] nums, int k) {
		 this.k = k;
		 divideAndConquer(nums,0,nums.length-1);
		 return this.count;
	        
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,2,3,4};
		int k=9;
		System.out.println(new MaximumSizeSubarraySumEqualsk().maxSubArrayLen(nums, k));

	}

}
