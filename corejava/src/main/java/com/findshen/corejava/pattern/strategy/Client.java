package com.findshen.corejava.pattern.strategy;

/**
 * Created by easzz on 2017/12/7 9:24
 * 策略模式仅仅只是封装算法，组织，调用这些算法
 * 而不是实现算法，算法的实现在不同的子类中，修改的时候只需要修改子类而不用动客户端
 * 解耦合
 */
public class Client {
	public static void main(String[] args) {
		Comparable c = new Cat(10);

		Integer a1=100;

		CompareContext cc=new CompareContext(o -> o>a1);


		Boolean aBoolean = cc.compareTo(12);

		System.out.println(aBoolean);

	}
}
