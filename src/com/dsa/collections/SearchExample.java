package com.dsa.collections;

public class SearchExample {

	public static void main(String[] s) {

		int[] arr = { 1, 2, 4, 7, 8, 9, 23, 44 };

		// Binary Search for sorted array
		System.out.println(performBinarySearch(arr, 1));

		// Binary Search for unsorted array
		System.out.println(performBinarySearchForNonSortedArray(arr, 4));

		// Linear Search
		System.out.println(performLinearSearch(arr, 45));

		// Search Insert
		System.out.println(searchInsert(arr, 4));
		
		// binary Search
		binarySearch(arr, 44);
	}

	public static int performBinarySearch(int[] arr, int num) {
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			int mid = (i + j) / 2;
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				i = mid + 1;
			} else {
				j = mid - 1;
			}
		}
		return -1;
	}

	public static int performBinarySearchForNonSortedArray(int[] arr, int num) {
		// Will Return index of the position if found
		// if not will return -1
		int i = 0;
		int j = arr.length - 1;
		while (i <= j) {
			if (arr[i] == num)
				return i;
			else if (arr[j] == num)
				return j;

			i++;
			j--;
		}
		return -1;
	}

	public static int performLinearSearch(int[] arr, int num) {

		int i = 0;
		int n = arr.length;
		while (i < n) {
			if (arr[i] == num)
				return i;
			i++;
		}
		return -1;
	}

	public static int searchInsert(int[] arr, int target) {
		int low = 0;
		int high = arr.length - 1;
		int mid;
		while (low <= high) {
			mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			if (target > arr[mid]) {
				low = low + 1;
			} else {
				high = mid - 1;
			}
		}
		return low;
	}

	// Practice
	// For sorted array
	private static void binarySearch(int[] arr, int target) {

		int i = 0;
		int j = arr.length - 1;

		while (i <= j) {
			int mid = j - i / 2;
			if (target == arr[mid]) {
				System.out.println("Target found at location : " + mid);
				break;
			}
			if (target < arr[mid]) {
				j = mid - 1;
			} else {
				i = mid + 1;
			}
		}
		System.out.println(0);
	}
}
