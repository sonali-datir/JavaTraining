//Day 2 – Build a simple calculator that takes 2 numbers
//as input and calculated the sum of 2 numbers.

import java.util.Scanner;

public class Calculator{
	public static void main(String[] args){
		int num1,num2,addition;
        Scanner sc = new Scanner(System.in);
        
		System.out.println("Enter First Number");
        num1 = sc.nextInt();
        
		System.out.println("Enter Second Number");
        num2 = sc.nextInt();
        
		addition=num1+num2;
        
		System.out.println("Addition = "+addition);
	}
}