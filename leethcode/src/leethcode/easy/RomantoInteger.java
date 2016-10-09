package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {
	
	 public int romanToInt(String s) {
		 
		 if(s == null || s.length() == 0){
			 return 0;
		 }
		 Map<Character, Integer> map = new HashMap<>();
		 map.put('I', 1);
		 map.put('V', 5);
		 map.put('X', 10);
		 map.put('L', 50);
		 map.put('C', 100);
		 map.put('D', 500);
		 map.put('M', 1000);
		 map.put('$', 0);
		 
		 s = s+'$';
		 char [] sArray = s.toCharArray();
		 int tot = 0;
		 for(int i=0,j=1;j<s.length();i++,j++ ){
			 tot +=  (map.get(sArray[i]) < map.get(sArray[j])) ? map.get(sArray[i])*-1: map.get(sArray[i]);
		 }
		 return tot;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I";
		System.out.println(new RomantoInteger().romanToInt(s));

	}

}
