package leethcode.easy;

public class BestTimetoBuyandSellStock {
	
	
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length < 2){
			return 0;
		}
		int currProfit = prices[1] - prices[0];
		int minVal = prices[0];
		int maxProfit = Integer.MIN_VALUE;
		for(int i =1; i< prices.length; i++){
			currProfit = Integer.max(currProfit, prices[i]- minVal);
			maxProfit = Integer.max(maxProfit, currProfit);
			minVal = Integer.min(minVal, prices[i]);
		}
		
		return (maxProfit<0)? 0: maxProfit;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {7, 6, 4, 3, 1};
		System.out.println(new BestTimetoBuyandSellStock().maxProfit(prices));
	}

}
