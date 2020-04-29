package com.findshen.corejava.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 对集合进行计算
 * @author shenxuan
 * @date 2020年02月16日23:00:12
 */
public class CollectionCalculate {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List<String> list2 = new ArrayList<>();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");



        //交集
        List<String> collect = list1.stream().filter(list2::contains).collect(Collectors.toList());
        System.out.println(collect);

        //差集 list1-list2
        List<String> collect1 = list1.stream().filter(i -> !list2.contains(i)).collect(Collectors.toList());
        System.out.println(collect1);

        //差集list2-list1
        List<String> collect2 = list2.stream().filter(i -> !list1.contains(i)).collect(Collectors.toList());
        System.out.println(collect2);

        //并集
        list1.addAll(list2);
        System.out.println(list1);

        //去重并集
        List<String> collect3 = list1.stream().distinct().collect(Collectors.toList());
        System.out.println(collect3);


    }
}
