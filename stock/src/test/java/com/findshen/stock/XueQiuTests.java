package com.findshen.stock;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.findshen.stock.entity.DailyData;
import com.findshen.stock.entity.XueQiuVo;
import com.findshen.stock.service.DailyDataService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;


@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class XueQiuTests {
    @Autowired
    private DailyDataService dailyDataService;

    @Test
    public void contextLoads() {
        String postUrl = "http://wxpusher.zjiecode.com/api/send/message";
        JSONObject jsonObject=new JSONObject();
        jsonObject.set("appToken","AT_BvWJkRs82qMworrIBikBH7rs06uOux6i");
        jsonObject.set("content", "sdfkjwelf");
        jsonObject.set("summary", "zzz");
        jsonObject.set("contentType", "1");

        List<String> uids=new ArrayList<>();
        uids.add("UID_b1B7O0xsvBLT9jx4C72eGT6Mv2UW");
        jsonObject.set("uids",uids);
        jsonObject.set("url","https://xueqiu.com/u/4284663015");


        System.out.println(jsonObject.toString());
        String body = HttpUtil.createPost(postUrl).contentType("application/json").body(jsonObject.toString()).execute().body();
        System.out.println(body);
    }


}
