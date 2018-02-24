package leethcode.medium;

public class Searcha2DMatrixII {
	int[][] matrix;
	
	private int[] idToXY(int id, int colLen){
		int[] xy = new int[2];
		xy[0] = id/colLen;
		xy[1] = id - (xy[0]*colLen);
		return xy;
	}

	int getVal(int id,int colLen){
		int [] xy = idToXY(id,colLen);
		
		return matrix[xy[0]][xy[1]];
	}
	private  int indexOf(int start,int end, int key,int colLen) {
		int lo = start;
		int hi = end -1;
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2;
			if (key < getVal(mid,colLen))
				hi = mid - 1;
			else if (key > getVal(mid,colLen))
				lo = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) return false;
		
		this.matrix = matrix;
		int colLen = matrix[0].length;
		int length = colLen * matrix.length;
		boolean found = false;
		for(int i=0,j=colLen;j<=length;i = i+colLen,j= j+ colLen){
			int res = indexOf(i,j,target,colLen);
			if(res != -1){
				found = true;
				break;
			}
		}
		return found;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searcha2DMatrixII s2d = new Searcha2DMatrixII();
		int [][] matrix = {
				 {1,   4,  7, 11, 15},
				 {2,   5,  8, 12, 19},
				 {3,   6,  9, 16, 22},
				 {10, 13, 14, 17, 24},
				 {18, 21, 23, 26, 30}
		};
		int target = 8;
		System.out.println(s2d.searchMatrix(matrix, target));

	}

}
