
package com.leysoft.repository.inter;

import java.io.Serializable;
import java.util.UUID;

public interface ObjectRepository<T extends Serializable> {

    public default String createId() {
        return UUID.randomUUID().toString();
    }

    public void save(T object, String id);

    public T findById(String id);

    public void update(T object, String id);

    public boolean delete(String id);
}
