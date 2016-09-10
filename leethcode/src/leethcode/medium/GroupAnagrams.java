package leethcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	 public List<List<String>> groupAnagrams(String[] strs) {
		 Map<String,List<String>> map = new HashMap<String,List<String>>();
		 List<List<String>> res = new ArrayList<List<String>>();
		 
		 for(String str:strs){
			 char [] astr = str.toCharArray();
			 Arrays.sort(astr);
			 String k = Arrays.toString(astr);
			 List<String> val = map.get(k);
			 if(val == null){
				 val = new ArrayList<String>();
			 }
				 
			 val.add(str);
			 map.put(k, val);
			 
		 }
		 
		 
		 for(String k: map.keySet()){
			 List<String> v = map.get(k);
			 res.add(v);
		 }
		 
		 
		 return res;
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GroupAnagrams ga = new GroupAnagrams();
		String []strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		 List<List<String>> res = ga.groupAnagrams(strs);
		 
		 for(List<String> l :res){
			 System.out.println();
			 for(String s: l){
				 System.out.print(s+"\t");
			 }
		 }
		 
	}

}
