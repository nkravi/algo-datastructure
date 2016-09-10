package leethcode.medium;
import java.util.HashMap;
import java.util.Map;


public class LongestSubstringWithoutRepeatingCharacters {
	
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int local = 0;
		char[] str = s.toCharArray();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i=0; i< str.length;i++){
			Integer val = map.get(str[i]);
			if(val == null){
				local ++;
			}else{
				local = (i - val);
				map = new HashMap<Character,Integer>();
				for(int k=val+1;k<i;k++){
					map.put(str[k], k);
				}
			}
			map.put(str[i], i);
			if( local > max){
				max = local;
			}
		}
		
        return  max;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters lc = new LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcbb";
		System.out.println(lc.lengthOfLongestSubstring(s));

	}

}
