package leethcode.easy;

public class ReverseVowelsofaString {

	private boolean isVowel(char c){
		c= Character.toLowerCase(c);
		return c=='a'|| c== 'e' || c== 'i' || c== 'o' || c=='u'; 
	}
	
	
	public String reverseVowels(String s) {
		char[] sArray = s.toCharArray();
		
		int i=0, j= sArray.length-1;
		
		while(i<j){
			boolean iv = isVowel(sArray[i]);
			boolean jv = isVowel(sArray[j]);
			if(iv && jv){
				char tmp = sArray[i];
				sArray[i] = sArray[j];
				sArray[j] = tmp;
				i++;j--;
			}else{
				if(!iv) i++;
				if(!jv) j--;
			}
		}
		return new String(sArray);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( new ReverseVowelsofaString().reverseVowels("leetcode"));

	}

}
