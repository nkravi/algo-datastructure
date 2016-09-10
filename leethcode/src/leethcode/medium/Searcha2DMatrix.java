package leethcode.medium;

public class Searcha2DMatrix {

	int[][] matrix;
	/*
	private int xyToId(int i, int j, int colLen){
		return (i*colLen)+j;
	}*/
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
	
	private  int indexOf(int length, int key,int colLen) {
		int lo = 0;
		int hi = length - 1;
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
		int colLen = matrix[0].length;
		int len = matrix.length * colLen;
		this.matrix = matrix;
		
		int res = indexOf(len,target,colLen);
		
		
		return res!= -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Searcha2DMatrix s2d = new Searcha2DMatrix();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		int target = 0;
		System.out.println(s2d.searchMatrix(matrix, target));
	}

}
