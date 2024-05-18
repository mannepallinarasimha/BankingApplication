package com.java.bank.entity;

public class JavaExample {
     int  x; // instance varible (non- static varible )
     boolean b = true;
     static int A  = 20; // static varible 
	public static void main(String[] args) {
		//int x = 90; //local varibke 
		JavaExample je = new JavaExample();
		
		System.out.println(A); //10
		je.method1();
		JavaExample.method2();
	}
	
	public  int method1() {
		
		int r = 30;
		JavaExample je = new JavaExample();
		System.out.println("Welcome to java method1 : "+JavaExample.A);
		return r;
	}
	
	public static void method2() {
		
		JavaExample je = new JavaExample();
		int method1Return = je.method1();
		System.out.println(method1Return);
		System.out.println("Welcome to java method2 : "+JavaExample.A);
	}
}
