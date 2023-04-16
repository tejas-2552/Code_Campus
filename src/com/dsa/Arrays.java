package com.dsa;

public class Arrays {

	public static void main(String[] args) {
		int[] nums = { 32, 32, 44, 66, 903, 9043, 812 };
		int[] twoSumArray = {3,2,3};
		System.out.println(java.util.Arrays.toString(twoSum(twoSumArray, 6)));
		System.out.println(maxInt(nums));
		System.out.println(maxRange(nums, 2, 5));
		System.out.println(java.util.Arrays.toString(nums));
		//System.out.println(java.util.Arrays.toString(arrayReverse(nums)));
		arrayReverseV1(nums);
		System.out.println(java.util.Arrays.toString(nums));
	}

	// Max int in an array
	public static int maxInt(int[] nums) {
		int maxVal = nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > maxVal) {
				maxVal = nums[i];
			}
		}
		return maxVal;
	}

	// Max int in an array range
	public static int maxRange(int[] nums, int start, int end) {
		int maxVal = nums[start];
		for (int i = start; i <= end; i++) {
			if (maxVal < nums[i]) {
				maxVal = nums[i];
			}
		}
		return maxVal;
	}

	// Reversal of an Array
	public static int[] arrayReverse(int[] nums) {
		int[] reverseArray = new int[nums.length];
		int j = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			reverseArray[j] = nums[i];
			j++;
		}
		return reverseArray;
	}

	// Reversal of an array using two pointer
	public static void arrayReverseV1(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}

	}

	public static void swap(int[] arr, int index1, int index2) {
		int temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}

	 public static int[] twoSum(int[] nums, int target) {
	        int[] returnArray = new int[2];
	        for(int i = 0 ; i < nums.length - 1 ;i++)
	        {
	            for (int j = i+1 ;j < nums.length ; j++)
	            {
	                if(target == nums[i] + nums[j])
	                {
	                    returnArray[0] = i;
	                    returnArray[1] = j;
	                    return returnArray;
	                }
	            }
	            
	        }
	        return null;
	    }
	 
	 
}

