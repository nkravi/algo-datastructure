package leethcode.easy;

public class ValidPalindrome {

	public boolean isPalindrome(String s) {
		if(s == null) return false;
		char[] sarray = s.toLowerCase().toCharArray();
		int ptr1 = 0;
		int ptr2 = sarray.length-1;
		
		while(ptr1<= ptr2){
			if(Character.isLetterOrDigit(sarray[ptr1]) && Character.isLetterOrDigit(sarray[ptr2])){
				//System.out.println(sarray[ptr1] +" "+ sarray[ptr2]);
				if(sarray[ptr1] != sarray[ptr2]){
					return false;
				}
				ptr1++;ptr2--;
			}else{
				if(!Character.isLetterOrDigit(sarray[ptr1])){
					ptr1++;
				}
				if(!Character.isLetterOrDigit(sarray[ptr2])){
					ptr2--;
				}
			}
		}
		return true;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "";
		System.out.println(new ValidPalindrome().isPalindrome(s) );

	}

}
