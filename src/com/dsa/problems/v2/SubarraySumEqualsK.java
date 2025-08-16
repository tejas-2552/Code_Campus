package com.dsa.problems.v2;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1], k = 2 Output: 2 Example 2:
 * 
 * Input: nums = [1,2,3], k = 3 Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 2 * 104 -1000 <= nums[i] <= 1000 -107 <= k <= 107
 */
public class SubarraySumEqualsK {

	public static void main(String arsg[]) {
		int[] nums = new int[] { 1, 1, 1 };
		int k = 2;
		System.out.println(subarraySum(nums, k));
		subarraySumBF(nums,k);
	}

	public static int subarraySum(int[] nums, int k) {
		int prefixSum = 0;
		int cnt = 0;
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i : nums) {
			prefixSum += i;
			System.out.println("num : " + i);
			System.out.println("prefix : " + prefixSum);
			System.out.println("cal : " + (prefixSum - k));
			System.out.println();
			cnt += map.getOrDefault(prefixSum - k, 0);
			map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
		}
		System.out.println(map.toString());
		return cnt;
	}

	public static void subarraySumBF(int[] nums, int k) {
		// Input: nums = [1,1,1], k = 2
		// output : 2
		int prefixSum = 0;
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (map.containsKey(prefixSum - k)) {
				count += map.get(prefixSum - k);
			}
			map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
		}
		System.out.println(count);
	}

}
