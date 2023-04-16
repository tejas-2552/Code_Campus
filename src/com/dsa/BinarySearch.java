package com.dsa;

public class BinarySearch {

	public static void main(String args[])
	{
		// Ascending array initilized
		int[] arr = {1,42,43,53,63,72,88,99,200,241,312,514};
		System.out.println("atIndex : "+binarySearch(arr,312));
		System.out.println("atIndex : "+orderAgnosticBS(arr,312));
		int[] descArr = {111,109,108,107,106,105,104,103,102,101};
		System.out.println("atIndex : "+orderAgnosticBS(descArr,102));
		int[] arry = {1};
		System.out.println("atIndex : "+searchInsert(arry,0));
		System.out.println("String compare : "+strStr("abcdda","dd"));
		System.out.println("Lenght of the last word : "+lengthOfLastWord("as w asc  "));
	}
	
	public static int binarySearch(int[] arr , int targetInt)
	{
		int start = 0;
		int end = arr.length - 1;
		print(arr,start,end);
		while(start<=end)
		{
			int mid = start + (end - start)/2;
			if(arr[mid] > targetInt)
			{
				//Lies at left hand side
				end = mid  - 1;
				print(arr,start,end);
			}
			else if(arr[mid] < targetInt)
			{
				start = mid + 1;
				print(arr,start,end);
			}
			else 
			{
				print(arr,start,mid);
				return mid;
			}
		}
		return -1;
	}
	public static int binarySearchV2(int[] arr,int targetInt)
	{
		// Consider array size as 5
		int start = 0;
		int end = arr.length -1 ; // end = 4 coz array starts from 0
		while(start<=end) // 0 <= 4
		{
			// Pick the middle length of the array
			int mid  = start + (end - start)/2; // 0 + (4 - 0)/2 = 2
			if(arr[mid] > targetInt)
			{
				// Here we check the element lies in left or right of the array size by comparing 
				end = mid - 1; //Setting end = mid - 1 
			}else if(arr[mid] < targetInt)
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
	public static void print(int[] arr,int start , int end)
	{
		for(int i = start; i<=end ; i++)
		{
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int orderAgnosticBS(int[] arr, int targetInt)
	{
		int start = 0;
		int end = arr.length - 1;
		
		// Find weather the array is ascending or descending then perform BS 
		boolean isAsec = arr[start]<arr[end];
		
		while(start<=end)
		{
			int mid = start +(end-start)/2;
			if(arr[mid]==targetInt)
			{
				return mid;
			}
			if(isAsec)
			{
				if(arr[mid]>targetInt)
				{
					end = mid - 1;
				}else
				{
					start = mid + 1;
				}
			}else 
			{
				if(arr[mid]<targetInt)
				{
					end = mid - 1;
				}else
				{
					start = mid + 1;
				}
			}
		}
		return -1;
		
	}

	public static int searchInsert(int[] arr, int targetInt) {
		int start = 0;
		int end = arr.length - 1;
		// Find weather the array is ascending or descending then perform BS
		boolean isAsec = arr[start] < arr[end];

		int insertIndex = 0;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == targetInt) {
				return mid;
			}

			if (arr[mid] > targetInt) {
				end = mid - 1;
			} else if (arr[mid] < targetInt) {
				start = mid + 1;
			}

		}
		return start;
	}
	
	public static int strStr(String haystack, String needle) {
        if(0 == needle.length())
        {
            return 0;
        }
        for(int i=0;i<haystack.length();i++)
        {
            if(haystack.substring(i,needle.length() + i).equals(needle))
            {
            	return i;
            } 
        }
        
        return -1;
    }

	public static int lengthOfLastWord(String s) {
		int i=0;
		int end=0;
		int mid = 0;
		String str="";
		while(i<s.length())
		{
			if(s.charAt(i)!=32)
			{ 
				mid = mid + 1;
				end = i;
				str = s.substring((end+1)-mid,(end+1));
			}else {
				mid = 0;
			}
			i++;
		}
//		str = s.substring((end+1)-mid,(end+1));
		System.out.println(str);
		return str.length();
	}
}
