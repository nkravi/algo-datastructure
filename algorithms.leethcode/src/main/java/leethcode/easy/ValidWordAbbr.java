package leethcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ValidWordAbbr {
	Map<String,Integer> map;
    
    private String getAbbrevation(String s){
        if(s.length() < 2){
            return null;
        }
        char[] sArray = s.toCharArray();
        return sArray[0] + "" + (s.length()-2) + "" + sArray[s.length()-1];
    }
    
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String,Integer>();
        for(String s: dictionary){
            String abbr = getAbbrevation(s);
            if(abbr == null) continue;
            Integer val = map.containsKey(abbr) ? map.get(abbr) : 0;
            map.put(abbr,val+1);
        }
    }

    public boolean isUnique(String word) {
        String abbr = getAbbrevation(word);
        return (!map.containsKey(abbr)) || (map.get(abbr) == 1);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] dict = {"dig","dug","dag","dog","doge"};
		
		ValidWordAbbr obj = new ValidWordAbbr(dict);
		System.out.println(obj.isUnique(""));
		

	}

}
