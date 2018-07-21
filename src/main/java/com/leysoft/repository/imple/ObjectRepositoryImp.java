
package com.leysoft.repository.imple;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.repository.inter.ObjectRepository;
import com.leysoft.util.Util;

@Transactional
@Repository(
        value = "objectRepositoryImp")
public class ObjectRepositoryImp<T extends Serializable> implements ObjectRepository<T> {

    private ValueOperations<String, Object> valueOperations;

    @Value(
            value = "${redis.time-to-live.seconds:60}")
    private int secondsToLive;

    @Autowired
    @Qualifier(
            value = "redisTemplate")
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    private void init() {
        this.valueOperations = redisTemplate.opsForValue();
    }

    @Override
    public void save(T object, String id) {
        valueOperations.set(id, Util.encodeBase64(object), secondsToLive, TimeUnit.SECONDS);
    }

    @Override
    public T findById(String id) {
        return Util.decodeBase64((String) valueOperations.get(id));
    }

    @Override
    public void update(T object, String id) {
        valueOperations.set(id, Util.encodeBase64(object));
    }

    @Override
    public boolean delete(String id) {
        return redisTemplate.delete(id);
    }
}
