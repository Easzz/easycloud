package com.findshen.stock;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;

public class A {
    public static void main(String[] args) {
        //02472592974795730101
        String postUrl = "https://192.168.10.5:18531/device/subscribealarm";
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("requestXML", "<Content><Sub14List><SubscribeInfo><AlarmsIncode>123</AlarmIncode></SubscribeInfo></AddSubscribeList></Subscribe></Content>");

        System.out.println(jsonObject.toString());
        HttpResponse execute = HttpUtil.createPost(postUrl).contentType("application/json").header("Cookie", "JSESSIONID=snc2isLlq5biTkcJmld2ODILhmjIFkjy")
                .body(jsonObject.toString()).execute();
        System.out.println(execute.body());
        System.out.println(execute.getCookies());

    }

}
