package main;

public class Solution {
	
	public static int getMaxProfit(int[] prices) {
		
		int minPrice, maxProfit;
		minPrice = prices[0];
		maxProfit = prices[1] - prices[0];
		
		for(int i = 2; i < prices.length; i++) {
			int currentPrice = prices[i];
			
			int potentialProfit = currentPrice - minPrice;
			
			minPrice = Math.min(minPrice, currentPrice);
			
			maxProfit = Math.max(potentialProfit, maxProfit);
		}
		
		
		
		
		return maxProfit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {10, 7, 5, 8, 11, 9};
		
		System.out.println(Solution.getMaxProfit(prices));

	}

}
