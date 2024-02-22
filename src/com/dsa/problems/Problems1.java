package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;

/*
 *  1. Two Sums 
 *  2. Length of longest subString without repeating characters 
 *  3. Maximum sum of contiguous subArray
 *  4. Print Max Element array within Sub array
 */
public class Problems1 {

	public static void main(String args[]) {

		int arr[] = { 44, 77, 33, 44, 88, 11 };
		System.out.println(Arrays.toString(twoSumsOptimized(arr, 110)));

		System.out.println(lengthOfLongestSubstring("aepwwkew"));

		System.out.println(maxSumOfContSubArray(arr));

		printMaxElementInSlidWindow(arr);

		threeSum(arr, 121);
		System.out.println();
		int arr1[] = { 0, 1, 2, 3, 4, 6 };
		System.out.println(Arrays.toString(findProductOptimized(arr1)));

		System.out.println(reverseAInteger(4321));

		System.out.println(findMissingNo(arr1));

		System.out.println(removeDuplicateChar("aeppkw"));

		System.out.println(reverseWordAccordingInString("Hello World Java Community"));

		System.out.println(firstNonRepatatingCharacter("aabbcqcf"));

		System.out.println(longestPalindormeSubString("aaaaaa"));
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
		int maxLen = 0;
		int start = 0;
		for (int end = 0; end < str.length(); end++) {
			Character ch = str.charAt(end);
			if (map.containsKey(ch)) {
				start = Math.max(start, map.get(ch));
			}
			map.put(ch, end);
			maxLen = Math.max(start, end - start + 1);
		}
		return maxLen;
	}

	// Maximum sum of contiguous subArray
	public static int maxSumOfContSubArray(int[] arr) {
		// k = 3;
		// 1,2,3,4,5,6,7,8
		int k = 3;
		int maxSum = 0;
		int windowSum = 0;
		int start = 0;
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
		// 2,4,5,7,8
		int k = 3;
		int[] maxEle = new int[arr.length - (k - 1)];
		for (int i = 0; i < arr.length - (k - 1); i++) {
			int maxNum = 0;
			for (int j = i; j < i + k && j < arr.length; j++) {
				maxNum = Math.max(maxNum, arr[j]);
			}
			maxEle[i] = maxNum;
		}
		System.out.println(Arrays.toString(maxEle));

	}

	public static void threeSum(int arr[], int target) {

		Arrays.sort(arr);
		// 2,3,5,6,8,9,6, target =10
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
		// 0,1,2
		// 1,2,3
		// 6,3,2
		return null;
	}

	public static String longestPalindormeSubString(String s) {
		// aaaaaa
		int start = 0, end = 0;
		for (int i = 0; i < s.length(); i++) {
			int len1 = findlength(s, i, i);
			int len2 = findlength(s, i, i + 1);
			int len = Math.max(len1, len2);

			if (len > end - start) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}

		return s.substring(start, end + 1);
	}

	public static int findlength(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return right - left - 1;
	}

	public static boolean isPalindrome(String str) {
		int i = 0;
		int j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
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

	public static String removeDuplicateChar(String str) {

		String distinctStr = "";
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (!charSet.contains(ch)) {
				distinctStr = distinctStr + ch;
			}
			charSet.add(ch);
		}
		return distinctStr;
	}

	public static String reverseWordAccordingInString(String str) {

		String strArr[] = str.split(" ");
		String revStr = "";
		for (int i = strArr.length - 1; i >= 0; i--) {
			revStr = revStr + strArr[i] + " ";
		}
		return revStr;
	}

	public static String firstNonRepatatingCharacter(String str) {
		int len = str.length();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < len; i++) {
			Character ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		for (Entry<Character, Integer> ch : map.entrySet()) {
			if (ch.getValue() == 1) {
				return ch.getKey() + "";
			}
		}
		return null;
	}
}
