package com.dsa;

public class Recursion {

	public static void main(String[] args)
	{
		//System.out.println(fibo(14));
		int[] arr = {2,5,6,8,9,34,63,73,85,89};
		System.out.println(recursiveBinarySearch(arr,83,0,arr.length-1));
	}
	
	
	static void print(int n)
	{
		System.out.println(n);
		if(n==5)
		{
			return;
		}
		print(n+1);
	}
	
	public static int fibo(int n)
	{
		System.out.println(n);
		if(n<2)
		{
			return n;
		}
		return fibo(n-1) + fibo(n-2);
	}
	
	public static int recursiveBinarySearch(int[] arr,int target,int start, int end)
	{
		if(start > end)
		{
			// Start extends if object not found in the array
			return -1;
		}
		
		// Finding middle of the array 
		// mid = 2 + (4 - 2)/2 -> 2 + 0 -> 2
		int mid = start +(end-start)/2;
		if(arr[mid] == target)
		{
			return mid;
		}
		
		if(target < arr[mid])
		{
			return recursiveBinarySearch(arr,target,start,mid -1);
		}
		return recursiveBinarySearch(arr,target,mid+1,end);
		
	}
}
