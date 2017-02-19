package leethcode.easy;

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if(haystack == null || needle == null || haystack.equals(needle)) return 0;
		if(needle.length() > haystack.length()) return -1;
		if(needle.length() == 0) return 0; 
		int ret = -1;
		char[] hArray = haystack.toCharArray();
		char[] nArray = needle.toCharArray();
		
		
		for(int i=0,j=0; i< hArray.length; i++){
			if(j< nArray.length && hArray[i] == nArray[j]){
				j++;
			}else{
				j=0;
				i = i - j;
			}
			if(j == nArray.length) {
				ret = i;
				break;
			}
		}
		return (ret != -1)? ret- (needle.length()-1): ret;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ImplementstrStr().strStr("Nirmalkumar", "ar"));
	}

}
