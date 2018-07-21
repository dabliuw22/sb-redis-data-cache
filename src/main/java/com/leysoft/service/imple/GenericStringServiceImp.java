
package com.leysoft.service.imple;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leysoft.repository.inter.ObjectRepository;
import com.leysoft.service.inter.GenericService;

@Service(
        value = "genericStringServiceImp")
public class GenericStringServiceImp<T extends Serializable> implements GenericService<T> {

    @Autowired
    @Qualifier(
            value = "stringRepositoryImp")
    private ObjectRepository<T> stringRepository;

    @Override
    public String createId() {
        return stringRepository.createId();
    }

    @Override
    public void save(T object, String id) {
        stringRepository.save(object, id);
    }

    @Override
    public T findById(String id) {
        return stringRepository.findById(id);
    }

    @Override
    public void update(T object, String id) {
        stringRepository.update(object, id);
    }

    @Override
    public boolean delete(String id) {
        return stringRepository.delete(id);
    }
}
