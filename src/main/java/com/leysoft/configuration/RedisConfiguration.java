
package com.leysoft.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

@Configuration
public class RedisConfiguration {

    @Value(
            value = "${spring.redis.host:localhost}")
    private String redisHost;

    @Value(
            value = "${spring.redis.port:6379}")
    private int redisPort;

    @Value(
            value = "${redis.transaction-support:true}")
    private boolean redisTransactioSupport;

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        return new RedisStandaloneConfiguration(redisHost, redisPort);
    }

    @Bean
    public RedisConnectionFactory
            redisConnectionFactory(RedisStandaloneConfiguration standaloneConfiguration) {
        return new JedisConnectionFactory(standaloneConfiguration);
    }

    @Bean(
            name = "redisTemplate")
    public RedisTemplate<String, Object>
            redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        redisTemplate.setValueSerializer(new GenericToStringSerializer<>(Object.class));
        redisTemplate.setEnableTransactionSupport(redisTransactioSupport);
        return redisTemplate;
    }

    @Bean(
            name = "stringRedisTemplate")
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
        stringRedisTemplate.setEnableTransactionSupport(redisTransactioSupport);
        return stringRedisTemplate;
    }
}
