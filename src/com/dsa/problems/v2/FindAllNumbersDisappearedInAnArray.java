package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in
 * nums.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,3,2,7,8,2,3,1] Output: [5,6] Example 2:
 * 
 * Input: nums = [1,1] Output: [2]
 */
public class FindAllNumbersDisappearedInAnArray {

	public static void main(String args[]) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }).toString());
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1; // convert value to index
			if (nums[index] > 0) {
				nums[index] = -nums[index]; // mark as seen
				System.out.println(Arrays.toString(nums));
			}
		}

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1); // index + 1 is missing
			}
		}
		return result;
	}

	public static List<Integer> findDisappearedNumbersBF(int[] nums) {
		Arrays.sort(nums);
		int start = nums[0];
		int i = 0;
		List<Integer> returnInt = new ArrayList<>();
		// Input: nums = [4,3,2,7,8,2,3,1] 
		// Output: [5,6] 
		// 1,2,2,3,3,4,7,8
		while (i < nums.length) {
			if (nums[i] < start) {
				start--;
			} else if (nums[i] != start) {
				returnInt.add(start);
			}
			start++;
			i++;
		}
		return returnInt;
	}

}
