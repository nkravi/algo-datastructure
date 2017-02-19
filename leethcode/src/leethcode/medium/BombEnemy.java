package leethcode.medium;



public class BombEnemy {
	class Kill{
		private int right;
		private int left;
		private int top;
		private int bottom;
	}
	
	private int killed(int i, int j, int rowLen, int colLen, char[][] grid){
		System.out.println(i);
		if(i < 0 || j < 0 || i > rowLen || j > colLen || grid[i][j] == 'W'){
			return 0;
		}else{
			char gridVal = grid[i][j];
			Kill k = new Kill();
			//k.left += killed(i-1,j,rowLen,colLen,grid);
			k.right +=  killed(i+1,j,rowLen,colLen,grid);
			/*k.bottom += killed(i,j+1,rowLen,colLen,grid);
			k.top +=  killed(i,j-1,rowLen,colLen,grid);
			if(gridVal == 'E'){
				k.left += 1;
				k.right += 1;
				k.bottom += 1;
				k.top += 1;
			}*/
			return k.left + k.right + k.top + k.bottom;
		}
	}
	
	
	
	public int maxKilledEnemies(char[][] grid) {
		int rowLen = grid.length-1;
		int colLen = grid[0].length-1;
		
		return killed(0,0,rowLen,colLen,grid);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		char[][] grid = {
				{'0','E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'},
		};
		
		System.out.println(new BombEnemy().maxKilledEnemies(grid));

	}

}
