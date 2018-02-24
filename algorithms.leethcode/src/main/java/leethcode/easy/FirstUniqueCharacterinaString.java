package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueCharacterinaString {
	
	
	public int firstUniqChar(String s) {
		if(s == null || s.length() ==0 ) return -1;
		
		char[] sArray = s.toCharArray();
		Map<Character,Integer> map = new HashMap<>();
		
		for(char a: sArray){
			map.put(a, (map.containsKey(a) ? map.get(a)+1 : 1));
		}
		
		
		for(int i=0;i< sArray.length;i++){
			if(map.get(sArray[i]) == 1) return i;
		}
		
		
		return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FirstUniqueCharacterinaString fuc = new FirstUniqueCharacterinaString();
		System.out.println(fuc.firstUniqChar("leetcode"));
		System.out.println(fuc.firstUniqChar("loveleetcode"));
		System.out.println(fuc.firstUniqChar("aabbcc"));


	}

}
