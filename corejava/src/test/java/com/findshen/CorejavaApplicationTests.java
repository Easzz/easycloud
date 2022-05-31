package com.findshen;

import com.google.common.collect.Lists;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CorejavaApplicationTests {

	public static void main(String[] args) {

		String cron="0/2 * 9-15 ? * 2-6";

		CronExpression cronExpression = CronExpression.parse(cron);
		// 下一次预计执行时间
		LocalDateTime nextFirst = cronExpression.next(LocalDateTime.now());

		Objects.requireNonNull(nextFirst);
		// 下下次预计执行时间
		LocalDateTime nextSecond = cronExpression.next(nextFirst);

		List<LocalDateTime> dateTimes = Lists.newArrayList();
		int i = 0;
		while (i++ < 10000) {
			Objects.requireNonNull(nextSecond);

			nextFirst = cronExpression.next(nextFirst);

			dateTimes.add(nextFirst);
		}

		for (LocalDateTime dateTime : dateTimes) {
			System.out.println(dateTime);
		}
	}

}
