package com.unibus.pi.controllers;

import com.unibus.pi.dto.RotaDTO;
import com.unibus.pi.services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rotas")
public class RotaController {
    
    @Autowired
    private RotaService service;
    
    @GetMapping(value = "/{id}")
    public RotaDTO findById(@PathVariable int id){
        return service.findById(id);
    }
    
}
