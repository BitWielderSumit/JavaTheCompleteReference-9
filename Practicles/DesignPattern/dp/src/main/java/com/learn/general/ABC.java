package com.learn.general;

class ABC{
	
	String a;
	String b;
	String c;
	
	ABC(String a, String b, String c){
		this.a = a;
		this.b = b;
		this.c = c;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		
		ABC that = (ABC) obj;
		
		if(this.a.equalsIgnoreCase(that.a)) {
			return true;
		}
		return false;
		
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		
		int hashcode = 0;
		
		hashcode = a.hashCode()+b.hashCode()+c.hashCode();
		
		return hashcode;
	}
	
	
	
	
	
}
