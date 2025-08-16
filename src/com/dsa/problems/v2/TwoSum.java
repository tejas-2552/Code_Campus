package com.dsa.problems.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] nums = { 1, 4, 8, 10, 38, 45 };
		int target = 18;

		System.out.println(Arrays.toString(twoSumV2(nums, target)));
		System.out.println(Arrays.toString(twoSumTwoPointerApproch(nums, target)));
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

	public static int[] twoSumTwoPointerApproch(int[] nums, int target) {
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target) {
				return new int[] { start, end };
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}

		}
		return new int[] { start, end };
	}

}
