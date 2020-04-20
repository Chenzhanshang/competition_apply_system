package com.nnxy.competition.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * redis配置类
 *
 * @author :CZS
 * @date :2019/12/17 13:33
 * Email    :642125256@qq.com
 */
@Configuration
public class RedisConfig {

    /**
     * 实例化 redisTemplate
     *
     * @param factory RedisConnectionFactory
     * @return 实例化对象
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        //实例化
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        //key采用string序列化方式
        redisTemplate.setKeySerializer(stringRedisSerializer);
        //hash的key也采用string序列化方式
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        //value采用jackson2JsonRedisSerializer方式序列化
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        //hash的value也采用jackson2JsonRedisSerializer方式序列化
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }


}
