package com.dsa.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 * 	1. Insert element in an array at specific position
 * 	2. Move Negative ele to start of the array
 * 	3. Find Second Highest ele in an array
 * 	4. Find Max and Min diff between elemenets in an array
 * 	5. Binary Search "Only performed on sorted array"
 * 	6. Bubble Sort
 */
public class ArrayProblems {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 6, 8, 9, 4 };

		System.out.println(Arrays.toString(insertEleAtIndex(arr, 11, 6)));

		int[] negArr = { -2, 5, -6, 8, -9, 4 };
		System.out.println(Arrays.toString(moveNegativeEleToStart(negArr)));

		System.out.println(findSecondHighestEle(negArr));

		System.out.println(Arrays.toString(findMaxAndMinDiffBetElements(arr)));

		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 8));

		int[] unSortedArr = { 5, 7, 2, 9, 4 };
		System.out.println(Arrays.toString(bubbleSort(unSortedArr)));

		int[] dupEleCheckArr = { 3, 5, 6, 6, 7, 7, 1, 2, 3 ,1};
		printDuplicateEle(dupEleCheckArr);
	}

	// insert element to an array at specific postition
	public static int[] insertEleAtIndex(int[] arr, int ele, int index) {

		int[] returnArr = new int[arr.length + 1];
		if (index > arr.length) {
			return null;
		}
		int j = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
				returnArr[index] = ele;
				returnArr[index + 1] = arr[i];
				j = j + 2;
			} else {
				returnArr[j] = arr[i];
				j++;
			}
		}
		return returnArr;
	}

	public static int[] moveNegativeEleToStart(int[] arr) {

		int[] returnArr = new int[arr.length];
		int start = 0;
		int end = arr.length - 1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				returnArr[start] = arr[i];
				start++;
			} else {
				returnArr[end] = arr[i];
				end--;
			}
		}
		return returnArr;
	}

	public static int findSecondHighestEle(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length - 2];
	}

	public static int[] findMaxAndMinDiffBetElements(int[] arr) {

		Arrays.sort(arr);
		int ele = arr.length - 1;
		int maxEle = arr[ele];
		int maxDiff = 0;
		int minDiff = arr[ele];
		for (int i = ele - 1; i >= 0; i--) {
			maxDiff = Math.max(maxDiff, maxEle - arr[i]);
			minDiff = Math.min(minDiff, maxEle - arr[i]);
		}
		return new int[] { maxDiff, minDiff };
	}

	public static int binarySearch(int[] arr, int num) {

		int start = 0;
		int end = arr.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = end - start / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return mid;
	}

	public static int[] bubbleSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return arr;
	}

	public static void printDuplicateEle(int[] arr) {
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i])) {
				System.out.print(arr[i] + " ");
			}
			set.add(arr[i]);
		}
	}
}
