package com.findshen.corejava.pattern.strategy;

/**
 * Created by easzz on 2017/12/7 9:54
 */
public class CompareContext {
	private java.lang.Comparable comparable;

	public CompareContext(java.lang.Comparable comparable) {
		this.comparable = comparable;
	}

	public Integer compareTo(Object o) {
		return comparable.compare(o);
	}
}
