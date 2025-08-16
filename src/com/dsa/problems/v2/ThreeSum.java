package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [-1,0,1,2,-1,-4] 
 * Output: [[-1,-1,2],[-1,0,1]] 
 * Explanation: nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] =
 * 0 + 1 + (-1) = 0. nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0. The
 * distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the order of the
 * output and the order of the triplets does not matter. Example 2:
 * 
 * Input: nums = [0,1,1] Output: [] Explanation: The only possible triplet does
 * not sum up to 0. Example 3:
 * 
 * Input: nums = [0,0,0] Output: [[0,0,0]] Explanation: The only possible
 * triplet sums up to 0.
 * 
 * 
 * Constraints:
 * 
 * 3 <= nums.length <= 3000 -105 <= nums[i] <= 105
 */
public class ThreeSum {

	public static void main(String args[]) {
		int nums[] = new int[] { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums).toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		// Input: nums = [-1,0,1,2,-1,-4] 
		// Output: [[-1,-1,2],[-1,0,1]]
		// -4,-1,-1,0,1,2
		Arrays.sort(nums);
		Set<List<Integer>> returnArr = new HashSet<>();
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if (sum == 0) {
					List<Integer> list = Arrays.asList(nums[i], nums[start], nums[end]);
					returnArr.add(list);
					start++;
					end--;
				} else if (sum > 0) {
					end--;
				} else {
					start++;
				}
			}
		}
		return new ArrayList<>(returnArr);
	}

	public static void print3Sum(int[] arr) {
		// sum is zero
		// nums = [-1,0,1,2,-1,-4] 
		// sorted nums = -4,-1,-1,0,1,2
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			
			
		}

	}

}
