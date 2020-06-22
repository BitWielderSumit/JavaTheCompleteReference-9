package com.learn.lambda;


public class ChooseOneDemo {

	public static void main(String[] args) {
		
		int a = 5;
		int b= 6;
		
		ChooseOne ch = (a1,b1)-> {
			return a1 > b1 ? a1 : b1;
		};
		
		System.out.println(ch.test(5, 10, ch));
		
	}

}
