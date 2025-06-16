package com.dsa.problems.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 2;

		System.out.println(Arrays.toString(twoSumV2(nums, target)));

	}

	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { 0, 0 };
	}

	public static int[] twoSumV2(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int rem = target - nums[i];
			if (map.containsKey(rem)) {
				return new int[] { i, map.get(rem) };
			}
			map.put(nums[i], i);
		}
		return new int[] { 0, 0 };
	}

}
