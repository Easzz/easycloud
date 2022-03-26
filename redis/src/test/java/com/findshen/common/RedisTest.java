package com.findshen.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.RedisSystemException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.List;

/**
 * 乐观锁测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void insertTestSuccess() {

        StopWatch watch = new StopWatch();
        watch.start();
//      for (int i = 0; i < 10000; i++) {
//           redisTemplate.opsForHash().get("test", i);
////            Object o = redisTemplate.opsForValue().get();
//       }


        List list = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                redisConnection.openPipeline();
                for (int i = 0; i < 10000; i++) {
//                    redisConnection.hGet("test".getBytes(), String.valueOf(i).getBytes());
                    redisConnection.get(String.valueOf(i).getBytes());
//                    redisConnection.set(String.valueOf(i).getBytes(),String.valueOf(i).getBytes());
//                    Object test = redisTemplate.opsForHash().get("test", i);
                }
                return null;
            }
        });

        watch.stop();
        log.info(String.valueOf(list.size()));
        log.info(String.valueOf(list));
        log.info(watch.shortSummary());
    }


}
