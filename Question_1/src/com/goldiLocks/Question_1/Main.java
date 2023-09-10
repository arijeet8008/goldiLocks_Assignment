package com.goldiLocks.Question_1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		System.out.println(binaryString(str));
		
	}
	
	public static String binaryString(String str){
		
		try {
			
			int value =  Integer.parseInt(str);
			
			return Integer.toBinaryString(value); 
			
		} catch (NumberFormatException e) {
			
			return e.getMessage()+" is invalid ";
			
		}
		
	}

}
