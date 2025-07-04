package com.dsa.problems.v2;

/*
 * Given an array of integers arr, return true if and only if it is a valid
 * mountain array.
 * 
 * Recall that arr is a mountain array if and only if:
 * 
 * arr.length >= 3 There exists some i with 0 < i < arr.length - 1 such that:
 * arr[0] < arr[1] < ... < arr[i - 1] < arr[i] arr[i] > arr[i + 1] > ... >
 * arr[arr.length - 1]
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [2,1] Output: false Example 2:
 * 
 * Input: arr = [3,5,5] Output: false Example 3:
 * 
 * Input: arr = [0,3,2,1] Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 104 0 <= arr[i] <= 104
 */
public class ValidMountainArray {

	public static void main(String arags[]) {

		int[] arr = { 4, 3, 2, 1 };
		System.out.println(validMountainArray(arr));
	}

	public static boolean validMountainArray(int[] arr) {
		if (arr.length < 3) {
			return false;
		}
		int i = arr[arr.length - 1];
		boolean rev = false;
		for (int j = arr.length - 2; j >= 0; j--) {
			if (i < arr[j]) {
				i = arr[j];
			} else if(i > arr[j]){
				rev = true;
			}
		}
		return false;
	}

}
