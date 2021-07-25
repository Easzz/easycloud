package com.example.drive.controller;


import com.example.drive.entity.Fraction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        List<Fraction> list=new ArrayList();

        List<Fraction> list1 = new ArrayList<>();
        Fraction fraction1 = new Fraction();
        fraction1.setStudent("小明");
        fraction1.setChinese(98);
        fraction1.setMathematics(null);
        fraction1.setEnglish(null);
        list1.add(fraction1);

        List<Fraction> list2 = new ArrayList<>();
        Fraction fraction2 = new Fraction();
        fraction2.setStudent("小明");
        fraction2.setChinese(null);
        fraction2.setMathematics(92);
        fraction2.setEnglish(null);
        list2.add(fraction2);

        List<Fraction> list3 = new ArrayList<>();
        Fraction fraction3 = new Fraction();
        fraction3.setStudent("小明");
        fraction3.setChinese(null);
        fraction3.setMathematics(null);
        fraction3.setEnglish(90);


        list.addAll(list1);

        list.addAll(list2);
        list.addAll(list3);



        Map<String, Fraction> result = new HashMap<>();
        for (Fraction item : list) {
            String name = item.getStudent();
            if (result.get(name) == null) {
                result.put(name, item);
            }
            if (item.getChinese() != null) {
                result.get(name).setChinese(item.getChinese());
            }
            if (item.getEnglish() != null) {
                result.get(name).setEnglish(item.getEnglish());
            }
            if (item.getMathematics() != null) {
                result.get(name).setMathematics(item.getMathematics());
            }
        }
        System.out.println(result);

    }
}
