package com.findshen.common;

import com.findshen.modules.bz.entity.People;
import com.findshen.modules.bz.service.ManagerService;
import com.findshen.modules.bz.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.rules.Stopwatch;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

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
        for (int i = 0; i < 10000; i++) {
            redisTemplate.opsForHash().put("test", i, "abc");
        }
        watch.start();
        log.info(watch.shortSummary());

    }


}
