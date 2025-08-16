package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4,5,6,7], k = 3 
 * Output: [5,6,7,1,2,3,4] 
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6] 
 * rotate 2 steps to the right: [6,7,1,2,3,4,5] 
 * rotate 3 steps to the right: [5,6,7,1,2,3,4] 
 * 
 * Example 2: Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100] 
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3] 
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -231 <= nums[i] <= 231 - 1 0 <= k <= 105
 * 
 * 
 * Follow up:
 * 
 * Try to come up with as many solutions as you can. There are at least three
 * different ways to solve this problem. Could you do it in-place with O(1)
 * extra space?
 */
public class RotateArray {

	public static void main(String args[]) {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		rotate(nums, 3);
	}

	public static void rotate(int[] nums, int k) {
		int n = nums.length;
		k = k % n; // Handle cases where k >= n

		// Step 1: Reverse the whole array
		reverse(nums, 0, n - 1);
		System.out.println(Arrays.toString(nums));
		// Step 2: Reverse the first k elements
		reverse(nums, 0, k - 1);
		System.out.println(Arrays.toString(nums));

		// Step 3: Reverse the remaining elements
		reverse(nums, k, n - 1);
		System.out.println(Arrays.toString(nums));

	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void rotateBFV2(int[] nums, int k) {
		int n = nums.length;
		int[] rotated = new int[n];
		k = k % n;
		for (int i = 0; i < n; i++) {
			rotated[(i + k) % n] = nums[i];
			System.out.print((i + k) % n + "  ");
		}
		// Copy the content of rotated array to the original array
		for (int i = 0; i < n; i++) {
			nums[i] = rotated[i];
		}

		System.out.println();
		for (int i = 0; i < 20; i++) {
			System.out.print((i + 10) % 20 + "  ");
		}
		System.out.println();
		System.out.println(11 % 3);
	}

	public static void rotateBF(int[] nums, int k) {

		for (int i = 0; i < k; i++) {
			int lastElement = nums[nums.length - 1];
			for (int j = nums.length - 1; j > 0; j--) {
				nums[j] = nums[j - 1];
			}
			nums[0] = lastElement;
		}
		System.out.println(Arrays.toString(nums));
	}
}
