package com.dsa.problems.v2;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/*
 * Given an array nums of size n, return the majority element.
 * 
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You
 * may assume that the majority element always exists in the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,2,3] Output: 3 
 * 
 * Example 2:
 * 
 * Input: nums = [2,2,1,1,1,2,2] Output: 2
 * 
 */
public class MajorityElement {

	public static void main(String args[]) {
		int[] nums = { 2, 2, 1, 1, 1, 3, 3, 2, 2, 1, 1, 3, 5, 5, 5, 8, 3, 10, 11, 3, 3 };
		System.out.println(majorityElementV2(nums));
		majorityElementPractice(nums);
	}

	public static int majorityElement(int[] nums) {

		Map<Integer, Integer> countMap = new TreeMap<>();

		for (int i = 0; i < nums.length; i++) {

			if (countMap.get(nums[i]) != null) {
				countMap.put(nums[i], countMap.get(nums[i]) + 1);
			} else {
				countMap.put(nums[i], 1);
			}
		}

		int[] elementArr = { 0, 0 };
		for (Entry<Integer, Integer> m : countMap.entrySet()) {
			int value = elementArr[1]; // value
			if (m.getValue() > value) {
				elementArr[0] = m.getKey();
				elementArr[1] = m.getValue();
			}
		}

		return elementArr[0];

	}

	public static int majorityElementV2(int[] nums) {

		int count = 0;
		Integer candidate = null;
		for (int num : nums) {

			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;

		}
		return candidate;

	}

	public static void majorityElementPractice(int[] nums) {

		// Input: nums = [2,2,1,1,1,2,2] Output: 2

		int maxElementCnt = 0;
		int maxElement = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (maxElement != nums[i]) {
				maxElementCnt--;
			} else {
				maxElementCnt++;
			}

			if (maxElementCnt == 0) {
				maxElement = nums[i];
			}
		}
		System.out.println(maxElement);

	}
}
