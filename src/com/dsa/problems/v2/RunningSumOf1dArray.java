package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given an array nums. We define a running sum of an array as
 *  runningSum[i] = sum(nums[0]…nums[i]).
 * 
 * Return the running sum of nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [1,3,6,10] Explanation: Running sum is
 * obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4]. Example 2:
 * 
 * Input: nums = [1,1,1,1,1] Output: [1,2,3,4,5] Explanation: Running sum is
 * obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1]. Example 3:
 * 
 * Input: nums = [3,1,2,10,1] Output: [3,4,6,16,17]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 -10^6 <= nums[i] <= 10^6
 */
public class RunningSumOf1dArray {

	public static void main(String args[]) {
		int[] nums = { 3, 1, 2, 10, 1 };
		System.out.println(Arrays.toString(runningSum(nums)));
	}

	public static int[] runningSum(int[] nums) {

		int[] returnArr = new int[nums.length];
		returnArr[0] = nums[0];
		int prvV = nums[0];
		for (int i = 1; i < nums.length; i++) {
			prvV = prvV + nums[i];
			returnArr[i] = prvV;
		}
		return returnArr;
	}
}
