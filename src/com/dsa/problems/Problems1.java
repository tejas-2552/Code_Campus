package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problems1 {

	public static void main(String args[]) {

		int arr[] = { 44, 77, 33, 44, 88, 11 };
		System.out.println(Arrays.toString(twoSumsOptimized(arr, 110)));

		System.out.println(lengthOfLongestSubstring("aepwwkew"));

		System.out.println(maxSumOfContSubArrayOptimized(arr));

		printMaxElementInSlidWindow(arr);

		threeSum(arr, 121);
		System.out.println();
		int arr1[] = { 0, 1, 2, 3, 4, 6 };
		System.out.println(Arrays.toString(findProductOptimized(arr1)));

		System.out.println(reverseAInteger(4321));

		System.out.println(findMissingNo(arr1));
	}

	// O(n2)
	public static int[] twoSums(int[] arr, int sum) {

		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] + arr[j] == sum) {
					return new int[] { i, j };
				}
			}
		}
		return new int[] { -1, -1 };
	}

	public static int[] twoSumsOptimized(int[] arr, int sum) {

		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				return new int[] { map.get(arr[i]), i };
			}
			map.put(sum - arr[i], i);
		}
		return new int[] { -1, -1 };
	}

	public static int lengthOfLongestSubstring(String str) {
		// Sliding window problem
		Map<Character, Integer> map = new HashMap<>();
		int start = 0;
		int maxLen = 0;
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (map.containsKey(ch)) {
				start = Math.max(start, map.get(ch) + 1);
			}
			map.put(ch, i);
			maxLen = Math.max(maxLen, i - start + 1);
		}
		return maxLen;
	}

	// Maximum sum of contiguous subArray
	public static int maxSumOfContSubArray(int[] arr) {

		int k = 3;
		int start = 0;
		int maxSum = 0;
		System.out.println(arr.length);
		for (int i = 0; i <= arr.length - k; i++) {
			int sum = 0;
			for (int j = i; j < i + k; j++) {
				// Calculate Sum
				sum = sum + arr[j];
			}
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static int maxSumOfContSubArrayOptimized(int[] arr) {
		// { 2, 27, 3, 5, 8, 1, 22 };

		int maxSum = 0;
		int windowSum = 0;
		int start = 0;
		int k = 3;
		for (int i = 0; i < arr.length; i++) {
			windowSum = windowSum + arr[i];
			if (i >= k - 1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum = windowSum - arr[start];
				start++;
			}
		}
		return maxSum;
	}

	public static void printMaxElementInSlidWindow(int arr[]) {
		int k = 3;
		int[] maxEleArr = new int[arr.length - (k - 1)];
		for (int i = 0; i < arr.length - (k - 1); i++) {
			int maxEle = 0;
			for (int j = 0; j < i + k && j < arr.length; j++) {
				maxEle = Math.max(maxEle, arr[j]);
			}
			maxEleArr[i] = maxEle;
		}
		System.out.println(Arrays.toString(maxEleArr));
	}

	public static void threeSum(int arr[], int target) {

		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int start = i;
			int end = arr.length - 1;
			while (start < end) {
				int sum = arr[i] + arr[start] + arr[end];
				if (sum == target) {
					System.out.print("{ " + arr[i] + "," + arr[start] + "," + arr[end] + " } ");
					start++;
					end--;
				} else if (sum > target) {
					end--;
				} else {
					start++;
				}
			}
		}

	}

	// O(n2)
	public static int[] findProduct(int arr[]) {
		int[] returnArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			int product = 1;
			for (int j = 0; j < arr.length; j++) {
				if (i != j) {
					product = product * arr[j];
				}
			}
			returnArr[i] = product;
		}
		return returnArr;
	}

	public static int[] findProductOptimized(int arr[]) {
		System.out.println(Arrays.toString(arr));
		// Using right and left slide
		int[] resultArr = new int[arr.length];
		int temp = 1;
		for (int i = 0; i < arr.length; i++) {
			resultArr[i] = temp;
			temp = temp * arr[i];
		}
		System.out.println(Arrays.toString(resultArr));
		temp = 1;
		for (int i = arr.length - 1; i >= 0; i--) {
			resultArr[i] = resultArr[i] * temp;
			temp = temp * arr[i];
		}

		return resultArr;
	}

	public static int reverseAInteger(int number) {

		int revNum = 0;
		while (number > 0) {
			int mod = number % 10;
			number = number / 10;
			revNum = (revNum * 10) + mod;
		}
		return revNum;
	}

	// Contigous array
	public static int findMissingNo(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
		}
		int n = arr.length;
		int diffSum = n * (n + 1) / 2;
		int diff = diffSum - sum;
		return diff == 0 ? (arr[n])++ : diff;
	}

}
