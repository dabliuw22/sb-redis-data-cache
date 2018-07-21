
package com.leysoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.model.Person;
import com.leysoft.service.inter.GenericService;

@RestController
@RequestMapping(
        value = {
            "/object"
        })
public class ObjectController {

    @Autowired
    @Qualifier(
            value = "genericStringServiceImp")
    private GenericService<Person> genericService;

    @GetMapping(
            value = {
                "/create"
            })
    public ResponseEntity<Person> create() {
        String id = genericService.createId();
        Person person = new Person();
        person.setId(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping(
            value = {
                "/add"
            })
    public ResponseEntity<Person> save(@RequestBody Person person) {
        genericService.save(person, person.getId());
        return ResponseEntity.ok(person);
    }

    @GetMapping(
            value = {
                "/{id}"
            })
    public ResponseEntity<Person> save(@PathVariable(
            name = "id") String id) {
        Person person = genericService.findById(id);
        return ResponseEntity.ok(person != null ? person : new Person());
    }
}
