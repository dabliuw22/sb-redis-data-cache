
package com.leysoft.service.inter;

import java.util.List;

import com.leysoft.model.Person;

public interface PersonService {

    public Person create();

    public Person save(Person person);

    public Person findById(String id);

    public List<Person> findAll();

    public boolean update(Person person);

    public boolean delete(String id);
}
