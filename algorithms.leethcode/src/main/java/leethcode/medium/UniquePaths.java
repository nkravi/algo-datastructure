package leethcode.medium;

public class UniquePaths {

	private boolean isValid(int row,int col, int m, int n){
		if(row < 0|| col < 0 || row+1 > m || col+1 > n){
			return false;
		}
		return true;
	}
	private boolean isDestination(int row,int col, int m, int n){
		return row+1==m && col+1==n;
	}
	private int path(int row,int col, int m,int n,Integer[][] dict){
		if(!isValid(row,col,m,n)) return 0;
		if(isDestination(row,col,m,n)) return 1;
		if(dict[row][col] != null){
			return dict[row][col];
		}else{
			dict[row][col] =  path(row+1,col,m,n,dict) + path(row,col+1,m,n,dict);
			return dict[row][col];
		}
	}
	public int uniquePaths(int m, int n) {
		Integer[][] dict = new Integer[m][n];		
		return path(0,0,m,n,dict);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new UniquePaths().uniquePaths(10, 10));
		//System.out.println(new UniquePaths().uniquePaths1(10, 10));
	}

}
