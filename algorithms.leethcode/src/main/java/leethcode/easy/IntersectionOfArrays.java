package leethcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IntersectionOfArrays {

	
	 public int[] intersect(int[] nums1, int[] nums2) {
		 Map<Integer,Integer> m = new HashMap<Integer,Integer>();
		// List<Integer> ans = new ArrayList<Integer>();
		 Set<Integer> s = new HashSet<Integer>();
		 int small[] = null;
		 int large[] = null; 
		 if(nums1.length < nums2.length){
			 small = nums1;
			 large = nums2;
		 }else{
			 small = nums2;
			 large = nums1;
		 }
		 for(int k: small){
			 Integer v = m.get(k);
			 if(v == null)
				 v = 0;
			 m.put(k, ++v);
		 }
		 
		 for(int k: large){
			 Integer v = m.get(k);
			 if(v== null || v==0)//no match
				 continue;
			 //ans.add(k);
			 s.add(k);
			 m.put(k, --v);
			 
		 }
		 
	    int[] a = new int[s.size()];
	    Object []ss = s.toArray(); 
	    for(int i=0; i<s.size();i++){
	    	a[i] = (int)ss[i];
	    }
	    
	    return a;
	    
	 }
	public static void main(String[] args) {
		int nums1[] = {1,2};
		int nums2[] = {1,1};
		int ans[] = new IntersectionOfArrays().intersect(nums1, nums2);
		for(int i:ans){
			System.out.print(i+",");
		}
		
	}

}
