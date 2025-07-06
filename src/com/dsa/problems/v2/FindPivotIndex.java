package com.dsa.problems.v2;

import java.util.stream.Stream;

/*
 * Given an array of integers nums, calculate the pivot index of this array.
 * 
 * The pivot index is the index where the sum of all the numbers strictly to the
 * left of the index is equal to the sum of all the numbers strictly to the
 * index's right.
 * 
 * If the index is on the left edge of the array, then the left sum is 0 because
 * there are no elements to the left. This also applies to the right edge of the
 * array.
 * 
 * Return the leftmost pivot index. If no such index exists, return -1.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,7,3,6,5,6] Output: 3 
 * Explanation: The pivot index is 3. 
 * Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 
 * Right sum = nums[4] + nums[5] = 5 + 6 = 11
 * 
 *  
 * Example 2:
 * 
 * Input: nums = [1,2,3] Output: -1 Explanation: There is no index that
 * satisfies the conditions in the problem statement. Example 3:
 * 
 * Input: nums = [2,1,-1] Output: 0 
 * Explanation: The pivot index is 0. Left sum
 * = 0 (no elements to the left of index 0) Right sum = nums[1] + nums[2] = 1 +
 * -1 = 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 104 -1000 <= nums[i] <= 1000
 */
public class FindPivotIndex {

	public static void main(String args[]) {

		int[] nums = { 1, 7, 3, 6, 5, 6 };
		System.out.println(pivotIndex(nums));
		printPivot(nums);
	}

	public static int pivotIndex(int[] nums) {
		int totalSum = 0;
		for (int num : nums) {
			totalSum += num;
		}

		int leftSum = 0;
		System.out.println("Total Sum :: " + totalSum);
		for (int i = 0; i < nums.length; i++) {
			int rightSum = totalSum - leftSum - nums[i];
			System.out.println("Right Sum :: " + rightSum);
			if (leftSum == rightSum) {
				return i;
			}
			leftSum = leftSum + nums[i];
			System.out.println("Left Sum :: " + leftSum);
			System.out.println();
		}
		return -1;
	}

	public static void printPivot(int nums[]) {
		int totalSum = 0;
		for (int i : nums) {
			totalSum += i;
		}

		int leftSum = 0;
		boolean pFlag = false;
		int pivotIndx = 0;

		for (int j = 0; j < nums.length; j++) {
			int rightSum = totalSum - leftSum - nums[j];
			if (rightSum == leftSum) {
				pFlag = true;
				pivotIndx = j;
				break;
			}
			leftSum += nums[j];
		}

		if (pFlag) {
			System.out.println("pivot index is : " + pivotIndx);
		} else {
			System.out.println("no flag found");

		}
	}

}
