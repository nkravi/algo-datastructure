package leethcode.medium;

import java.util.Arrays;


public class HIndex {

	
	public int hIndex(int[] citations) {
		if(citations ==null || citations.length ==0) return 0;
		
		Arrays.sort(citations);
		int max = Integer.MIN_VALUE;
		for(int i= citations.length-1;i>=0;i--){
			int min = Math.min(citations[i], Math.abs(citations.length-i));
			max = Math.max(max, min);
		}
		return max;
		
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] citations = {100};
		System.out.println(new HIndex().hIndex(citations));
	}

}
