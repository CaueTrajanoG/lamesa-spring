package com.pweb.lamesaSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/all")
    public List<Comanda> getAll(){
        return comandaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Comanda> getById(@PathVariable Long id){
        return comandaService.getById(id);
    }

    @PostMapping      //anotacao do spring pra passar o objeto diretamente
    public String create(@RequestBody Comanda novaComanda){
        return comandaService.save(novaComanda);
    }

    @PutMapping("/{id}")
    public String updateViaPUT(@PathVariable Long id,@RequestBody Comanda comanda) {
        return this.comandaService.updateByPut(id, comanda);
    }

    @PatchMapping("/{id}")
    public String updateViaPATCH(@PathVariable Long id,@RequestBody Comanda comanda
    ) {
        return this.comandaService.updateByPatch(id, comanda);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id){
        this.comandaService.deleteById(id);
    }

}
