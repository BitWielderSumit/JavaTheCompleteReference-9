package com.learn.cloning;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Employee implements Cloneable {

	private int id;

	private String name;

	private Map<String, String> props;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getProps() {
		return props;
	}

	public void setProps(Map<String, String> p) {
		this.props = p;
	}

	// Shallow Cloning 
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	
	// Deep Cloning
	public Object clone() throws CloneNotSupportedException {

		Object obj = super.clone(); //utilize clone Object method

		Employee emp = (Employee) obj;

		// deep cloning for immutable fields
		emp.setProps(null);
		Map<String, String> hm = new HashMap<String, String>();
		String key;
		Iterator<String> it = this.props.keySet().iterator();
		// Deep Copy of field by field
		while (it.hasNext()) {
			key = it.next();
			hm.put(key, this.props.get(key));
		}
		emp.setProps(hm);
		
		return emp;
	}

	

}