package com.dsa.problems.v2;

/*
 * You are given an integer array nums consisting of n elements, and an integer
 * k.
 * 
 * Find a contiguous subarray whose length is equal to k that has the maximum
 * average value and return this value. Any answer with a calculation error less
 * than 10-5 will be accepted.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,12,-5,-6,50,3], k = 4 Output: 12.75000 Explanation: Maximum
 * average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75 Example 2:
 * 
 * Input: nums = [5], k = 1 Output: 5.00000
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= k <= n <= 105 -104 <= nums[i] <= 104
 */
public class MaximumAverageSubarrayI {

	public static void main(String arsg[]) {
		int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
		System.out.println(findMaxAverage(nums, 4));
		printSlidingPattern(nums, 4);

		System.out.println(1 + 12 + (-5) + (-6));
	}

	public static double findMaxAverage(int[] nums, int k) {
		int maxSum = Integer.MIN_VALUE;

		// 10 - 4 = 6
		for (int i = 0; i <= nums.length - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				sum = sum + nums[j];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return (double) maxSum / k;
	}

	public static void printSlidingPattern(int[] nums, int k) {

		for (int i = 0; i <= nums.length - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				System.out.print(nums[j] + " ");
				sum =+ nums[j];
			}
			System.out.print(" :: " + sum);
			System.out.println();
		}
	}
	
}
