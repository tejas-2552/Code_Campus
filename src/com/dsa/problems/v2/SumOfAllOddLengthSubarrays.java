package com.dsa.problems.v2;

/*
 * Given an array of positive integers arr, return the sum of all possible
 * odd-length subarrays of arr.
 * 
 * A subarray is a contiguous subsequence of the array.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: arr = [1,4,2,5,3] 
 * Output: 58 
 * Explanation: The odd-length subarrays of arr and 
 * their sums are: [1] = 1 [4] = 4 [2] = 2 [5] = 5 [3] = 3 [1,4,2] = 7
 * [4,2,5] = 11 [2,5,3] = 10 [1,4,2,5,3] = 15 If we add all these together we
 * get 1 + 4 + 2 + 5 + 3 + 7 + 11 + 10 + 15 = 58 Example 2:
 * 
 * Input: arr = [1,2] Output: 3 Explanation: There are only 2 subarrays of odd
 * length, [1] and [2]. Their sum is 3. Example 3:
 * 
 * Input: arr = [10,11,12] Output: 66
 * 
 * 
 * Constraints:
 * 
 * 1 <= arr.length <= 100 1 <= arr[i] <= 1000
 */
public class SumOfAllOddLengthSubarrays {

	public static void main(String arsg[]) {

		int[] arr = { 1, 4, 2, 5, 3, 9 };
		System.out.println(sumOddLengthSubarraysV1(arr));

	}

	// 4 , 5 , 6 , 7 , 6 , 5
	public static int sumOddLengthSubarraysV2(int[] arr) {
		int start = 0;
		int end = arr.length - 1;
		int sum = 0;
		int len = arr.length;
		int cnt = arr.length / 2;
		while (start <= end) {
			if (start == end) {
				sum += arr[start] * cnt;
			} else {
				sum += arr[start] * cnt;
				System.out.println(arr[start] + " * " + cnt + " : " + arr[start] * cnt);
				sum += arr[end] * cnt;
				System.out.println(arr[end] + " * " + cnt + " : " + arr[end] * cnt);
				cnt++;
			}
			start++;
			end--;
		}
		return sum;
	}

	// THis is the optimized sol
	public static int sumOddLengthSubarraysV3(int[] arr) {
		int sum = 0;
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int totalSubarrays = (i + 1) * (n - i); // subarrays that include arr[i]
			int oddCount = (totalSubarrays + 1) / 2; // only odd-length subarrays
			System.out.println(arr[i] + " * " + oddCount + " : " + (arr[i] * oddCount));
			sum += arr[i] * oddCount;
		}

		return sum;
	}

	public static int sumOddLengthSubarraysV1(int[] arr) {
		int totalSum = 0;
		int n = arr.length;
		for (int len = 1; len <= n; len += 2) {
			for (int i = 0; i <= n - len; i++) {
				for (int j = i; j < i + len; j++) {
					System.out.println("val : " + arr[j]);
					totalSum += arr[j];
				}
				System.out.println("current sum : " + totalSum);
				System.out.println();
			}
			System.out.println();

		}

		return totalSum;
	}

	public static int sumOddLengthSubarrays(int[] arr) {
		int len = arr.length;
		// Find the odd numbers
		int odd = 0;
		int sum = 0;
		while (odd % 2 != 0 && odd < len) {
			// Arr box len = odd
			for (int i = 0; i < len; i = i + odd) {
				int j = i;
				while (j <= i) {
					sum = sum + arr[j];
					j++;
				}
			}
			odd++;
		}
		return sum;
	}

}
