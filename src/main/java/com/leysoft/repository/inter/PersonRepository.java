
package com.leysoft.repository.inter;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leysoft.model.Person;

@Repository
@Transactional
public interface PersonRepository extends CrudRepository<Person, String> {
}
