package leethcode.hard;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Nirmal
 * 
 * For each building do BFS and fill the empty space with distance.
 * Also check if empty space is reachable. if not its not the candidate
 * 
 * iterate through all the values and find one which is minimum and also 
 * can be visited from all buildings
 *
 */

public class ShortestDistancefromAllBuildings {

	class Tuple{
		int row;
		int col;
		int dist;
		Tuple (int row,int col){
			this(row,col,0);
		}
		Tuple(int row,int col,int dist){
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	public int[][] calculateDistance(int[][] grid,int row,int col){
		int rowLen = grid.length;
		int colLen = grid[0].length;
		boolean[][] isVisited = new boolean[rowLen][colLen];
		
		int[][] dist = new int[rowLen][colLen];
		Queue<Tuple> queue = new LinkedList<>();
		queue.add(new Tuple(row,col));
		while(!queue.isEmpty()){
			Tuple t= queue.remove();
			if(t.row <0 || t.row >= rowLen || t.col <0 || t.col >= colLen ){
				continue;
			}
			if(isVisited[t.row][t.col] || grid[t.row][t.col] == 2 || 
					(grid[t.row][t.col] == 1 && !(t.row ==row && t.col == col))){
				continue;
			}
			isVisited[t.row][t.col] = true;
			dist[t.row][t.col] = t.dist;
			
			//Top
			queue.add(new Tuple(t.row+1,t.col,t.dist+1));
			//bottom
			queue.add(new Tuple(t.row-1,t.col,t.dist+1));
			//left
			queue.add(new Tuple(t.row,t.col-1,t.dist+1));
			//right
			queue.add(new Tuple(t.row,t.col+1,t.dist+1));
		}
		return dist;
	}
	
	private void addUnvistedNode(int[][] dist,boolean[][] isNotVisted){
		for(int row=0;row < dist.length; row++){
			for(int col=0; col< dist[row].length; col++){
				if(dist[row][col] == 0){
					isNotVisted[row][col] = true;
				}
			}
		}
	}
	
	private void addDistance(int[][] localDist,int[][] globalDist){
		for(int row=0;row < localDist.length; row++){
			for(int col=0; col< localDist[row].length; col++){
				globalDist[row][col] += localDist[row][col];
			}
		}
		
	}
	private int findMin(int[][] grid,int[][] dist,boolean[][] isNotVisited){
		int min = Integer.MAX_VALUE;
		for(int row=0;row<grid.length;row++){
			for(int col=0;col<grid[row].length;col++){
				//empty space and visited by all buildings
				if(grid[row][col] == 0 && !isNotVisited[row][col]){
					min = Math.min(min, dist[row][col]);
				}
			}
		}
		if(min == Integer.MAX_VALUE){
			min = -1;
		}
		return min;
	}
	
	public int shortestDistance(int[][] grid) {
		int[][] globalDist = new int[grid.length][grid[0].length];
		boolean[][] isNotVisited = new boolean[grid.length][grid[0].length];
		for(int row=0; row < grid.length; row++){
			for(int col=0; col< grid[row].length; col++){
				if(grid[row][col] == 1){//building
					//do BFS
					int[][] localDist = calculateDistance(grid,row,col);
					addUnvistedNode(localDist,isNotVisited);
					addDistance(localDist,globalDist);
				}
				
			}
		}
		int min = findMin(grid,globalDist,isNotVisited);
		return min;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][]
				/*{
			{1,1},
			{0,1}
		};*/
		
		//int[][] dist = new ShortestDistancefromAllBuildings().calculateDistance(grid,0,1);
		//printArray(dist);
		{
			{1,0,2,0,1},
			{0,0,0,0,0},
			{0,0,1,0,0}
		};
		System.out.println(new ShortestDistancefromAllBuildings().shortestDistance(grid));
	}

}
