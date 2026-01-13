package com.pweb.lamesaSpring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pweb.lamesaSpring.model.Comanda;
import com.pweb.lamesaSpring.repository.comandaRepository;

@Service
public class comandaService {
    private final comandaRepository ComandaRep;

    public comandaService(comandaRepository comandaRep) {
        ComandaRep = comandaRep;
    }

    ///Get
    public List<Comanda> getAll(){
        return ComandaRep.findAll();
    }
    //criar
    public Comanda save(Comanda novaComanda){
        return ComandaRep.save(novaComanda);
    }
    //Delete
    public void delete(Long id){
        ComandaRep.deleteById(id);
    }

}
