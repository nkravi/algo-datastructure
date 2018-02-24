package leethcode.medium;

public class IsSubsequence {

	
	public boolean isSubsequence(String s, String t) {
		if(s== null || t== null ) return false;
		if(s.length() > t.length()) return false;
		if(s.length() == 0) return true;
		
		boolean[][] fillIns = new boolean[s.length()+1][t.length()+1];
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		
		//fill initial value
		for(int j=0;j< fillIns[0].length;j++){ fillIns[0][j] = true;}
		for(int i=1;i< fillIns.length;i++){fillIns[i][0] = false;}
		
		//fill remaining values
		
		for(int i=1;i<fillIns.length;i++){
			for(int j=1;j<fillIns[i].length;j++){
				
				if(sArray[i-1] == tArray[j-1]){
					//look top
					fillIns[i][j] = fillIns[i-1][j-1];
				}else{
					//look left
					fillIns[i][j] = fillIns[i][j-1];
				}
			}
		}
		
		return fillIns[s.length()][t.length()];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String s = "abc"; String t = "ahbgdc";
		String s = "axc";String t = "ahbgdc";
		//String s = "eee";String t= "eettt";
		//
		System.out.println(new IsSubsequence().isSubsequence(s, t));

	}

}
