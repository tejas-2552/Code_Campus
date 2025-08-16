package com.dsa.problems.v2;

import java.util.Arrays;

/*
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing
 * order, and two integers m and n, representing the number of elements in nums1
 * and nums2 respectively.
 * 
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 * 
 * The final sorted array should not be returned by the function, but instead be
 * stored inside the array nums1. To accommodate this, nums1 has a length of m +
 * n, where the first m elements denote the elements that should be merged, and
 * the last n elements are set to 0 and should be ignored. nums2 has a length of
 * n.
 * 
 * 
 * 
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 
 * Output:
 * [1,2,2,3,5,6] Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming
 * from nums1. 
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0 
 * Output: [1] 
 * Explanation: The
 * arrays we are merging are [1] and []. The result of the merge is [1]. 
 * 
 * Example 3:
 * 
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1 Output: [1] Explanation: The
 * arrays we are merging are [] and [1]. The result of the merge is [1]. Note
 * that because m = 0, there are no elements in nums1. The 0 is only there to
 * ensure the merge result can fit in nums1.
 * 
 */
public class MergeSortedArray {

	public static void main(String arsg[]) {
		merge(new int[] { 1, 2, 3, 0, 0, 0, 0 }, 3, new int[] { 2, 5, 6, 7 }, 4);
		
		mergeSortedArray(new int[] { 1, 2, 3, 0, 0, 0, 0 }, 3, new int[] { 2, 5, 6, 7 }, 4);
	}

	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		/*
		 * traverse from backwards
		 */

		int p = m + n - 1;
		int p1 = m - 1;
		int p2 = n - 1;

		while (p1 >= 0 && p2 >= 0) {
			if (nums1[p1] > nums2[p2]) {
				nums1[p] = nums1[p1];
				p1--;
			} else {
				nums1[p] = nums2[p2];
				p2--;
			}
			p--;
		}

		while (p1 >= 0) {
			nums1[p] = nums1[p1];
			p1--;
			p--;

		}
		while (p2 >= 0) {
			nums1[p] = nums2[p2];
			p2--;
			p--;

		}

		System.out.println(Arrays.toString(nums1));

	}

	public static void mergeBF(int[] nums1, int m, int[] nums2, int n) {

		int n1Start = 0;
		int n2Start = 0;
		m = nums1.length;

		while (n1Start < m || n < n2Start) {
			if (nums1[n1Start] == 0) {
				nums1[n1Start] = nums2[n2Start];
				n2Start++;
			}
			n1Start++;
		}

		Arrays.sort(nums1);
		System.out.println(Arrays.toString(nums1));
	}

	public static void mergeSortedArray(int[] nums1, int m, int[] nums2, int n) {

		/*
		 * * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3 Output:
		 * [1,2,2,3,5,6]
		 */

		m = m - 1;
		n = n - 1;
		int pointer = nums1.length - 1;
		while (m >= 0 && n >= 0) {
			if (nums1[m] > nums2[n]) {
				nums1[pointer] = nums1[m];
				m--;
			} else {
				nums1[pointer] = nums2[n];
				n--;
			}
			pointer--;
		}
		System.out.println(Arrays.toString(nums1));
	}
}
