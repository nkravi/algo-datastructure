package leethcode.medium;

public class LongestPalindromicSubstring {
	
	public String longestPalindrome(String s) {
		boolean[][] arr = new boolean[s.length()][s.length()];
		//base case
		/*for(int i=0;i<s.length();i++){
			arr[i][i] = true;
		}*/
		
		char []sArray = s.toCharArray();
		int start = 0;
		int end = 1;
		
		//String substring = s.charAt(0)+"";
		for(int i=0;i< arr.length;i++){
			for(int k=0,d=i;d< arr.length;d++,k++){
				if(k==d){
					arr[k][d] = true;
					continue;
				}
				arr[k][d] = (sArray[k] == sArray[d]) && ((k+1<=d-1)?arr[k+1][d-1]:true);
				if(arr[k][d] == true){
					//substring = s.substring(k, d+1);
					start = k; end = d+1;
				}
			}
		}
		return s.substring(start,end);
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestPalindromicSubstring().longestPalindrome("banana"));
	}

}
