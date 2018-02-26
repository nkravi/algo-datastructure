package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 */


/*
 * abba cdddcd xyx
 * farthest = a[i]
 * for each c in string:
 * 	check where is last c:
 * 		if farthest == currPtr:
 * 			one split found
 *          return
 *      else:
 *         update farthest move to next
 *  runtime O(n) 
 *  mem    O(c)// at max we can have map of size 26
 *  
 *  abab d ee
 *  
 *  a->2
 *  b->3
 *  d->4
 *  e->6
 */

public class PartitionLabels {
	private int currIndex=0;
	
	private Map<Character,Integer> findLastOccurence(char[] sChar){
		Map<Character,Integer> map = new HashMap<>();
		
		for(int i=sChar.length-1; i>=0 ; i--) {
			if(!map.containsKey(sChar[i])) {
				map.put(sChar[i], i);
			}
		}
		return map;
	}
	
	private int getSplitCount(char[] sChar, Map<Character,Integer> map, int farthest) {
		int startIndex=currIndex;
		while(farthest != currIndex) {
			farthest = Math.max(farthest, map.get(sChar[currIndex]));
			currIndex++;
		}
		currIndex++;
		return currIndex-startIndex;
		
	}
	
	 public List<Integer> partitionLabels(String str) {
		 if(str == null || str.length() ==0) {
			 return null;
		 }
		 char[] sChar = str.toCharArray(); 
		 List<Integer> res = new ArrayList<>();
		 Map<Character,Integer>  map = findLastOccurence(sChar);
		 
		 while(currIndex < sChar.length) {
			 res.add(getSplitCount(sChar,map, map.get(sChar[currIndex]))); 
		 }
		 return res;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij");
		res.forEach((x)-> System.out.println(x));
		
	}

}
