/**
 * 
 */
package leethcode.easy;

/**
 *Given a non-negative number represented as an array of digits, 
 *plus one to the number.The digits are stored such that the 
 *most significant digit is at the head of the list.
 *
 */
public class PlusOne {

	public int[] plusOne(int[] digits) {
		int carry = 1;
		int[] ans = new int[digits.length];
		for(int i=digits.length-1;i>=0;i--){
			int tmp = digits[i] + carry;
			 carry = (tmp > 9)? tmp/10 : 0;
			 ans[i] = tmp %10;
		}
		int[] ans1 = new int[digits.length+1];
		
		if(carry != 0){
			ans1[0] = carry;
			for(int i=0;i<ans.length;i++){
				ans1[i+1] = ans[i];
			}
			return ans1;
		}
		//ans[0] = carry;
		return ans;
        
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] input = {8,9,9,9};
		int [] output = new PlusOne().plusOne(input);
		for(int i: output){
			System.out.print(i);
		}
		

	}

}
