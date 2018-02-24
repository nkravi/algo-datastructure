package leethcode.easy;

public class ClimbingStairs {
 
    private int CountStairs(int n){
    	if(n==0){
    		return 1;
    	}else if(n<0){
    		return 0;
    	}
    	return CountStairs(n-1)+CountStairs(n-2);
    		
    }
	public int climbStairs(int n) {
		if(n==1){
			return 1;
		}
		int[] k = new int[n];
		k[0] = 1;
		k[1] = 2;
		for(int i=2;i<n;i++){
			k[i] = k[i-1] + k[i-2];
		}
		return k[n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs cs =  new ClimbingStairs();
		
		System.out.println(new ClimbingStairs().climbStairs(7));

	}

}
