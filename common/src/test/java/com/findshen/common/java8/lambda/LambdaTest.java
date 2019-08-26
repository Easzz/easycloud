package com.findshen.common.java8.lambda;

import java.util.function.IntBinaryOperator;

/**
 * Created by shenxuan on 2019/8/13 9:29
 */
public class LambdaTest {
	//java的lambda表达式通常用(argument)->{body}的语法书写
	public static void main(String[] args) {
		IntBinaryOperator intBinaryOperator = Integer::sum;
		System.out.println(intBinaryOperator.applyAsInt(1, 2));


		new Thread(() -> {
			System.out.println(1111);
			System.out.println(Thread.currentThread().getName());
		}).start();

		System.out.println(Thread.currentThread().getName());


	}
}
