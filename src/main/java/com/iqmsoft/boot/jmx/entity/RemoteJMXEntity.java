package com.iqmsoft.boot.jmx.entity;

import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
public class RemoteJMXEntity{

    private boolean createConnection = false;

    private boolean sayHello = false;
    private boolean getName = false;

    private String a = "";
    private String b = "";
    private String setName = "";

    public boolean getSayHello() {
        return sayHello;
    }

    public void setSayHello(boolean sayHello) {
        this.sayHello = sayHello;
    }

    public boolean getGetName() {
        return getName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public boolean getCreateConnection() {
        return createConnection;
    }

    public void setCreateConnection(boolean createConnection) {
        this.createConnection = createConnection;
    }

//--------------------------------------

    public void setGetName(boolean getName) {
        this.getName = getName;
    }

    public String getSetName() {
        return setName;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }





}
