
package com.leysoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leysoft.domain.Properties;
import com.leysoft.service.inter.PropertiesService;

@RestController
@RequestMapping(
        value = {
            "/init"
        })
public class InitController {

    @Autowired
    private PropertiesService propertiesService;

    @GetMapping(
            value = {
                "/{codigo}"
            })
    public ResponseEntity<Properties> init(@PathVariable(
            name = "codigo") String codigo) {
        return ResponseEntity.ok(propertiesService.load(codigo));
    }
}
