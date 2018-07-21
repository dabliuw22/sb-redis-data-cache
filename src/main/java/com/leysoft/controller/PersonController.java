
package com.leysoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.model.Person;
import com.leysoft.service.inter.PersonService;

@RestController
@RequestMapping(
        value = {
            "/person"
        })
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(
            value = {
                "/create"
            })
    public ResponseEntity<Person> create() {
        return ResponseEntity.ok(personService.create());
    }

    @GetMapping(
            value = {
                ""
            })
    public ResponseEntity<List<Person>> all() {
        return ResponseEntity.ok(personService.findAll());
    }
}
