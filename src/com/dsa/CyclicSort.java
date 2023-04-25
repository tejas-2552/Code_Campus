package com.dsa;

import java.util.Arrays;

public class CyclicSort {
	
	public static void main(String[] args)
	{
		int[] arr = {4,3,2,1};
		sort(arr);
		System.out.println(Arrays.toString(arr));
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
}
