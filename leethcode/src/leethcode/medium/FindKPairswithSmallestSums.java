package leethcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class A{
	int sum;
	int[] arr;
	A(int a,int b){
		arr = new int[2];
		arr[0] = a;
		arr[1] = b;
		sum= a+b;
	}
}
class AComparator implements Comparator<A>{
	@Override
	public int compare(A arg0, A arg1) {
		if(arg0.sum < arg1.sum) return -1;
		else if(arg0.sum > arg1.sum) return 1;
		else return 0;
	}
}
public class FindKPairswithSmallestSums {
	
	 public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		 PriorityQueue<A> q = 
		            new PriorityQueue<A>(k, new AComparator());
		 
		 for(int i=0;i<nums1.length;i++){
			 for(int j=0;j<nums2.length;j++){
				 A a = new A(nums1[i],nums2[j]);
				 q.add(a);
			 }
		 }
		 
		 List<int[]> lst = new ArrayList<int[]>();
		 
		 for(int i=0 ;i<k && q.size() !=0;i++){
			 lst.add(q.remove().arr);
		 }
		 
		 return lst;
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
