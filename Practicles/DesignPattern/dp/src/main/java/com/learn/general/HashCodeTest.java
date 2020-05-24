package com.learn.general;

public class HashCodeTest {
	
	
	public static void main(String args[]) {
		
		HashCodeTest t1 = new HashCodeTest();
		HashCodeTest t2 = new HashCodeTest();
		HashCodeTest t3 = new HashCodeTest();
		HashCodeTest t4 = new HashCodeTest();
		HashCodeTest t5 = new HashCodeTest();
		HashCodeTest t6 = t1;
		
		
		
		
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		System.out.println(t4.hashCode());
		System.out.println(t5.hashCode());
		System.out.println(t6.hashCode());
		
	}

}
