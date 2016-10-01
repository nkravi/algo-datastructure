package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class PalindromePermutation {

	public boolean canPermutePalindrome(String s) {
		if(s == null || s.length() == 0) return false;
		
		char[] sArray = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		for(char a: sArray){
			map.put(a,(map.get(a) == null) ? 1: map.get(a)+1); 
		}
		long oddCount  = map.entrySet().stream().parallel().filter(m  -> m.getValue() %2 !=0).count();
				
		return (oddCount ==0) || (oddCount == 1 && s.length()%2 !=0) ;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abbx";
		System.out.println(new PalindromePermutation().canPermutePalindrome(s));

	}

}
