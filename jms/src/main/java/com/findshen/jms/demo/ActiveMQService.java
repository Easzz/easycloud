package com.findshen.jms.demo;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ActiveMQService {

    @JmsListener(destination = "zhangsan")
    public void receive(String msg){
        System.out.println("收到的msg："+msg);
    }
}
