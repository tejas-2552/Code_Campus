package com.dsa;

import java.util.Scanner;

public class Calculator {

	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		System.out.println("Enter a operation operator : ");
		int ans = 0;
		char op;
		while(true)
		{
			op = in.next().trim().charAt(0);
			if(op == '%' || op == '*' || op == '/' || op == '-' || op == '+')
			{
				System.out.println("Enter num 1 : ");
				int num1=in.nextInt();
				System.out.println("Enter num 2 : ");
				int num2=in.nextInt();
				
				if(op == '+')
				{
				   ans=num1+num2;
				}
				if(op == '-')
				{
				   ans=num1-num2;   
				}
				if(op == '*')
				{
				   ans=num1*num2;   
				}
				if(op == '/')
				{
					if(num1 != 0)
					{
						 ans=num1-num2;   
					}
				  
				}
				if(op == '%')
				{
				   ans=num1%num2;   
				}
				break;
			}
			else if(op == 'x' || op == 'X')
			{
				break;
			}else {
				System.out.println("Invalid operator!");
			}
		}
		System.out.println(ans);
	}
}
