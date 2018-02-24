package leethcode.easy;

public class StringtoInteger {
	
	 public int myAtoi(String str) {
		 if(str == null || str.trim().length() == 0){
			 return 0;
		 }
		 str = str.trim();
		 boolean isNegative =  false;
		 if(str.charAt(0) == '-'){
			 isNegative = true;
		 }
		 long res  = 0;
		 char[] arr = str.toCharArray();
		 for(char a: arr){
			 if(a>='0' && a<='9'){
				 res = (res*10) + a - '0';
			 }
			 
		 }
		 if(isNegative)
			 res = res*-1;
			 
		 return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE ) ? ((int)res): 0;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new StringtoInteger().myAtoi(" -2,147,483,6"));

	}

}
