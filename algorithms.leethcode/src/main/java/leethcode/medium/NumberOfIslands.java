package leethcode.medium;

class cordinates{
	int x;
	int y;
	char val;
	cordinates(int x, int y, char val){
		this.x = x;
		this.y = y;
		this.val = val;
	}
}

class DisjointSet{
	private int[] parent;
	private int[] rank;
	int noOfSets;
	DisjointSet(int n){
		parent = new int[n];
		rank = new int[n];
		noOfSets = 0;
	}
	
	int find(int i){
		if(i != parent[i]) parent[i] = find(parent[i]);
		return parent[i];
	}
	void makeSet(int i){
		parent[i] = i;
		rank[i] = 0;
		noOfSets++;
	}
	void union(int i, int j){
		int iId = find(i);
		int jId = find(j);
		if(iId == jId) return;
		noOfSets--;
		if(rank[iId] > rank[jId]){
			parent[jId] = iId;
		}else{
			parent[iId] = jId;
			if(rank[iId] == rank[jId]) rank[jId] = rank[jId] + 1;
		}
	}
}


public class NumberOfIslands {
	
	char[][] grid;
	private int generateId(int x,int y, int colLen){
		return (colLen*x) + y;
	}
	
	private char look(int x,int y){
		char val = '0';
		try{
			val = grid[x][y];
			return val;
		}catch(ArrayIndexOutOfBoundsException e){
			return val;
		}
	}
	
	private cordinates up(int x,int y){
		int x1 = x;
		int y1 = y+1;
		char val = look(x1,y1);
		return new cordinates(x1,y1,val);
	}
	private cordinates down(int x,int y){
		int x1 = x;
		int y1 = y-1;
		char val = look(x1,y1);
		return new cordinates(x1,y1,val);
	}
	private cordinates left(int x,int y){
		int x1 = x-1;
		int y1 = y;
		char val = look(x1,y1);
		return new cordinates(x1,y1,val);
	}
	private cordinates right(int x,int y){
		int x1 = x+1;
		int y1 = y;
		char val = look(x1,y1);
		return new cordinates(x1,y1,val);
	}
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length ==0){
			return 0;
		}
		this.grid = grid;
		int colLen = grid[0].length;
		DisjointSet d = new DisjointSet(colLen*grid.length);
		//make set
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j] == '1'){
					d.makeSet(generateId(i,j,colLen));
				}
			}
		}
		
		for(int i=0;i<grid.length;i++){
			for(int j=0;j<grid[i].length;j++){
				if(grid[i][j]=='0')
					continue;
				
				int id1 = generateId(i,j,colLen);
				cordinates up = up(i,j);
				cordinates down = down(i,j);
				cordinates left = left(i,j);
				cordinates right = right(i,j);
				
				if(up.val != '0'){
					int id2 = generateId(up.x,up.y,colLen);
					if(d.find(id1) != d.find(id2)){
						d.union(id1, id2);
					}
						
				}
				if(down.val !='0'){
					int id2 = generateId(down.x,down.y,colLen);
					if(d.find(id1) != d.find(id2)){
						d.union(id1, id2);
					}
						
				}
				if(left.val !='0'){
					int id2 = generateId(left.x,left.y,colLen);
					if(d.find(id1) != d.find(id2)){
						d.union(id1, id2);
					}
						
				}
				if(right.val !='0'){
					int id2 = generateId(right.x,right.y,colLen);
					if(d.find(id1) != d.find(id2)){
						d.union(id1, id2);
					}
						
				}
			}
		}
	 	return d.noOfSets;      
	}
	
	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		char[][] grid ={
				{'1','1','0','0','0'},
				{'1','1','0','0','0'},
				{'0','0','1','0','0'},
				{'0','0','0','1','1'}	
		};
		System.out.println(noi.numIslands(grid));
	}

}
