package com.dsa;

import java.util.Arrays;

public class SelectionSort {
	
	public static void main(String[] args)
	{
		int[] arr = {5,4,1,2,3,88};
		selectionSortV2(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void selectionSorting(int[] arr)
	{
		for(int i = 0;i<arr.length;i++)
		{
			int last = arr.length - i -1;
			int maxIndex = getMaxIndex(arr, 0, last);
			swap(arr,maxIndex,last);
		}
	}
	
	public static void swap(int[] arr,int first,int last)
	{
		int temp = arr[first];
		arr[first] = arr[last];
		arr[last] = temp;
	}

	public static int getMaxIndex(int[] arr,int start,int end) {
		
		int max = start;
		for(int i = start; i <= end ;i++)
		{
			if(arr[max] < arr[i])
			{
				max = i;
			}
		}
		return max;
	}
	
	public static void selectionSortV2(int[] arr)
	{
		// Find largest index element 
		// Swap that the index with current index
		for(int i = 0;i<arr.length;i++)
		{
			int last = arr.length - i - 1;
			int max = 0;
			for(int j=0;j<=last;j++)
			{
				if(arr[max] < arr[j])
				{
					max = j;
					
				}
				
			}
			System.out.println(max +" "+arr[max]);
			int temp = arr[max];
			arr[max] = arr[last];
			arr[last] = temp;
			max = 0;
			
		}
	}
}
