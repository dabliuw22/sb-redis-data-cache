
package com.leysoft.model;

import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;

@RedisHash(
        value = "Person",
        timeToLive = 120)
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
