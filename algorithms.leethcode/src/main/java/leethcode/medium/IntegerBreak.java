package leethcode.medium;

public class IntegerBreak {

	 public int integerBreak(int n) {
		 
		 int max[] = new int[n+1];
		 max[0] = 0;
		 max[1] = 0;
		 max[2] = 1;
		 for(int i =3;i<=n;i++){
			 int x1 = (i/2);
			 int x2 = i-x1;
			 max[i] = Math.max(x1*x2, max[x1]*max[x2]);
			 max[i] = Math.max(max[i], x1*max[x2] );
			 max[i] = Math.max(max[i], max[x1]*x2);
			 int halfsplit =  max[i];
			 x1--;
			 x2++;
			 max[i] = Math.max(x1*x2, max[x1]*max[x2]);
			 max[i] = Math.max(max[i], x1*max[x2] );
			 max[i] = Math.max(max[i], max[x1]*x2);
			 
			 max[i] = Math.max(halfsplit, max[i]);
			 
		 }
		 return max[n];
	        
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerBreak i = new IntegerBreak();
		
		System.out.println(i.integerBreak(10));
	}

}
