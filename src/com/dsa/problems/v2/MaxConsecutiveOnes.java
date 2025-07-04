package com.dsa.problems.v2;

/*
 * Given a binary array nums, return the maximum number of consecutive 1's in
 * the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,0,1,1,1] Output: 3 
 * Explanation: The first two digits or the last three digits are consecutive 1s. 
 * The maximum number of consecutive 1s is 3. 
 * 
 * 
 * Example 2:
 * Input: nums = [1,0,1,1,0,1] Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 nums[i] is either 0 or 1.
 */

public class MaxConsecutiveOnes {

	public static int findMaxConsecutiveOnes(int[] nums) {

		int max = 0;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 1) {
				cnt = 0;
			} else {
				cnt++;
			}
			if (cnt > max) {
				max = cnt;
			}
		}
		return max;
	}

	public static void main(String args[]) {
		System.out.println(findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
	}
}
