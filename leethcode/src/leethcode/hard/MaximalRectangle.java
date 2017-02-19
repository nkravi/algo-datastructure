package leethcode.hard;

public class MaximalRectangle {
	
	private static void test(int m,int n){
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				for(int k=0;k<m-i;k++){
					for(int l=0;l<n-j;l++){
						//if( k==1 && l ==1)
							System.out.println(i+" "+j+" "+k+" "+l);
					}
				}
				
			}
		}		
	}
	
	 public int maximalRectangle(char[][] matrix) {
		 return 0;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(4,5);

	}

}
