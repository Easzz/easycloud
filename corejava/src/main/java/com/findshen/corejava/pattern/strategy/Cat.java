package com.findshen.corejava.pattern.strategy;

/**
 * Created by easzz on 2017/12/7 9:28
 */
public class Cat implements Comparable {
	private Integer weight;
	private Integer height;

	public Cat(Integer height) {
		this.height = height;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}


	@Override
	public Boolean compare(Integer o) {
		return null;
	}
}
