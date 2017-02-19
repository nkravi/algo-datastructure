package leethcode.medium;

import java.util.List;

public class PalindromePartitioning {
	
	private boolean isPalindrome(String s){
		char[] sArray = s.toCharArray();
		int i = 0, j= s.length()-1;
		while(i<j){
			if(sArray[i] != sArray[j]) {
				return false;
			}
			i++;j--;
		}
		return true;
	}
	
	private boolean isSolution(String s, int start, int end) {
		return false;
	}

	private void DFS(String s,int start,int end,int distance){
		if(isSolution(s,start,end)){
			return;
		}else{
			
		}
		
		
	}
	
	

	public List<List<String>> partition(String s) {
		return null;   
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
