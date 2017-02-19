package leethcode.medium;

public class UniquePathsII {

	private boolean isValid(int row,int col, int m, int n,int[][] obstacleGrid){
		if(row < 0|| col < 0 || row+1 > m || col+1 > n){
			return false;
		}
		if(obstacleGrid[row][col] == 1) return false;
		return true;
	}
	private boolean isDestination(int row,int col, int m, int n){
		return row+1==m && col+1==n;
	}
	private int path(int row,int col, int m,int n,int[][] obstacleGrid,Integer[][] dict){
		if(!isValid(row,col,m,n,obstacleGrid)) return 0;
		if(isDestination(row,col,m,n)) return 1;
		if(dict[row][col] != null){
			return dict[row][col];
		}else{
			dict[row][col] =  path(row+1,col,m,n,obstacleGrid,dict) + path(row,col+1,m,n,obstacleGrid,dict);
			return dict[row][col];
		}
	}
	 public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		    int m = obstacleGrid.length;
		    int n = obstacleGrid[0].length;
		 	Integer[][] dict = new Integer[m][n];
	        return path(0,0,m,n,obstacleGrid,dict);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
		
		System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid) );

	}

}
