/*
 *    Copyright (c) 2018-2025, lengleng All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: lengleng (wangiegie@gmail.com)
 */

package com.findshen.modules.bz.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * RedisTemplate  配置
 *
 * @author L.cm
 */
//@ConditionalOnBean(RedisConnectionFactory.class)
@Component
@AllArgsConstructor
public class RedisTemplateConfig {
	private final RedisConnectionFactory redisConnectionFactory;
//	private final RedisProperties redisProperties;

	@Bean
	public RedisTemplate<String, Object> pigxRedisTemplate() {
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
		redisTemplate.setKeySerializer(new StringRedisSerializer());


		redisTemplate.setConnectionFactory(redisConnectionFactory);

		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
		ObjectMapper om = new ObjectMapper();
		// 4.设置可见度
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		// 5.启动默认的类型
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		// 解决jackson2无法反序列化LocalDateTime的问题
		om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		om.registerModule(new JavaTimeModule());
		// 6.序列化类，对象映射设置
		jackson2JsonRedisSerializer.setObjectMapper(om);
		redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);

		redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
		redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);

		return redisTemplate;
	}

	@Bean
	public HashOperations<String, String, Object> hashOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForHash();
	}

	@Bean
	public ValueOperations<String, String> valueOperations(RedisTemplate<String, String> redisTemplate) {
		return redisTemplate.opsForValue();
	}

	@Bean
	public ListOperations<String, Object> listOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForList();
	}

	@Bean
	public SetOperations<String, Object> setOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForSet();
	}

	@Bean
	public ZSetOperations<String, Object> zSetOperations(RedisTemplate<String, Object> redisTemplate) {
		return redisTemplate.opsForZSet();
	}

	/**
	 * 为RedisTemplate配置Redis连接工厂实现
	 * LettuceConnectionFactory实现了RedisConnectionFactory接口
	 * UVPV用Redis
	 *
	 * @return 返回LettuceConnectionFactory
	 */
//
//	//这里要注意的是，在构建LettuceConnectionFactory 时，如果不使用内置的destroyMethod，可能会导致Redis连接早于其它Bean被销毁
//	@Bean(destroyMethod = "destroy")
//	public LettuceConnectionFactory lettuceConnectionFactoryUvPv() throws Exception {
//
//		RedisClusterConfiguration clusterConfiguration = new RedisClusterConfiguration();
//		RedisProperties.Cluster cluster = redisProperties.getCluster();
//		if (cluster != null) {
//			Set<RedisNode> nodes = new HashSet<>();
//			List<String> clusterNodes = redisProperties.getCluster().getNodes();
//			clusterNodes.forEach(address -> nodes.add(new RedisNode(address.split(":")[0].trim(), Integer.valueOf(address.split(":")[1]))));
//			clusterConfiguration.setClusterNodes(nodes);
//			clusterConfiguration.setMaxRedirects(cluster.getMaxRedirects());
//		}
//
//		clusterConfiguration.setPassword(RedisPassword.of(redisProperties.getPassword()));
//
//		GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
//
//		RedisProperties.Lettuce lettuce = redisProperties.getLettuce();
//		if (lettuce != null&&lettuce.getPool()!=null) {
//			poolConfig.setMaxIdle(redisProperties.getLettuce().getPool().getMaxIdle());
//			poolConfig.setMinIdle(redisProperties.getLettuce().getPool().getMinIdle());
//			poolConfig.setMaxTotal(redisProperties.getLettuce().getPool().getMaxActive());
//		}
//
//		return new LettuceConnectionFactory(clusterConfiguration, getLettuceClientConfiguration(poolConfig));
//	}
//
//	/**
//	 * 配置LettuceClientConfiguration 包括线程池配置和安全项配置
//	 *
//	 * @param genericObjectPoolConfig common-pool2线程池
//	 * @return lettuceClientConfiguration
//	 */
//	private LettuceClientConfiguration getLettuceClientConfiguration(GenericObjectPoolConfig genericObjectPoolConfig) {
//        /*
//        ClusterTopologyRefreshOptions配置用于开启自适应刷新和定时刷新。如自适应刷新不开启，Redis集群变更时将会导致连接异常！
//         */
//		ClusterTopologyRefreshOptions topologyRefreshOptions = ClusterTopologyRefreshOptions.builder()
//				//开启自适应刷新
//				//.enableAdaptiveRefreshTrigger(ClusterTopologyRefreshOptions.RefreshTrigger.MOVED_REDIRECT, ClusterTopologyRefreshOptions.RefreshTrigger.PERSISTENT_RECONNECTS)
//				//开启所有自适应刷新，MOVED，ASK，PERSISTENT都会触发
//				.enableAllAdaptiveRefreshTriggers()
//				// 自适应刷新超时时间(默认30秒)
//				.adaptiveRefreshTriggersTimeout(Duration.ofSeconds(25)) //默认关闭开启后时间为30秒
//				// 开周期刷新
//				.enablePeriodicRefresh(Duration.ofSeconds(20))  // 默认关闭开启后时间为60秒 ClusterTopologyRefreshOptions.DEFAULT_REFRESH_PERIOD 60  .enablePeriodicRefresh(Duration.ofSeconds(2)) = .enablePeriodicRefresh().refreshPeriod(Duration.ofSeconds(2))
//				.build();
//		return LettucePoolingClientConfiguration.builder()
//				.poolConfig(genericObjectPoolConfig)
//				.clientOptions(ClusterClientOptions.builder().topologyRefreshOptions(topologyRefreshOptions).build())
//				//将appID传入连接，方便Redis监控中查看
//				//.clientName(appName + "_lettuce")
//				.build();
//	}

}
