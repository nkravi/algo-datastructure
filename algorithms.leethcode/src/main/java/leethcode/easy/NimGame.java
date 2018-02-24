package leethcode.easy;

public class NimGame {
	 public boolean canWinNim(int n) {
		 if(n<= 3)
			 return true;
		 
		// boolean[] win = new boolean[n];
		 boolean win1 = true;
		 boolean win2 = true;
		 boolean win3 = true;
		 
		 for(int i =3; i<n;i++){
			 boolean res = !(win1 && win2 && win3);
			 win1 = win2;
			 win2 = win3;
			 win3 = res;
		 }
		 
	      return win3;  
	 }
	 public static void main(String[] args) {
		 System.out.println(new NimGame().canWinNim(4));
	 }
}
