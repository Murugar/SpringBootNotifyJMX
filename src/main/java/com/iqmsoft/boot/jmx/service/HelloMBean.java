package com.iqmsoft.boot.jmx.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

public interface HelloMBean {

	
	
	
    void sayHello();

    int addInteger(int x, int y);

    String getName();

    void setName(String name);
   

}
