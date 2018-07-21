
package com.leysoft.service.imple;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leysoft.model.Person;
import com.leysoft.repository.PersonRepository;
import com.leysoft.service.inter.PersonService;

@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Person create() {
        String id = UUID.randomUUID().toString();
        Person person = new Person();
        person.setId(id);
        return person;
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person findById(String id) {
        return personRepository.findById(id).orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public boolean update(Person person) {
        return personRepository.save(person) != null;
    }

    @Override
    public boolean delete(String id) {
        boolean deleted = false;
        Person person = findById(id);
        if (person != null) {
            personRepository.deleteById(id);
            deleted = true;
        }
        return deleted;
    }
}
