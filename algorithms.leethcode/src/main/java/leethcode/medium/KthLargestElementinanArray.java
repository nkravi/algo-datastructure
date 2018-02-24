package leethcode.medium;


import java.util.Comparator;
import java.util.PriorityQueue;

class kcomparator implements Comparator<Integer>{

	@Override
	public int compare(Integer o1, Integer o2) {
	  if(o1 <o2) return 1;
	  else if(o1 > o2) return -1;
	  else return 0;
	}
}

public class KthLargestElementinanArray {

	public int findKthLargest(int[] nums, int k) {
		int largest =0;
		kcomparator kc = new kcomparator();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(nums.length,kc);
		for(int i:nums){
			q.add(i);
		}
		for(int i=0;i<k;i++){
			largest = q.remove();
		}
		
		return largest;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KthLargestElementinanArray kle = new KthLargestElementinanArray();
		int[] nums = {3,2,1,5,6,4};
		int k = 2;
		System.out.println(kle.findKthLargest(nums, k));

	}

}
