package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: [24,12,8,6] Example 2:
 * 
 * Input: nums = [-1,1,0,-3,3] Output: [0,0,9,0,0]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 -30 <= nums[i] <= 30 The input is generated such that
 * answer[i] is guaranteed to fit in a 32-bit integer.
 * 
 * 
 * Follow up: Can you solve the problem in O(1) extra space complexity? (The
 * output array does not count as extra space for space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

	public static void main(String args[]) {
		int[] returnArr = productExceptSelfBF(new int[] { 1, 2, 3, 4 });
		System.out.println(Arrays.toString(returnArr));
		productExceptSelf(new int[] { 1, 2, 3, 4 });
	}

	public static int[] productExceptSelf(int[] nums) {

		int[] leftOrder = new int[nums.length];
		int[] rigthOrder = new int[nums.length];
		// 1,2, 3 ,4
		// ,1 ,2 ,6
		// 24,12,4,
		int rightProduct = 1;
		rigthOrder[0] = 1;
		for (int i = 0; i < nums.length - 1; i++) {
			rightProduct = rightProduct * nums[i];
			rigthOrder[i + 1] = rightProduct;
		}

		int leftProduct = 1;
		leftOrder[nums.length - 1] = 1;
		for (int i = nums.length - 1; i > 0; i--) {
			leftProduct = leftProduct * nums[i];
			leftOrder[i - 1] = leftProduct;
		}

		int i = 0;
		while (i < nums.length) {
			nums[i] = leftOrder[i] * rigthOrder[i];
			i++;
		}

		System.out.println(Arrays.toString(nums));
		return nums;
	}

	public static int[] productExceptSelfBF(int[] nums) {
		// Input: nums = [1,2,3,4] Output: [24,12,8,6]
		int[] returnArr = new int[nums.length];
		int totalProduct = 1;
		for (int i = 0; i < nums.length; i++) {
			totalProduct = totalProduct * nums[i];
		}
		for (int j = 0; j < nums.length; j++) {
			nums[j] = totalProduct == 0 ? 1 : totalProduct / nums[j];
		}
		return nums;
	}

}
