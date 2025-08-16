package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * Given an integer array nums, move all 0's to the end of it while maintaining
 * the relative order of the non-zero elements.
 * 
 * Note that you must do this in-place without making a copy of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0] 
 * 
 * Example 2:
 * 
 * Input: nums = [0] Output: [0]
 * 
 */
public class MoveZeros {

	public static void main(String a[]) {
		int[] nums = { 0, 0, 1, 1, 0, 3, 0, 12, 0, 122 };
		moveZeroes(nums);
		moveZeroesPractice(nums);
	}

	public static void moveZeroes(int[] nums) {
		int insertPosition = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insertPosition] = nums[i];
				insertPosition++;
			}
		}

		while (insertPosition < nums.length) {
			nums[insertPosition] = 0;
			insertPosition++;
		}

		System.out.println(Arrays.toString(nums));
	}

	// This is my brute force apporoch
	public static void moveZeroesBF(int[] nums) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 0) {
				for (int j = i + 1; j < nums.length; j++) {
					nums[j - 1] = nums[j];
					nums[j] = 0;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}

	public static void moveZeroesPractice(int[] nums) {
		// Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]
		int insertPos = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[insertPos] = nums[i];
				insertPos++;
			}
		}
		while (insertPos < nums.length) {
			nums[insertPos] = 0;
		}

		System.out.println(Arrays.toString(nums));
	}
}
