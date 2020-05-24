package com.learn.cloning;

import java.io.IOException;

public class SerializationTest {
	
	public static void main(String[] args) {
		String fileName="employee.ser";
		EmployeeS emp = new EmployeeS();
		emp.setId(100);
		emp.setName("Pankaj");
		
		//serialize to file
		try {
			SerializationUtil.serialize(emp, fileName);
			System.out.println("Completed");
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
//		EmployeeS empNew = null;
//		try {
//			empNew = (EmployeeS) SerializationUtil.deserialize("/Users/sumitagrawal/PSpace/Projects/JavaTheCompleteReference-9/Practicles/DesignPattern/employee.ser");
//		} catch (ClassNotFoundException | IOException e) {
//			e.printStackTrace();
//		}
//		
////		System.out.println("emp Object::"+emp);
//		System.out.println("empNew Object::"+empNew.getName());
		
	}
}