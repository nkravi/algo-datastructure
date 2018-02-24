package leethcode.mock1;

public class LengthofLastWord {
	
	 public int lengthOfLastWord(String s) {
		char [] sarr = s.toCharArray();
		int wordLen = 0;
		for(int i=sarr.length-1;i >=0; i--){
			if(sarr[i] == ' ' && wordLen > 0){
				break;
			}else if(sarr[i] != ' ') wordLen++;
		}
		return wordLen;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "world";
		System.out.println(new LengthofLastWord().lengthOfLastWord(s));
	}

}
