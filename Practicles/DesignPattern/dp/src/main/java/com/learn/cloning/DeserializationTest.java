package com.learn.cloning;

import java.io.IOException;

import java.io.IOException;

public class DeserializationTest {

	public static void main(String[] args) {

		String fileName="employee.ser";
		EmployeeS empNew = null;
		
		try {
			empNew = (EmployeeS) SerializationUtil.deserialize(fileName);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("empNew Object::"+empNew);
		
	}
}