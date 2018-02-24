package leethcode.easy;

public class AddDigits {
	
	String addAllDigits(String s){
		int sum = 0;
		for(char c:s.toCharArray()){
			sum+= Integer.parseInt(c+"");
		}
		return Integer.toString(sum);
		
	}
	
	int singleDigit(String num){
		if(num.length() == 1)
			return Integer.parseInt(num);
		else{
			return singleDigit(addAllDigits(num));
		}
	}
	
	public int addDigits(int num) {
        return singleDigit(num+"");
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new AddDigits().addDigits(38));

	}

}
