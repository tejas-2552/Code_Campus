package com.dsa.problems;

import java.util.Arrays;
import java.util.HashMap;

public class Problems1 {

	public static void main(String args[]) {

		int arr[] = { 1, 4, 5, 7, 8 };
		System.out.println(Arrays.toString(twoSumsOptimized(arr, 5.0)));
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
		// Value Index
		// int arr[] = { 1, 4, 5, 7, 8 };
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			Integer num = map.get(arr[i]);
			if (num != null) {
				return new int[] { i, num };
			}
			map.put(sum - arr[i], i);
		}
		return new int[] { -1, -1 };
	}

	public static int[] twoSumsOptimized(int[] arr, float sum) {
		return new int[] { -1, -1 };
	}
}
