package com.findshen.stock;

import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class A {
    public static void main(String[] args) {
        List<String> uids=new ArrayList<>();
        uids.add("sdfsdf");
        uids.add("fwefwefw");
        System.out.println(uids.toString());
        String s = StrUtil.toString(uids);
        System.out.println(JSON.toJSONString(uids));


        String substring = "测试abc".substring(0, 99);
        System.out.println("测试".length());
        System.out.println(substring);

    }

}
