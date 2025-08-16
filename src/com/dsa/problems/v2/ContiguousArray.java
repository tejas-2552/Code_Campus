package com.dsa.problems.v2;

import java.util.HashMap;

/*
 * Given a binary array nums, return the maximum length of a contiguous subarray
 * with an equal number of 0 and 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1] Output: 2 Explanation: [0, 1] is the longest contiguous
 * subarray with an equal number of 0 and 1. Example 2:
 * 
 * Input: nums = [0,1,0] Output: 2 Explanation: [0, 1] (or [1, 0]) is a longest
 * contiguous subarray with equal number of 0 and 1. Example 3:
 * 
 * Input: nums = [0,1,1,1,1,1,0,0,0] Output: 6 Explanation: [1,1,1,0,0,0] is the
 * longest contiguous subarray with equal number of 0 and 1.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1.
 */

public class ContiguousArray {

	public static void main(String args[]) {

		int[] nums = new int[] { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
		System.out.println(findMaxLength(nums));
	}

	public static int findMaxLength(int[] nums) {
		HashMap<Integer, Integer> sumIndexMap = new HashMap<>();
		sumIndexMap.put(0, -1); // base case to handle entire array sum
		int maxLength = 0;
		int runningSum = 0;

		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i] == 0 ? -1 : 1;
			System.out.println("num : " + nums[i]);
			System.out.println("sum : " + runningSum);
			
			// Check if the running sum has been seen before
			if (sumIndexMap.containsKey(runningSum)) {
				int prevIndex = sumIndexMap.get(runningSum);
				maxLength = Math.max(maxLength, i - prevIndex);
			} else {
				// Store the first occurrence of this running sum
				sumIndexMap.put(runningSum, i);
			}
		}
		System.out.println(sumIndexMap.toString());
		return maxLength;
	}
}
