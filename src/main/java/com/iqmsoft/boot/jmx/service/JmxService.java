package com.iqmsoft.boot.jmx.service;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Service;

import com.iqmsoft.boot.jmx.entity.RemoteJMXEntity;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.io.IOException;



@Service
public class JmxService implements IJmxService{

    private JMXServiceURL jmxServiceURL;
    private JMXConnector jmxConnector;
    private MBeanServerConnection mBeanServerConnection;
    private ObjectName objectNameBean;
    private HelloMBean helloMBeanProxy;


    public JmxService(){
//        createConnection();
    }

  //  @ManagedOperation
    public void sayHello(){
    	
       System.out.println("Inside Say Hello");
    	
       helloMBeanProxy.sayHello();
       
       try {
            Thread.sleep(1000);
       } catch (InterruptedException e) {
            e.printStackTrace();
       }
    }

   // @ManagedOperation
    public String addInteger(Integer a, Integer b){
        return String.valueOf(helloMBeanProxy.addInteger(a, b));
    }

   // @ManagedOperation
    public void setName(String name){
        helloMBeanProxy.setName(name);
    }

   // @ManagedAttribute
    public String getName(){
        return helloMBeanProxy.getName();
    }

    public boolean createConnection(){
        try {
            this.jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9999/jmxrmi");
            this.jmxConnector = JMXConnectorFactory.connect(jmxServiceURL, null);

            this.mBeanServerConnection = jmxConnector.getMBeanServerConnection();

            this.objectNameBean = new ObjectName("com.iqmsoft.boot.jmx:type=Hello");
            
            this.helloMBeanProxy = 
            		JMX.newMBeanProxy(mBeanServerConnection, objectNameBean, HelloMBean.class, true);

            this.mBeanServerConnection.addNotificationListener(objectNameBean, new ClientListener(), null, null);

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MalformedObjectNameException e) {
            e.printStackTrace();
        } catch (InstanceNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean closeConnection(){
        try {
            jmxConnector.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void remoteByEntity(RemoteJMXEntity remoteJMXEntity){

        if (remoteJMXEntity.getCreateConnection()){
            createConnection();
            System.out.println("Create Connection");
        }
        
       

        if (!remoteJMXEntity.getCreateConnection()){
        	System.out.println("Close Connection");
            closeConnection();
            return;
        }

        if (remoteJMXEntity.getGetName()){
        	System.out.println("Get Name");
            getName();
        }

        if (remoteJMXEntity.getSayHello()){
        	
        	System.out.println("Before Say Hello");
        	
            sayHello();
            
            System.out.println("After Say Hello");
        }

        if (!remoteJMXEntity.getSetName().equals("")){
        	System.out.println("Set Name");
            setName(remoteJMXEntity.getSetName());
            remoteJMXEntity.setSetName("");
        }

        if (!remoteJMXEntity.getA().equals("") || !remoteJMXEntity.getB().equals("")){

            try {
            	System.out.println("Set Add Integers");
                addInteger(Integer.parseInt(remoteJMXEntity.getA()), Integer.parseInt(remoteJMXEntity.getB()));
                remoteJMXEntity.setA("");
                remoteJMXEntity.setB("");
            } catch (NumberFormatException e) {
//                e.printStackTrace();
            }
        }

    }



}
