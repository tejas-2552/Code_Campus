package com.dsa.problems;

/*
 *  1. Best Time to buy and sell stocks
 *  2. Best Time to buy and sell stocks II
 *  
 */
public class MediumHardProblems1 {

	public static void main(String args[]) {

		int[] arr = { 7, 1, 5, 3, 6, 4 };

		System.out.println(maxMinBuySellProfit(arr));

		System.out.println(sumMaxProfit(arr));

	}

	public static int maxMinBuySellProfit(int[] arr) {

		int len = arr.length;
		int maxProfit = 0;
		int minBuy = arr[0];
		for (int i = 1; i < len; i++) {
			if (minBuy > arr[i]) {
				minBuy = arr[i];
			} else {
				maxProfit = Math.max(maxProfit, arr[i] - minBuy);
			}
		}
		return maxProfit;
	}

	public static int sumMaxProfit(int[] prices) {

		int len = prices.length;
		int maxProfit = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] > prices[i - 1]) {
				maxProfit = maxProfit + (prices[i] - prices[i - 1]);
			}

		}
		return maxProfit;

	}

}
