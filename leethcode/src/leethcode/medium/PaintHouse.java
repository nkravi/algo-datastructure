package leethcode.medium;

public class PaintHouse {
	
	public int minCost(int[][] costs) {
	    if(costs==null||costs.length==0){
	        return 0;
	    }
	    for(int i=1; i<costs.length; i++){
	        costs[i][0] += Math.min(costs[i-1][1],costs[i-1][2]);
	        costs[i][1] += Math.min(costs[i-1][0],costs[i-1][2]);
	        costs[i][2] += Math.min(costs[i-1][1],costs[i-1][0]);
	    }
	    int n = costs.length-1;
	    return Math.min(Math.min(costs[n][0], costs[n][1]), costs[n][2]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] costs = {
				{1,3,4},
				{2,7,6},
				{5,4,3}
		};
		
		
		int [][] costs1 = {
				{5,8,6},
				{19,14,13},
				{7,5,12},
				{14,15,17},
				{3,20,10}
		};
		System.out.println();
		System.out.println(new PaintHouse().minCost(costs1));
		

	}

}
