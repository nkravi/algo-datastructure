package leethcode.medium;

public class CoinChange {

	
	private int minCoin(int[] dist,int[] change){
	    int min = Integer.MAX_VALUE; 
		for(int d: dist){
			if(d>=0 &&  change[d] != -1 && change[d]+1 < min){
				min = change[d]+1;
			}	
		}
		return (min == Integer.MAX_VALUE) ? -1: min;
		
	}
	
	
	private int[] computeDistance(int[] coins, int amount){
		int[] dist = new int[coins.length];
		int i =0;
		for(int coin: coins){
			dist[i] = amount -coin; 
			i++;
		}
		return dist;
	}
	
	public int coinChange(int[] coins, int amount) {
		int[] change = new int[amount+1];
		change[0] = 0;
		int dist[];
		int min;
		for(int i=1;i<change.length;i++){
			dist = computeDistance(coins,i);
			min = minCoin(dist,change);
			if(min == -1){
				change[i] = -1;
				//break;
			}
			change[i] =  min;
		}
			
		
		return change[amount];
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CoinChange cg = new CoinChange();
		int[] coins = {2};
		int amount = 4;
		System.out.println(cg.coinChange(coins, amount));
	}

}
