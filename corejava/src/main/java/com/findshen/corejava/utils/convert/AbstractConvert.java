package com.findshen.corejava.utils.convert;

/**
 * Created by findshen on 2021/1/19 10:52
 */
public abstract class AbstractConvert<A, B> {
	public abstract B doForward(A a);

	public abstract A doBackup(B b);

}
