
package com.leysoft.service.imple;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.repository.inter.ObjectRepository;
import com.leysoft.service.inter.GenericService;

@Service(
        value = "genericObjectServiceImp")
public class GenericObjectServiceImp<T extends Serializable> implements GenericService<T> {

    @Autowired
    @Qualifier(
            value = "objectRepositoryImp")
    private ObjectRepository<T> objectRepository;

    @Override
    public String createId() {
        return objectRepository.createId();
    }

    @Override
    public void save(T object, String id) {
        objectRepository.save(object, id);
    }

    @Override
    public T findById(String id) {
        return objectRepository.findById(id);
    }

    @Override
    public void update(T object, String id) {
        objectRepository.update(object, id);
    }

    @Override
    public boolean delete(String id) {
        return objectRepository.delete(id);
    }
}
