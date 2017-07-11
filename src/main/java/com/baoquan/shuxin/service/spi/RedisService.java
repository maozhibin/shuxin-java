package com.baoquan.shuxin.service.spi;

import java.util.List;

/**
 * @className:RedisService
 * @description:Redis常用服务接口
 * @author:niuxinpeng
 * @version:v1.0
 */
public interface RedisService<T> {

    public void add(String key, T record);

    public void add(String key, T record, long timeOut);

    public Long leftPush(String key, T record);

    public Long rightPush(String key, T record);

    public List<T> range(String key, long start, long end);

    public long remove(String key, int start, int end);

    public boolean update(T record);

    public T get(String key);

    public T getAndDelete(String key);

    public void delete(String key);
}
