package com.dsa;

// What is bitonic array or mountain array
// Where the array element first increaces and then decreses 
public class MountainArrayBs {

	public static void main(String[] main) {
		int[] arr = { 1, 42, 43, 53, 63, 72, 88, 99, 200, 241, 312, 514, 200, 198, 42, 6 };
		int[] pivotArr = { 1, 42, 43, 53, 63, 72, 88, 99, 200, 241, 312, 0, 2, 19, 47, 66 };
		System.out.println(arr.length);
		System.out.println("atIndex : " + returnPeakIndex(arr));
		System.out.println("Number at Index : " + searchInMoutainArray(arr, 42));
	}

	public static int returnPeakIndex(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > arr[mid + 1]) {
				// Element lies in the desc order
				end = mid;
			} else {
				start = mid + 1;

			}
		}
		return start;
	}

	// Search in mountain array
	public static int searchInMoutainArray(int[] arr, int targetInt) {
		int peak = returnPeakIndex(arr);
		int ans = orderAgnosticBS(arr, targetInt, 0, peak);
		if (ans == -1) {
			ans = orderAgnosticBS(arr, targetInt, peak, arr.length - 1);
		}
		return ans;
	}

	public static int orderAgnosticBS(int[] arr, int targetInt, int start, int end) {
		// Find weather the array is ascending or descending then perform BS
		boolean isAsec = arr[start] < arr[end];

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == targetInt) {
				return mid;
			}
			if (isAsec) {
				if (arr[mid] > targetInt) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else {
				if (arr[mid] < targetInt) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
		}
		return -1;

	}

	public static int pivotSearch(int[] arr) {
		int start = 0;
		int end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (mid < end && arr[mid] > arr[mid + 1]) {
				return mid;

			}
			if (arr[mid] < arr[mid - 1]) {
				return mid - 1;

			}

			if (arr[mid] <= arr[start]) {
				end = mid - 1;

			} else {
				start = mid + 1;

			}
		}
		return -1;
	}
}
