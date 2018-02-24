package leethcode.medium;

public class DecodeWays {
	private boolean isValid2(char[] arr,int i){
		if(i+1>= arr.length || arr[i] == '0') return false;		
		String s = ""+arr[i] +""+arr[i+1];
		int num = Integer.parseInt(s);
		return num>=1 && num <=26;
	}
	private boolean isValid1(char[] arr,int i){
		if(i>= arr.length) return false;
		String s = ""+arr[i];
		int num = Integer.parseInt(s);
		return num>=1 && num <=26;
	} 
	
	private int decode(char[] arr,int i,Integer[] memo){
		if(i==arr.length) return 1;
		if(i>arr.length) return 0;
		if(memo[i] != null) return memo[i];
		memo[i] = (isValid1(arr,i)?decode(arr,i+1,memo):0) + (isValid2(arr,i)?decode(arr,i+2,memo):0); 
		return memo[i];
	}

	public int numDecodings(String s) {
		if(s==null || s.length() ==0 || s.charAt(0) == '0') return 0;
		return decode(s.toCharArray(),0,new Integer[s.length()]);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "101";
		System.out.println(new DecodeWays().numDecodings(s));

	}

}
