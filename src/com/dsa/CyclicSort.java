package com.dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {
	
	public static void main(String[] args)
	{
		int[] arr = {4,1,2,1,2};
		System.out.println(singleNumber(arr));
	}

	public static void sort(int[] arr)
	{
		int i = 0;
		while(i<arr.length)
		{
			int correct = arr[i]-1;
			if(arr[i] != correct)
			{
				swap(arr,i,correct);
			}
			else
			{
				i++;
			}
		}
	}
	
	public static void swap(int[] arr, int i, int correct)
	{
		int temp = arr[i];
		arr[i] = arr[correct];
		arr[correct] = temp;
	}
	
	public static int missingNum(int[] arr)
	{
		int i = 0;
		
		while(i<arr.length)
		{
			int correct = arr[i];
			if(arr[i]<arr.length && arr[i] != arr[correct])
			{
				swap(arr,i,correct);
			}
			else
			{
				i++;
			}
		}
		int j=0;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j] != j) 
			{
				return j;
			}
		}
		return j;
	}
	
	
	public static List<Integer> findMissingNums(int[] arr)
	{
		int i = 0;
		while(i<arr.length)
		{
			int correct = arr[i] - 1;
			if(arr[i] != arr[correct])
			{
				swap(arr,i,correct);
			}
			else
			{
				i++;
			}
		}
		
		List<Integer> returnInt = new ArrayList<>();
		int j=0;
		for(j=0;j<arr.length;j++)
		{
			if(arr[j] != j+1) 
			{
				returnInt.add(j+1);
			}
		}
		return returnInt;
	}
	
	
	public static int findDuplicates(int[] arr)
	{
		int i= 0;
		while(i<arr.length)
		{
			if(arr[i] != i + 1)
			{
				int correct = arr[i] - 1;
				if(arr[i] != arr[correct])
				{
					swap(arr,i,correct);
					
				}
				else 
				{
					return arr[i];
				}
			}else 
			{
				i++;
			}
			
		}
		return -1;
	}
	
	// https://leetcode.com/problems/single-number/description/
	
	public static int singleNumber(int[] nums) {
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == nums[i + 1]) {
				i++;
			} else {
				return nums[i];
			}
		}
		return nums[nums.length - 1];
	}
	
	
	public static int binarySearch(int arr[],int targetNum,int start , int end)
	{
		
		while(start<=end && start<arr.length)
		{
			int mid = start + (end - start)/2;
			
			if(arr[mid] > targetNum)
			{
				end = mid - 1;
			}else if(arr[mid]<targetNum)
			{
				start = mid + 1;
			}
			else 
			{
				return mid;
			}
		}
		
		return -1;
	}
	
}
