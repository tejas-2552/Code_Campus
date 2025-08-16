package com.dsa.problems.v2;

import java.util.HashMap;

/*
 * Given an integer array nums and an integer k, return true if nums has a good
 * subarray or false otherwise.
 * 
 * A good subarray is a subarray where:
 * 
 * its length is at least two, and the sum of the elements of the subarray is a
 * multiple of k. Note that:
 * 
 * A subarray is a contiguous part of the array. An integer x is a multiple of k
 * if there exists an integer n such that x = n * k. 0 is always a multiple of
 * k.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [23,2,4,6,7], k = 6 Output: true Explanation: [2, 4] is a
 * continuous subarray of size 2 whose elements sum up to 6. Example 2:
 * 
 * Input: nums = [23,2,6,4,7], k = 6 Output: true Explanation: [23, 2, 6, 4, 7]
 * is an continuous subarray of size 5 whose elements sum up to 42. 42 is a
 * multiple of 6 because 42 = 7 * 6 and 7 is an integer. Example 3:
 * 
 * Input: nums = [23,2,6,4,7], k = 13 Output: false
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 0 <= nums[i] <= 109 0 <= sum(nums[i]) <= 231 - 1 1 <=
 * k <= 231 - 1
 */
public class ContinuousSubarraySum {

	public static void main(String arsg[]) {

		int[] nums = new int[] { 23, 2, 6, 4, 7 };
		int k = 11;
		System.out.println(checkSubarraySum(nums, k));
		checkSubarraySumBF(nums, k);
	}

	public static boolean checkSubarraySum(int[] nums, int k) {

		int runningSum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			runningSum += nums[i];
			if (map.containsKey(runningSum % k)) {
				int idx = map.get(runningSum % k);
				if (i - idx >= 2) {
					return true;
				}
			}
			map.put(runningSum % k, i);
		}
		return false;
	}

	public static void checkSubarraySumBF(int[] nums, int k) {
		boolean flag = false;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum % k == 0 && j - i > 0) {
					System.out.println(" i : " + i);
					System.out.println(" j : " + j);
					flag = true;
					break;
				}
			}
		}
		System.out.println(flag);
	}

}
