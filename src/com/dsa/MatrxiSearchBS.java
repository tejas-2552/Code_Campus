package com.dsa;

import java.util.Arrays;

public class MatrxiSearchBS {

	public static void main(String[] args) {
		int[][] arr = { { 1, 12, 42 }, { 235, 4, 44 }, { 41, 53, 66 } };
		int[][] sortedArr = {
				{10,20,30,40},
				{15,25,35,45},
				{18,28,38,48},
				{19,29,39,50},
		};
		System.out.println(largestNum(arr));
		System.out.println(Arrays.toString(search(sortedArr,29)));
	}

	// Linear search for max num
	public static int largestNum(int[][] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				max = Math.max(arr[i][j], max);
			}
		}
		return max;
	}
	
	public static int[] search(int[][] matrix,int targetInt)
	{
		int r=0;
		int c= matrix.length - 1;
		while(r < matrix.length && c >= 0)
		{
			if(matrix[r][c] == targetInt)
			{
				return new int[] {r,c};
			}
			if(matrix[r][c] < targetInt)
			{
				r++;
			}else 
			{
				c--;	
			}
		}
		return new int[]{-1,-1};
	}
}
