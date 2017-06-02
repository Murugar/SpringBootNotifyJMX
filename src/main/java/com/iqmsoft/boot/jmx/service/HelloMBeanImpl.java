package com.iqmsoft.boot.jmx.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "com.iqmsoft.boot.jmx:type=Hello")
public class HelloMBeanImpl implements HelloMBean {

	
	String Name;
	
	@ManagedOperation
    public void sayHello(){
		
	}

	@ManagedOperation
	public int addInteger(int x, int y){
		return x + y;
	}

	@ManagedAttribute
	public String getName() {
		return Name;
	}

    @ManagedAttribute
    public void setName(String name)
    {
    	this.Name = name;
    }

    

}

