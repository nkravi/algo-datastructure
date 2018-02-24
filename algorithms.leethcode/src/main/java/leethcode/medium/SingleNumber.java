package leethcode.medium;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {
	
	
	public int singleNumber(int[] nums) {
		Set<Integer> s = new HashSet<Integer>();
		
		for(int n: nums){
			if(s.contains(n))
				s.remove(n);
			else
				s.add(n);
		}
		int theNumber = 0;
		for(Integer n: s){
			theNumber = n.intValue();
			//System.out.println(n);
		}
		
		return theNumber;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums[] = {1,1,2,2,3};
		System.out.println(new SingleNumber().singleNumber(nums));
	}

}
