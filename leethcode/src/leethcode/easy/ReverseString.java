package leethcode.easy;

public class ReverseString {
  
	public String reverseString(String s) {
		char[] sArray = s.toCharArray();
		int i=0,j=sArray.length-1;
		while(i < j){
			char tmp = sArray[i];
			sArray[i] = sArray[j];
			sArray[j] = tmp;
			i++;j--;
		}
        return new String(sArray);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ReverseString().reverseString("nirmal kumar"));
	}

}
