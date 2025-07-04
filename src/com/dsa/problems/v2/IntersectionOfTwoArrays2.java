package com.dsa.problems.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * Given two integer arrays nums1 and nums2, return an array of their
 * intersection. Each element in the result must appear as many times as it
 * shows in both arrays and you may return the result in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2,2] Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [4,9] Explanation: [9,4]
 * is also accepted.
 * 
 */

public class IntersectionOfTwoArrays2 {

	public static void main(String arag[]) {

		int[] nums1 = { 4, 9, 5 };
		int[] nums2 = { 9, 4, 9, 8, 4 };
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	public static int[] intersect(int[] nums1, int[] nums2) {

		HashMap<Integer, Integer> map = new HashMap<>();
		List<Integer> returnList = new LinkedList<>();
		if (nums1.length < nums2.length) {
			int i = 0;
			while (i < nums1.length) {
				if (map.containsKey(nums1[i])) {
					Integer count = map.get(nums1[i]) + 1;
					map.put(nums1[i], count);
				} else {
					map.put(nums1[i], 1);
				}
				i++;
			}
			for (int j = 0; j < nums2.length; j++) {
				if (map.containsKey(nums2[j]) && map.get(nums2[j]) > 0) {
					map.put(nums2[j], map.get(nums2[j]) - 1);
					returnList.add(nums2[j]);
				}
			}

		} else {
			int i = 0;
			while (i < nums2.length) {
				if (map.containsKey(nums2[i])) {
					Integer count = map.get(nums2[i]) + 1;
					map.put(nums2[i], count);
				} else {
					map.put(nums2[i], 1);
				}
				i++;
			}
			for (int j = 0; j < nums1.length; j++) {
				if (map.containsKey(nums1[j]) && map.get(nums1[j]) > 0) {
					map.put(nums1[j], map.get(nums1[j]) - 1);
					returnList.add(nums1[j]);
				}
			}
		}

		int[] rArr = new int[returnList.size()];
		int c = 0;
		for (Integer i : returnList) {
			rArr[c] = i;
			c++;
		}
		return rArr;
	}

}
