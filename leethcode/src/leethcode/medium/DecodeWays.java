package leethcode.medium;

import java.util.ArrayList;
import java.util.List;

public class DecodeWays {

	private boolean isValid(String s){
		int i = Integer.parseInt(s);
		return i>0 && i<=26;
	}
	private List<Character> filter(String s){
		char[] sArray = s.trim().toCharArray();
		List<Character> l = new ArrayList<Character>();
		for(char a: sArray){
			if(isValid(Character.toString(a))){
				l.add(a);
			}else{
				return new ArrayList<Character>(); 
			}
		}
		return l;
	}
	
	public int numDecodings(String s) {
		List<Character> sArray = filter(s);
		if(sArray.size() == 0) return 0;
		int[][] solve = new int[sArray.size()][sArray.size()];
		
		for(int i=0;i<solve.length;i++){
			for(int j=0;j<solve[i].length;j++){
				if(j>=i){
					if(i == 0){
						solve[i][j] =1;
					}else{
						int m = Math.max(solve[i-1][j-1], solve[i-1][j]);
						String num =  Character.toString(sArray.get(j-1)) + Character.toString(sArray.get(j));
						solve[i][j] = (isValid(num)) ? m+1:m;
					}
				}
			}
		}
		
		return solve[sArray.size()-1][sArray.size()-1];
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "12";
		System.out.println(new DecodeWays().numDecodings(s));

	}

}
