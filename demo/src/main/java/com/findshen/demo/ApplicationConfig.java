package com.findshen.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by shenxuan on 2020/5/12 18:11
 */
@Component
@Slf4j
public class ApplicationConfig implements CommandLineRunner {

	@Value("${spring.profiles.active}")
	private String profiles;

	@Value("${server.port}")
	private String port;

	@Override
	public void run(String... args) {
		log.error("Application Started At http://localhost:" + port + profiles);
	}

}
