package com.dsa.problems.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
	 * Given two integer arrays nums1 and nums2, return an array of their
	 * intersection. Each element in the result must be unique and you may return
	 * the result in any order.
	 * 
	 * 
	 * 
	 * Example 1:
	 * 
	 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
	 * 
	 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Explanation: [4,9]
	 * is also accepted.
	 */
public class IntersectionOfTwoArrays {
	public static void main(String arsg[]) {

		System.out.println(Arrays.toString(intersection(new int[] { 9, 4, 9, 8, 4 }, new int[] { 4, 9, 5 })));

	}

	public static int[] intersection(int[] nums1, int[] nums2) {

		Set<Integer> set = new HashSet<>();
		int n1 = nums1.length;
		int n2 = nums2.length;
		int p = 0;
		Set<Integer> returnList = new HashSet<>();
		if (n1 < n2) {
			while (p < n1) {
				set.add(nums1[p]);
				p++;
			}
			int i = 0;
			while (i < n2) {
				if (set.contains(nums2[i])) {
					returnList.add(nums2[i]);
				}
				i++;
			}

		} else {
			while (p < n2) {
				set.add(nums2[p]);
				p++;
			}
			int i = 0;
			while (i < n2) {
				if (set.contains(nums1[i])) {
					returnList.add(nums1[i]);
				}
				i++;
			}

		}

		int[] returnArray = new int[returnList.size()];
		int i = 0;
		for (Integer n : returnList) {
			returnArray[i] = n;
			i++;
		}
		return returnArray;
	}

}
