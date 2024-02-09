package com.dsa;

import java.util.Arrays;

public class TwoDArraySearch {

	public static void main(String[] args) {
		int[][] arr = { 
						{ 1, 32, 434, 434 }, 
						{ 45, 76, 868, 6567, 734 }, 
						{ 972, 23, 4 }, 
						{ 468, 353, 14, 6 } 
					  };
		int targetInt = 23;
		
		for(int i = 0;i<arr.length;i++) {
			for(int j = 0;j<arr[i].length;j++)
			{
				System.out.print(arr[i][j] + " , ");
			}
			System.out.println(arr[i].length);
		}
		
		
		System.out.println("Serach - target at index : " + Arrays.toString(serachIn2dArray(arr, targetInt)));
		System.out.println("Serach max num in 2d array : " + maxIn2dArray(arr));
	}
	
	
	public static int[] serachIn2dArray(int[][] arr, int targetInt)
	{
		for(int i=0;i<arr.length;i++)
		{
			for(int j = 0 ;j<arr[i].length;j++)
			{
				if(arr[i][j] == targetInt)
				{
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	
	public static int maxIn2dArray(int[][] arr)
	{
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++)
		{
			for(int j = 0 ;j<arr[i].length;j++)
			{
				if(arr[i][j] > max)
				{
					max = arr[i][j];
				}
			}
		}
		return max;
	}
}
