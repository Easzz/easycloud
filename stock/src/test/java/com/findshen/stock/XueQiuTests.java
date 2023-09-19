package com.findshen.stock;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import com.findshen.stock.service.DailyDataService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class XueQiuTests {
	@Autowired
	private DailyDataService dailyDataService;

	@Test
	public void contextLoads() {
		String postUrl = "http://wxpusher.zjiecode.com/api/send/message";
		JSONObject jsonObject = new JSONObject();
		jsonObject.set("appToken", "AT_BvWJkRs82qMworrIBikBH7rs06uOux6i");
		jsonObject.set("content", "sdfkjwelf");
		jsonObject.set("summary", "zzz");
		jsonObject.set("contentType", "1");

		List<String> uids = new ArrayList<>();
		uids.add("UID_b1B7O0xsvBLT9jx4C72eGT6Mv2UW");
		jsonObject.set("uids", uids);
		jsonObject.set("url", "https://xueqiu.com/u/4284663015");


		System.out.println(jsonObject.toString());
		String body = HttpUtil.createPost(postUrl).contentType("application/json").body(jsonObject.toString()).execute().body();
		System.out.println(body);
	}


//
//    public static void main(String[] args){
//        String postUrl = "https://192.168.10.5:18531/loginInfo/login/v1.0";
//        JSONObject jsonObject=new JSONObject();
//        jsonObject.set("userName","StiAdmin");
//        jsonObject.set("password", "Sti@2018");
//
//        System.out.println(jsonObject.toString());
//        HttpResponse execute = HttpUtil.createPost(postUrl).contentType("application/json").body(jsonObject.toString()).execute();
//        System.out.println(execute.body());
//        System.out.println(execute.getCookies());
//
//    }


	public static void main(String[] args) {
		String postUrl = "https://192.168.10.5:18531/device/subscribealarm";
		JSONObject jsonObject = new JSONObject();
		jsonObject.set("requestXML  ", "<Content><Subscribe><AddSubscribeList><SubscribeInfo><AlarmIncode>0247259\n" +
				"2974795730101</AlarmIncode></SubscribeInfo></AddSubscribeList></\n" +
				"Subscribe></Content>");

		System.out.println(jsonObject.toString());
		HttpResponse execute = HttpUtil.createPost(postUrl).contentType("application/json").header("Cookie", "JSESSIONID=9rgnfv8naVtySw4YhzmbF8RuPMAk0YoO")
				.body(jsonObject.toString()).execute();
		System.out.println(execute.body());
		System.out.println(execute.getCookies());

	}


}
