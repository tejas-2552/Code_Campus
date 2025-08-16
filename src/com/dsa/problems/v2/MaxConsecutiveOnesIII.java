package com.dsa.problems.v2;

/*
 * Given a binary array nums and an integer k, return the maximum number of
 * consecutive 1's in the array if you can flip at most k 0's.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2 Output: 6 Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
 * subarray is underlined. Example 2:
 * 
 * Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3 Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
 * flipped from 0 to 1. The longest subarray is underlined.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1. 0 <= k <= nums.length
 */
public class MaxConsecutiveOnesIII {
	public static void main(String arags[]) {
		int nums[] = new int[] { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;
		System.out.println(longestOnesBF(nums, k));
	}

	public static int longestOnes(int[] nums, int k) {
//		{ 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };

		int zeroCount = 0;
		int start = 0;
		int maxOnes = 0;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				zeroCount++;
			}
			while (zeroCount > k) {
				if (nums[start] == 0) {
					zeroCount--;
				}
				start++;
			}
			printArray(nums, start, end);
			maxOnes = Math.max(maxOnes, end - start + 1);
		}
		return maxOnes;
	}

	public static void printArray(int[] nums, int start, int end) {
		while (start <= end && start < nums.length) {
			System.out.print(nums[start] + " ");
			start++;
		}
		System.out.println();
	}

	public static int longestOnesBF(int[] nums, int k) {

		int start = 0;
		int zeroCount = 0;
		int max = 0;
		for (int end = 0; end < nums.length; end++) {
			if (nums[end] == 0) {
				zeroCount++;
			}
			while (zeroCount > k) {
				if (nums[start] == 0) {
					zeroCount--;
				}
				start++;
			}

			max = Math.max(max, end - start + 1);
		}
		return max;
	}
}