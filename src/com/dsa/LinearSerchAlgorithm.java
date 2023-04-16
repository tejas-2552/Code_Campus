package com.dsa;

public class LinearSerchAlgorithm {

	public static void main(String[] args)
	{
		int[] nums = {12,43,4,15,2,52};
		int targetInt = 12;
		System.out.println("Target Int fount at index : "+numSearch(nums,targetInt));
		System.out.println("Target Int is present at index : "+searchNumInRange(nums,targetInt,1,4));
		System.out.println("Maximum num in array list : "+ searchMaxNum(nums));
		String str = "String";
		char targetChar = 'n';
		System.out.println("Target char is present : "+charSearch(str,targetChar));
	}
	
	public static int numSearch(int[] nums,int targetInt)
	{
		for(int i = 0 ; i<nums.length;i++)
		{
			if(targetInt == nums[i])
			{
				return i + 1;
			}
		}
		return -1;
	}
	
	public static boolean charSearch(String str , char target)
	{
		for(int i =0 ;i<str.length() ;i++)
		{
			if(target == str.charAt(i))
			{
				return true;
			}
		}
		return false;
	}
	
	
	public static int searchNumInRange(int[] nums, int target , int start , int end)
	{
		for(int i = start ;i <= end;i++)
		{
			if(target == nums[i])
			{
				return i;
			}
		}
		return -1;
	}
	
	public static int searchMaxNum(int[] nums)
	{
		int maxValue=nums[0];
		for(int i =0;i<nums.length;i++)
		{
			if(maxValue < nums[i])
			{
				maxValue = nums[i];
			}
		}
		return maxValue;
	}
	
	public static int singleNumber(int[] nums) {
        
		int singleNum=nums[0];
		for(int i=0;i<nums.length;i++)
		{
			if(singleNum == nums[i])
			{
				singleNum = nums[i];
			}
		}
		return singleNum;
		 
    }

}
