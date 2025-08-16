package com.dsa.problems.v2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Given an integer array nums and an integer k, return the number of non-empty
 * subarrays that have a sum divisible by k.
 * 
 * A subarray is a contiguous part of an array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,0,-2,-3,1], k = 5 Output: 7 Explanation: There are 7
 * subarrays with a sum divisible by k = 5: [4, 5, 0, -2, -3, 1], [5], [5, 0],
 * [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3] Example 2:
 * 
 * Input: nums = [5], k = 9 Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 3 * 104 -104 <= nums[i] <= 104 2 <= k <= 104
 */
public class SubarraySumDivisibleByK {

	public static void main(String arsg[]) {
		int nums[] = new int[] { 4, 5, 0, -2, -3, 1 };
		int k = 7;
		System.out.println(subarraysDivByK(nums, k));
		subarrayDivisibleByKBF(nums,k);
	}

	public static int subarraysDivByK(int[] nums, int K) {
		Map<Integer, Integer> remainderCount = new HashMap<>();
		remainderCount.put(0, 1); // Base case for subarrays directly divisible by K

		int sum = 0, count = 0;
		int cnt = 0;
		for (int num : nums) {
			sum += num;
			System.out.println("Sum : " + sum);
			// Compute remainder of the current cumulative sum
			int remainder = sum % K;
			System.out.println("Remainder : " + remainder);

			// Handle negative remainders by converting them into a positive range [0,K-1]
			if (remainder < 0)
				remainder += K;

			// If we have seen this remainder before, then there exist
			// 'remainderCount.get(remainder)' subarrays ending at current index
			if (remainderCount.containsKey(remainder)) {
				System.out.println("Remainder Exists " + remainder + " : " + remainderCount.get(remainder));
				count += remainderCount.get(remainder);
			}

			// Update the remainder count in the map
			remainderCount.put(remainder, remainderCount.getOrDefault(remainder, 0) + 1);
		}
		System.out.println("Counter : " + count);
		System.out.println("Map : " + remainderCount.toString());
		return count;
	}

	public static int subarraysDivByKBF(int[] nums, int k) {

		int[] prefixSumArr = new int[nums.length];
		int sum = 0;
		int cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			prefixSumArr[i] = sum;
			if (sum % k == 0) {
				cnt++;
			}
		}

		for (int i = 0; i < prefixSumArr.length; i++) {
			int prev = prefixSumArr[i];
			System.out.println(Arrays.toString(prefixSumArr));

			for (int j = i + 1; j < prefixSumArr.length; j++) {
				System.out.println(prev + " - " + prefixSumArr[j] + " % " + k + " = " + (prev - prefixSumArr[j] % 5));
				if (prev - prefixSumArr[j] % 5 == 0 || prev - prefixSumArr[j] % 5 == 5) {
					cnt++;
				}
			}
			System.out.println();
		}
		return cnt;
	}

	public static void subarrayDivisibleByKBF(int nums[], int k) {

		// * Input: nums = [4,5,0,-2,-3,1], k = 5 Output: 7
		int count = 0;
		int prefixSum = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		for (int i = 0; i < nums.length; i++) {
			prefixSum += nums[i];
			if (map.containsKey(prefixSum % k)) {
				count += map.get(prefixSum % k);
			}
			map.put(prefixSum % k, map.getOrDefault(prefixSum % k, 0) + 1);
		}
		System.out.println(count);
	}
}
