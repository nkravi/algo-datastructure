package leethcode.medium;

public class Pow {

	
	private double pow(double x, int n){
		if(n == 0){
			return 1;
		}else if(n%2 == 0){
			return pow(x*x,n/2);
		}else{
			return x*pow(x*x,(n-1)/2) ;
		}
	}
	
	public double myPow(double x, int n) {
		if(n < 0){
			return pow(1/x,n*-1);
		}else{
			return pow(x,n);
		}
		
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double x = 2;
		int n = 3;
		System.out.println(new Pow().myPow(x, n));

	}

}
