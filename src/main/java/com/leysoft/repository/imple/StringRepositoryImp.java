
package com.leysoft.repository.imple;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.repository.inter.ObjectRepository;
import com.leysoft.util.Util;

@Transactional
@Repository(
        value = "stringRepositoryImp")
public class StringRepositoryImp<T extends Serializable> implements ObjectRepository<T> {

    private ValueOperations<String, String> valueOperations;

    @Value(
            value = "${redis.time-to-live.seconds:60}")
    private int secondsToLive;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @PostConstruct
    private void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(T object, String id) {
        this.valueOperations.set(id, Util.encodeBase64(object), secondsToLive, TimeUnit.SECONDS);
    }

    @Override
    public T findById(String id) {
        String stringObject = valueOperations.get(id);
        return Util.decodeBase64(stringObject);
    }

    @Override
    public void update(T object, String id) {
        this.valueOperations.set(id, Util.encodeBase64(object));
    }

    @Override
    public boolean delete(String id) {
        return redisTemplate.delete(id);
    }
}
