package leethcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch {
	
	private static boolean isSolutionFound = false;
	
	private class Position{
		private int x;
		private int y;
		Position(int x,int y){
			this.x =x;
			this.y = y;
		}
		
		public int hashCode(){
			return (x+" "+y).hashCode();
		}
		public String toString(){
			return "{x:"+this.x+","+"y:"+this.y+"}";
		}
		public boolean equals(Object o){
			Position po = (Position)o;
			return this.x==po.x && this.y ==  po.y;
		}
	}
	
	boolean isFinished(String currStr,String finalStr){
		return currStr.equals(finalStr);
	}
	
	
	List<Position> getNeighbours(char[][] board, char val,Position pos,Set<Position> visited){
		List<Position> neighbours = new ArrayList<>();
		int m= board.length;
		int n = board[0].length;
		for(int i=0;i<m;i++){
			if(i == pos.x) continue;
			char tmpVal = board[i][pos.y];
			Position tmpPos = new Position(i,pos.y);
			if(tmpVal == val && !visited.contains(tmpPos)){
				neighbours.add(tmpPos);
			}
			
		}
		for(int j=0;j<n;j++){
			if(j == pos.x) continue;
			char tmpVal = board[pos.x][j];
			Position tmpPos = new Position(pos.x,j);
			if(tmpVal == val && !visited.contains(tmpPos)){
				neighbours.add(tmpPos);
			}
			
		}
		//System.out.println(pos);
		//System.out.println(val+"-" + neighbours.size()+"-"+ visited.size());
		
		
		
		return neighbours;
	}
	
	void backtrack(char[][] board,Position currPos, Set<Position> visited,String currStr, String finalStr){
		//System.out.println(currStr);
		if(isSolutionFound){
			return;
		}
		if(isFinished(currStr,finalStr)){
			isSolutionFound = true;
			//System.out.println(currStr);
			return;
		}else{
			//System.out.println(currStr);
			List<Position> neighbours = getNeighbours(board,finalStr.charAt(currStr.length()),currPos,visited);
			
			for(Position neighbour: neighbours){
				visited.add(neighbour);
				currStr+= board[neighbour.x][neighbour.y];
				//System.out.println(visited.size());
				backtrack(board,neighbour,visited,currStr,finalStr);
				visited.remove(neighbour);
				currStr = currStr.substring(0, currStr.length()-1);
			}
		}
	}
	
	
	
	public boolean exist(char[][] board, String word) {
		
		Map<Character,List<Position>> map = new HashMap<>();
		
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j< board[i].length;j++){
				List<Position> lst= map.get(board[i][j]);
				if(lst == null) lst = new ArrayList<>();
				lst.add(new Position(i,j));
				map.put(board[i][j], lst);
			}
		}
		
		
		if(map.get(word.charAt(0)) == null) return false;
		
		for(Position p:map.get(word.charAt(0))){
			Set<Position> visited = new HashSet<>();
			backtrack(board,p,visited,word.charAt(0)+"",word);
			if(isSolutionFound) break;
		}
		
		
		return isSolutionFound;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*char[][] board= {
				{'A','B','C','E'},
				{'S','F','C','S'},
				{'A','D','E','E'}
		};*/
		/*char[][] board= {
				{'A','B','C','E'},
				{'B','F','C','S'},
				{'A','D','E','E'}
		};*/
		char [][] board = {
				{'a'}
		};
		String word = "ab";
		System.out.println(new WordSearch().exist(board,word));

	}

}
