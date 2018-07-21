
package com.leysoft.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leysoft.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, String> {
}
