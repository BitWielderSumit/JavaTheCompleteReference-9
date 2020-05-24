package com.learn.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {

			HashMap<String, String> test = new HashMap<>();
			
			test.put("1","Sumit");
			test.put("2","Amit");
			test.put("2","Rohit");
			
			System.out.println("Hold Here");
			
			System.out.println(test.get("2"));
			
			Set<Entry<String, String>> test1 = test.entrySet();
			
			System.out.println("Hold Here");
			
			

	}

}
