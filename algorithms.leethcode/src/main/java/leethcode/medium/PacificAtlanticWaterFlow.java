package leethcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
	
	private String isBoundry(int row,int col,int[][] matrix,boolean[][] visited,String[][] path){
		String s = "";
		if(row<=0 || col <= 0){
			s+= "P";
		} 
		if(row >= matrix.length -1 || col >= matrix[0].length-1){
			s+= "A";
		}
		if(path[row][col] != null && path[row][col].equals("PA")){
			s= "PA";
		}
		return (s.length() == 0)? null : s;
	}
	
	private String pacificAtlantic(int row,int col,int[][] matrix,boolean[][] visited,String[][] path){
		 String boundary = isBoundry(row,col,matrix,visited,path);
		if( boundary != null ){
			path[row][col] = boundary;
		}else{
			visited[row][col] = true;
			String left="X",right="X",top="X",bottom="X";
			int elevation = matrix[row][col];
			if(!visited[row][col-1] && matrix[row][col-1] <= elevation){
				left = pacificAtlantic(row,col-1,matrix,visited,path);
			}
			if(!visited[row][col+1] && matrix[row][col+1] <= elevation){
				right = pacificAtlantic(row,col+1,matrix,visited,path);
			}
			if(!visited[row+1][col] && matrix[row+1][col] <= elevation){
				top = pacificAtlantic(row+1,col,matrix,visited,path);
			}
			if(!visited[row-1][col] && matrix[row-1][col] <= elevation){
				bottom = pacificAtlantic(row-1,col,matrix,visited,path);
			}
			String combine = left+right+top+bottom; 
			System.out.println(combine+" "+ row +" "+col);
			if(combine.contains("PA")){
				path[row][col] = "PA";
			}else if(combine.contains("P")){
				path[row][col] = "P";
			}else if(combine.contains("A")){
				path[row][col] = "A";
			}else{
				path[row][col] = "X";
			}
		}
		return path[row][col];
	}
	
	void printMatrix(String[][] path){
		for(int i=0; i< path.length;i++){
			System.out.println();
			for(int j=0; j< path[i].length;j++){
				System.out.print(path[i][j]+"\t");
			}
			
		}
		
		
	}
	
	public List<int[]> pacificAtlantic(int[][] matrix) {
		String[][] path = new String[matrix.length][matrix[0].length];
		List<int[]> res = new ArrayList<int[]>();
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j< matrix[i].length;j++){
				pacificAtlantic(i,j,matrix,new boolean[matrix.length][matrix[0].length],path);
				if("PA".equals(path[i][j])){
					int[] ij = new int[2];
					ij[0] = i; ij[1] = j;
					res.add(ij);
				}
			}
		}
		//pacificAtlantic(2,2,matrix,new boolean[matrix.length][matrix[0].length],path);
		printMatrix(path);
		return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = new int[][]{
				{1,2,2,3,5},
				{3,2,3,4,4},
				{2,4,5,3,1},
				{6,7,1,4,5},
				{5,1,1,2,4}
		};
		List<int[]> res = new PacificAtlanticWaterFlow().pacificAtlantic(matrix);
		
		for(int[] r : res){
			System.out.println(r[0]+" "+r[1]);
		}
		
	}

}
