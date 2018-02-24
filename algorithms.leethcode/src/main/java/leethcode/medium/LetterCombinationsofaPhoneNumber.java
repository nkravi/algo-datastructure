package leethcode.medium;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofaPhoneNumber {
	
	
	private boolean isDone(String currStr, int length,List<String> res) {
		if(currStr.length() == length){
			res.add(currStr);
			return true;
		}
		
		return false;
	}
	
	private List<String> genrateCandidates(String currStr, char[] digitArray, String[] mapping, int k) {
		List<String> res = new ArrayList<>();
		char[] map = mapping[Integer.parseInt(digitArray[k]+"")].toCharArray();
		for(char c: map){
			res.add(currStr+c);
		}
		return res;
	}
	
	void DFS(String currStr,char[] digitArray,String[] mapping,int k,List<String> res){
		if(isDone(currStr,digitArray.length,res)){
			return;
		}else{
			List<String> candidates = genrateCandidates(currStr,digitArray,mapping,k);
			for(String candidate: candidates){
				DFS(candidate,digitArray,mapping,k+1,res);
			}
			
		}
	}
	
	public List<String> letterCombinations(String digits) {
		List<String> res = new ArrayList<>();
		if(digits == null || digits.length() == 0){
			return res;
		}
		char[] digitArray = digits.toCharArray();
		String[] mapping = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		DFS("",digitArray,mapping,0,res);
        return res;
    }

	public static void main(String[] args) {
		
		List<String> res = new LetterCombinationsofaPhoneNumber().letterCombinations("89");
		System.out.println(res.size());
		
	}

}
