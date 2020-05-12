//package com.findshen.jms;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class JmsApplication {
////    @Autowired
////    private ActiveMQClient activeMQClient;
//
//    public static void main(String[] args) {
//        SpringApplication.run(JmsApplication.class, args);
//    }
//
////    @PostConstruct
////    public void init(){
////        StopWatch stopWatch=new StopWatch();
////        stopWatch.start();
////        for (int i=0;i<10000;i++){
////            activeMQClient.send("发送消息===zhangsan");
////        }
////        stopWatch.stop();
////        System.out.println("发送消息耗时:"+stopWatch.getTotalTimeMillis());
////    }
//}
