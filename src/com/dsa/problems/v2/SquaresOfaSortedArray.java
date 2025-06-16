package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given an integer array nums sorted in non-decreasing order, return an array
 * of the squares of each number sorted in non-decreasing order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-4,-1,0,3,10] Output: [0,1,9,16,100] 
 * Explanation: After squaring, the array becomes [16,1,0,9,100]. After sorting, it becomes
 * [0,1,9,16,100]. 
 * 
 * Example 2:
 *
 * Input: nums = [-7,-3,2,3,11] Output: [4,9,9,49,121]
 * 
 */
public class SquaresOfaSortedArray {

	public static void main(String arsg[]) {
		int[] nums = { -7, -3, 2, 3, 11 };
		System.out.println(Arrays.toString(sortedSquares(nums)));

	}

	public static int[] sortedSquares(int[] nums) {
		int n = nums.length;
		int[] result = new int[n];
		int left = 0;
		int right = n - 1;
		int index = n - 1;

		while (left <= right) {
			int leftSq = nums[left] * nums[left];
			int rightSq = nums[right] * nums[right];
			if (leftSq > rightSq) {
				result[index--] = leftSq;
				left++;
			} else {
				result[index--] = rightSq;
				right--;
			}
		}
		return result;
	}

	public static int[] sortedSquaresMyApproch(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			int num = Math.abs(nums[i]);
			nums[i] = num * num;
		}
		Arrays.sort(nums);
		return nums;
	}

}
