package com.example.drive.controller;


import com.example.drive.entity.Fraction;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {


        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> m = new HashMap<>();
        m.put("a", "1");
        m.put("b", "");
        m.put("c", "");
        list.add(m);
        m = new HashMap<>();
        m.put("a", "");
        m.put("b", "2");
        m.put("c", "22");
        list.add(m);
        m = new HashMap<>();
        m.put("a", "222");
        m.put("b", "");
        m.put("c", "");
        list.add(m);
        m = new HashMap<>();
        m.put("a", "");
        m.put("b", "");
        m.put("c", "1222");
        list.add(m);

        Map<String, List<String>> all = new HashMap<>();
        Map<String, String> stringStringMap = list.get(0);
        for (String s : stringStringMap.keySet()) {
            all.put(s, new ArrayList<>());
        }
        list.forEach(l -> {
            for (String s : l.keySet()) {
                List<String> list1 = all.get(s);
                if (!StringUtils.isBlank(l.get(s))) {
                    list1.add(l.get(s));
                }

            }
        });
        System.out.println(all);
        //获取最大的长度
        int maxLength = 0;
        for (String s : all.keySet()) {
            List<String> list1 = all.get(s);
            if (list1.size() > maxLength) {
                maxLength = list1.size();
            }
        }
        System.out.println(maxLength);

        List<Map<String, String>> result = new ArrayList<>();
        for (int i = 0; i < maxLength; i++) {
            Map<String, String> m1 = new HashMap<>();

            for (String s : all.keySet()) {
                List<String> list1 = all.get(s);
                try {
                    String s1 = list1.get(i);
                    m1.put(s, s1);
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("e");
                }
            }

            result.add(m1);
        }
        System.out.println(result);
    }


}
