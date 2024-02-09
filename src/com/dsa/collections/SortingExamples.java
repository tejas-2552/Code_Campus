package com.dsa.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class SortingExamples {

	public static void main(String[] s) {

		int arr[] = { 9, 5, 2, 4, 8, 3, 7, 6, 1 };
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));

		int[] arr1 = { 2, 2, 1, 1, 0, 1, 0, 0, 2 };
		threeNoSort(arr1);
		System.out.println(Arrays.toString(arr1));
	}

	public static int[] performBubbleSorting(int[] arr) {
		int size = arr.length;
		boolean isSwaped = false;
		for (int i = 0; i < size; i++) {
			isSwaped = false;
			for (int j = 0; j < size - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					// perform swap
					performSwap(arr, j);
					isSwaped = true;
				}
			}
			if (isSwaped == false)
				break;
			System.out.println(Arrays.toString(arr));
			System.out.println("---------------------------");
		}
		return arr;
	}

	public static int[] performInsertionSort(int[] arr) {
		// { 9, 5, 2, 4, 8, 3, 7, 6 }
		int size = arr.length;
		for (int i = 1; i < size; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}

		return arr;
	}

	public static int[] performSelectionSort(int[] arr) {
		// { 9, 5, 2, 4, 8, 3, 7, 6 }

		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}

			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}

		return arr;
	}

	// Dutch Flag problem
	public static void threeNoSort(int[] arr) {
		int i = 0;
		int j = 0;
		int k = arr.length - 1;
		while (i <= k) {
			if (arr[i] == 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j++;
			} else if (arr[i] == 1) {
				i++;
			} else if (arr[i] == 2) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				k--;
			}
		}
	}

	private static void performSwap(int[] arr, int j) {
		int temp = arr[j];
		arr[j] = arr[j + 1];
		arr[j + 1] = temp;
	}

	private static void bubbleSort(int[] arr) {
		int n = arr.length;
		boolean isSwapped;
		for (int i = 0; i < n - 1; i++) {
			isSwapped = false;
			for (int j = 0; j < n - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					isSwapped = true;
				}
			}
			if (!isSwapped) {
				break;
			}
		}
	}

	private static void insertionSort(int[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = temp;
		}
	}

	private static void selectionSort(int[] arr) {
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[min];
			arr[min] = arr[i];
			arr[i] = temp;
		}
	}
}
