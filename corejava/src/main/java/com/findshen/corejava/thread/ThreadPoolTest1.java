package com.findshen.corejava.thread;

/**
 * Created by easzz on 2017/11/27 10:39
 */
public class ThreadPoolTest1 {
	public static void main(String[] args) {

//		ExecutorService executorService = Executors.newFixedThreadPool(10);
//		final CountDownLatch countDownLatch = new CountDownLatch(100000);
		long startTime = System.currentTimeMillis();    //获取开始时间

		for (int j = 0; j < 100000; j++) {
			System.out.println(j + "thread:" + Thread.currentThread().getName());
		}
		System.out.println("aa" + (System.currentTimeMillis() - startTime));

	}


}
