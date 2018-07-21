
package com.leysoft.service.inter;

import java.io.Serializable;

public interface GenericService<T extends Serializable> {

    public String createId();

    public void save(T object, String id);

    public T findById(String id);

    public void update(T object, String id);

    public boolean delete(String id);
}
