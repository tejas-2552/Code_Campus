package com.dsa;

public class EvenNumberProblems {

	public static void main(String[] args)
	{
		// Q1 : Find no of nums that have even number of digit 
		int[] arr = {123,41,856,7688,58656,86,99};
		System.out.println("Even num based on digit count : " + findEvenCount(arr));
		
	}
	
	public static int findEvenCount(int[] arr)
	{
		int count = 0;
		for(int i =0 ;i<arr.length;i++)
		{
			if (evenNumberCheck(numDigitCountv2(arr[i])))
			{
				count++;
			}
		}
		return count;
	}
	
	public static boolean evenNumberCheck(int num)
	{
		return num%2==0;
	}
	
	public static int numDigitCount(int num)
	{
		int count = 0;
		while(num > 0)
		{
			num = num / 10;
			count ++;
		}
		return count;
	}
	// Returns count of digits in a number
	public static int numDigitCountv2(int num)
	{
		return (int) Math.log10(num)+1;
	}
	
}
