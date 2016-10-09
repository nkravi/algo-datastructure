package leethcode.easy;


public class RotateFunction {
	
	private int rotate(int A[],int index){
		int n = 0;
		int sum =0;
		int length = A.length;
		while(n < length){
			sum += (n*A[index]);
			index++;
			if(index == length){
				index = 0;
			}			
			n++;
		}
		return sum;		
	}
	
	public int maxRotateFunction(int[] A) {
		 if(A== null || A.length == 0){
		        return 0;
		 }
		int max = Integer.MIN_VALUE;
		for(int i=0;i<A.length;i++){
			max = Integer.max(max, rotate(A,i));
		}
		return max;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []nums = {4,3,2,6};
		System.out.println(new RotateFunction().maxRotateFunction(nums));
	}

}
