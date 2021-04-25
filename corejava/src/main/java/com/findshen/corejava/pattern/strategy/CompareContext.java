package com.findshen.corejava.pattern.strategy;

/**
 * Created by easzz on 2017/12/7 9:54
 */
public class CompareContext {



	private Comparable comparable;

	public CompareContext(Comparable comparable) {
		this.comparable = comparable;
	}
//
//	public Integer compareTo(Integer o) {
//		return (Integer) comparable.compare(o);
//	}

	public Boolean compareTo(Integer o) {

		return comparable.compare(o);
	}


}
