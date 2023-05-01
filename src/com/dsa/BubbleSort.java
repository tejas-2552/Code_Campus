package com.dsa;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args)
	{
		int arr[] = {1,2,3,8,4,5,6,7};
		bubbleSortV2(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSorting(int[] arr)
	{
		boolean swapped;
		for(int i = 0;i<arr.length;i++)
		{
			swapped = true;
			for (int j=1; j<arr.length - i;j++)
			{
				// 4,3,5,6,2
				if(arr[j]<arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
					swapped = true;
				}
			}
			if(!swapped)
			{
				break;
			}
		}
	}
	
	public static void bubbleSortV2(int[] arr)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j = 1;j<arr.length- i;j++)
			{
				if(arr[j] < arr[j-1])
				{
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1]=temp;
				}
			}
		}
	}
}
