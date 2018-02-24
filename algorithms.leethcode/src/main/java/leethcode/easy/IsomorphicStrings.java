package leethcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicStrings {
	
	public boolean isIsomorphic(String s, String t) {
		char[] cs = s.toCharArray();
		char[] ct = t.toCharArray();
		Map<Character,Character> m = new HashMap<Character, Character>();
		Set<Character> mapped = new HashSet<Character>();
		for(int i= 0 ;i<cs.length;i++){
			Character temp = m.get(cs[i]);
			if(temp != null){
				if(temp != ct[i])
					return false;
			}else{
				//new mapping
				if(mapped.contains(ct[i]))
					return false;
				m.put(cs[i], ct[i]);
				mapped.add(ct[i]);
			}
		}
		
		return true;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "paper";
		String t = "title";
		System.out.println(new IsomorphicStrings().isIsomorphic(s, t));

	}

}
