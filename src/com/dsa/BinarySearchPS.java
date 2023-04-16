package com.dsa;

// PS : "Problem Solving"
public class BinarySearchPS {

	public static void main(String[] args)
	{
		// Celing of an number in an array
		int arr[] = {12,32,43,53,64,74,75};
		System.out.println("Celing element is : "+ binarySearchForCelingNo(arr,522));
		int ocArr[] = {12,42,42,42,42,42,53,64,74,75};
		System.out.println("Celing element is : "+java.util.Arrays.toString(binarySearchNoOccuranceIndex(ocArr,42)));
	}
	public static int binarySearchForCelingNo(int arr[],int targetNum)
	{
		int start = 0;
		int end = arr.length - 1;
		while(start<=end)
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
				return arr[mid];
			}
		}
		
		return start;
	}
	
	public static int binarySearchForFloorNo(int arr[],int targetNum)
	{
		int start = 0;
		int end = arr.length - 1;
		while(start<=end)
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
				return arr[mid];
			}
		}
		
		return end;
	}
	
	
	public static int[] binarySearchNoOccuranceIndex(int arr[],int targetNum)
	{
		// 12,42,42,42,42,44,55,55,55
		int[] nums = {-1 , -1};
		nums[0] = searchIndex(arr,targetNum,true);
		nums[1] = searchIndex(arr,targetNum,false);
		return nums;
		
	}
	
	public static int searchIndex(int[] arr,int targetNum,boolean firstIndexSearch)
	{
		int ans = -1;
		int start = 0;
		int end = arr.length - 1;
		while(start<=end)
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
				ans = mid;
				if(firstIndexSearch)
				{
					end = mid - 1;
				}else 
				{
					start = mid + 1;
				}
			}
		}
		
		return ans;
	}

}
