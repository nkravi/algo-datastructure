package leethcode.medium;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {
	
	private boolean isExists(String s,Set<String> wordDict,int i,int j,boolean arr[][]){
		boolean ret = false;
		
		String sub = s.substring(i,j+1);
		
		if(wordDict.contains(sub)){
			ret =  true;
		}else{
			for(int breakPos=i;breakPos<=j;breakPos++){
				if( arr[i][breakPos] &&  arr[breakPos+1][j]){
							ret =  true;
							break;
						}
			}
		}
		return ret;
		
	}
	
	
	public boolean wordBreak(String s, Set<String> wordDict) {
		if(s== null || s.length() == 0) return false;
		char[] sArray = s.toCharArray();
		boolean[][] resArray = new boolean[sArray.length][sArray.length];
		for(int l=0,d=0;l<sArray.length;l++,d++){
			for(int i=0,j=d;j< sArray.length;i++,j++ ){
				resArray[i][j] = isExists(s,wordDict,i,j,resArray);
			}
		}
		
		return resArray[0][sArray.length-1];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "leethcode";
		Set<String> wordDict = new HashSet<>(); 
		wordDict.add("l");
		wordDict.add("eeth");
		wordDict.add("code");
		System.out.println(new WordBreak().wordBreak(s, wordDict));

	}

}
