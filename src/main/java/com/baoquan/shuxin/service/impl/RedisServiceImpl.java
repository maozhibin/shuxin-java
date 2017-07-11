package com.baoquan.shuxin.service.impl;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.data.redis.core.RedisTemplate;

import com.baoquan.shuxin.config.GlobalConfig;
import com.baoquan.shuxin.service.spi.RedisService;

@Named
public class RedisServiceImpl<T> implements RedisService<T> {

    @Inject
    protected GlobalConfig globalConfig;

    @Inject
    protected RedisTemplate<String, T> redisTemplate;

    public synchronized void add(String key, T record) {
        key = globalConfig.getRedis_prefix() + key;
        redisTemplate.opsForValue().set(key, record);
    }

    public synchronized void add(String key, T record, long timeout) {
        key = globalConfig.getRedis_prefix() + key;
        redisTemplate.opsForValue().set(key, record);
        redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    public Long leftPush(String key, T record) {
        key = globalConfig.getRedis_prefix() + key;
        return redisTemplate.opsForList().leftPush(key, record);
    }

    public Long rightPush(String key, T record) {
        key = globalConfig.getRedis_prefix() + key;
        return redisTemplate.opsForList().rightPush(key, record);
    }

    public List<T> range(String key, long start, long end) {
        key = globalConfig.getRedis_prefix() + key;
        return redisTemplate.opsForList().range(key, start, end);
    }

    public long remove(String key, int start, int end) {
        key = globalConfig.getRedis_prefix() + key;
        return redisTemplate.opsForList().remove(key, start, end);
    }

    public boolean update(T record) {
        return true;
    }

    public T get(String key) {
        key = globalConfig.getRedis_prefix() + key;
        return redisTemplate.opsForValue().get(key);
    }

    public T getAndDelete(String key) {
        key = globalConfig.getRedis_prefix() + key;
        T t = redisTemplate.opsForValue().get(key);
        this.delete(key);
        return t;
    }

    public void delete(String key) {
        key = globalConfig.getRedis_prefix() + key;
        redisTemplate.delete(key);
    }
}
