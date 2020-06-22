package com.learn.general;

import java.util.HashSet;

public class CollectionTest {
	
	
	
	
	public static void main(String args[]) {
	
		HashSet<ABC> hs = new HashSet<ABC>();
		
		
		
		hs.add(new ABC("1","2","3"));
		hs.add(new ABC("1","5","3"));
		
		
		for(ABC xyz:hs ) {
			
			System.out.println(xyz.a);
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
	

}
