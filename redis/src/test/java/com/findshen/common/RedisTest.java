package com.findshen.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

	@Autowired
	private RedisTemplate<String,Object> redisTemplate;


	@Test
	public void insertTestSuccess() {

		StopWatch watch = new StopWatch();
		watch.start();
//		List<String> keys = new ArrayList<>();
		IotRealData iotRealData = new IotRealData();
		iotRealData.setProjectCode("ZhouXiHe");
		iotRealData.setDtuTag("zhouxihe");
		iotRealData.setId("345439292929229");
		iotRealData.setParamId(iotRealData.getId());
		iotRealData.setChangedIf(true);
		iotRealData.setMonitorTime(LocalDateTime.now());
		iotRealData.setParamKind(1);
		iotRealData.setUniqueCode("");
		iotRealData.setParamCode("ZhouXiHe|ZXH|RUN|");
		iotRealData.setAlertLevelMsg("cemsg");
		iotRealData.setGmtCreate(LocalDateTime.now());
		List<IotRealData> list=new ArrayList<>();
		for (int i = 0; i < 10000; i++) {
//			keys.add(String.valueOf(i));
			IotRealData o = (IotRealData) redisTemplate.opsForHash().get("REAL_DATA_MAP:" + "ZhouXiHe", "ZhouXiHe|ZXH|RUN|" + i);
			list.add(o);
		}

		watch.stop();
		log.info(String.valueOf(list.size()));
//		log.info(String.valueOf(list));
		log.info(watch.shortSummary());
	}


	@Test
	public void insertRead() {
		StopWatch watch = new StopWatch();
		watch.start();
//		for (int i = 0; i < 10000; i++) {
//			IotRealData o = (IotRealData) redisTemplate.opsForHash().get("REAL_DATA_MAP:" + "ZhouXiHe", "ZhouXiHe|ZXH|RUN|" + i);
//		}

		List<Object> objects = redisTemplate.executePipelined((RedisCallback<IotRealData>) redisConnection -> {
//			redisConnection.openPipeline();
			for (int i = 0; i < 10000; i++) {
				String key = "REAL_DATA_MAP:ZhouXiHe";
				String subKey = "ZhouXiHe|ZXH|RUN|" + i;
				redisConnection.hGet(key.getBytes(), subKey.getBytes());
			}
//			redisConnection.closePipeline();
			return null;
		}, redisTemplate.getValueSerializer());


		watch.stop();
		log.info(String.valueOf(objects.size()));
//		log.info(String.valueOf(list));
		log.info(watch.shortSummary());
	}


}
