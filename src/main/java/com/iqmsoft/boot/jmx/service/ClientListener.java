package com.iqmsoft.boot.jmx.service;

import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationListener;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;


public class ClientListener implements NotificationListener {

    private static List<String> listStr = new LinkedList<>();


    public void handleNotification(Notification notification, Object handback) {



       System.out.println("ClientListener message: " + notification.getMessage());
       System.out.println("ClientListener type: " + notification.getType());
       System.out.println("ClientListener time:" + new Date(notification.getTimeStamp()));

        if (notification instanceof AttributeChangeNotification){
            AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;

            System.out.println("ClientListener attribute name: " + attributeChangeNotification.getAttributeName());
            System.out.println("ClientListener attribute type: " + attributeChangeNotification.getAttributeType());
            System.out.println("ClientListener old value: " + attributeChangeNotification.getOldValue());
            System.out.println("ClientListener new value: " + attributeChangeNotification.getNewValue());
        }

// ----------------------------

//        listStr.clear();

        listStr.add("ClientListener message: " + notification.getMessage());
        listStr.add("ClientListener type: " + notification.getType());
        listStr.add("ClientListener time:" + new Date(notification.getTimeStamp()));

        if (notification instanceof AttributeChangeNotification){
            AttributeChangeNotification attributeChangeNotification = (AttributeChangeNotification) notification;

            listStr.add("ClientListener attribute name: " + attributeChangeNotification.getAttributeName());
            listStr.add("ClientListener attribute type: " + attributeChangeNotification.getAttributeType());
            listStr.add("ClientListener old value: " + attributeChangeNotification.getOldValue());
            listStr.add("ClientListener new value: " + attributeChangeNotification.getNewValue());
        }

//        return listStr;
    }

    public static List<String> getNotification(){
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
        }
        List tempList = new LinkedList();
        tempList.addAll(listStr);
        listStr.clear();
        return tempList;
    }


}
