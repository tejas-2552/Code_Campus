package com.dsa.problems;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MediumHardProblems3 {

	public static void main(String args[]) {

		// https://www.youtube.com/watch?v=X6DqnrpjEWA&list=PLFdAYMIVJQHO1paovM-tu2vtGzQU72z_U&index=9
		// Minimum Loss Problem

		int minLoss = minimumLossOptimizedSol(new int[] { 20, 15, 8, 9, 12 });
		System.out.println(minLoss);
	}

	// BruteForce Approach
	public static int minimumLossBruteforce(int[] arr) {

		int minLoss = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int val = arr[i] - arr[j];
				minLoss = Integer.min(minLoss, val > 0 ? val : minLoss);
			}
		}

		return minLoss;
	}

	public static int minimumLossOptimizedSol(int[] arr) {

		Map<Integer, Integer> map = new TreeMap<>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], i);
		}

		// 20 , 7, 8, 2 , 5
		// 2 , 7 , 8 , 20
		int minLoss = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = arr.length - 1; i > 0; i--) {

			if (map.get(arr[i]) > map.get(arr[i - 1])) {
				continue;
			}
			minLoss = Math.min(minLoss, arr[i] - arr[i - 1]);
		}
		return minLoss;
	}
}
