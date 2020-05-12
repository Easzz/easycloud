//package com.findshen.jms.demo;
//
//import org.apache.activemq.broker.region.Destination;
//import org.apache.activemq.command.ActiveMQQueue;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jms.core.JmsMessagingTemplate;
//import org.springframework.jms.core.JmsTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class Publisher {
//    @Autowired
//    private JmsMessagingTemplate jmsMessagingTemplate;
//    public  void publish(String deptName,Object message){
//        JmsTemplate jmsTemplate = jmsMessagingTemplate.getJmsTemplate();
//        jmsTemplate.setPubSubDomain(true);
//        ActiveMQQueue activeMQQueue = new ActiveMQQueue(deptName);
//    }
//}
