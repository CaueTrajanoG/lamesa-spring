package com.pweb.lamesaSpring.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pweb.lamesaSpring.model.Comanda;
import com.pweb.lamesaSpring.service.comandaService;

@RestController
@RequestMapping("/dashboard")

public class comandaController {

    //Injeção de dependencia
    private final comandaService comandaService;

    public comandaController(comandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping
    public List<Comanda> getAll(){
        return comandaService.getAll();
    }

    @PostMapping            //anotacao do spring pra passar o objeto diretamente
    public Comanda create(@RequestBody Comanda novaComanda){
        return comandaService.save(novaComanda);
    }

}
