package leethcode.hard;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestDistancefromAllBuildings {

	class Tuple{
		private int row;
		private int col;
		private int dist;
		Tuple(int row,int col,int dist){
			this.row = row;
			this.col = col;
			this.dist = dist;
		}
	}
	
	private List<Tuple> getNeighbours(Tuple t,int rowLen,int colLen){
		List<Tuple> neighbours = new LinkedList<>();
		if(t.row-1 >=0){
			neighbours.add(new Tuple(t.row-1,t.col,t.dist+1));
		}
		if(t.row+1 < rowLen){
			neighbours.add(new Tuple(t.row+1,t.col,t.dist+1));
		}
		if(t.col-1 >=0){
			neighbours.add(new Tuple(t.row,t.col-1,t.dist+1));
		}
		if(t.col+1 <colLen){
			neighbours.add(new Tuple(t.row,t.col+1,t.dist+1));
		}
		return neighbours;
	}
	
	private void BFS(int row,int col,final int[][] grid,int[][] visitedCount,int[][] dist,boolean[][] visited){
		Queue<Tuple> queue = new LinkedList<Tuple>();
		int rowLen = grid.length; int colLen= grid[0].length;
		queue.add(new Tuple(row,col,0));
		while(!queue.isEmpty()){
			Tuple t = queue.remove(); 
			if(visited[t.row][t.col]) continue;
			visited[t.row][t.col] = true;
			visitedCount[t.row][t.col] +=1;
			for(Tuple neighbour: getNeighbours(t,rowLen,colLen)){
				if(!visited[neighbour.row][neighbour.col] && grid[neighbour.row][neighbour.col] == 0){
					
					dist[neighbour.row][neighbour.col]+= neighbour.dist;
					queue.add(neighbour);
				}
			}	
		}
	}
	
	
	
	 public int shortestDistance(int[][] grid) {
		int[][] visitedCount = new int[grid.length][grid[0].length];
		int[][] dist = new int[grid.length][grid[0].length];
		int buildings = 0;
		int minDist = Integer.MAX_VALUE;
		
		for(int i=0;i<grid.length;i++){
			for(int j=0; j< grid[i].length;j++){
				if(grid[i][j] == 1){
					buildings++;
					BFS(i,j,grid,visitedCount,dist,new boolean[grid.length][grid[0].length]);
					break;
				}
			}
		}
		
		
		for(int i=0;i<grid.length;i++){
			for(int j=0; j< grid[i].length;j++){
				System.out.println(visitedCount[i][j]);
				if(grid[i][j] == 0 && visitedCount[i][j]==buildings){
					minDist = Integer.min(minDist,dist[i][j]);
				}
			}
		}
		
		
		 return (minDist==Integer.MAX_VALUE)?-1:minDist;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = new int[][]{
			{1,0,2,0,1},
			{0,0,0,0,0},
			{0,0,1,0,0}
		};
		System.out.println(new ShortestDistancefromAllBuildings().shortestDistance(grid));
	}

}
