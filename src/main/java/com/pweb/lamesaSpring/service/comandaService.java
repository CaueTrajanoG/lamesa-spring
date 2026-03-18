package com.pweb.lamesaSpring.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pweb.lamesaSpring.model.Comanda;
import com.pweb.lamesaSpring.repository.comandaRepository;

@Service
public class comandaService {
    private final comandaRepository ComandaRep;
    private final ObjectMapper mapper;
    
    public comandaService(comandaRepository comandaRep, ObjectMapper mapper) {
        ComandaRep = comandaRep;
        this.mapper = mapper;
    }

    ///Get
    public List<Comanda> getAll(){
        return ComandaRep.findAll();
    }
    
    public Optional<Comanda> getById(Long id){
        return ComandaRep.findById(id);
    }

    public Optional<Comanda> getByNumber(Long numero){
        return ComandaRep.findByNumero(numero);
    }

    //posting a new order
    public Comanda save(Comanda novaComanda){        
        return ComandaRep.save(novaComanda);
    }


    //Delete
    public String deleteById(Long id) {
        Comanda comanda = this.ComandaRep.findById(id).orElse(null);
        
        if(comanda == null) return "Objeto inexistente";

        this.ComandaRep.deleteById(id);
        return "Objeto removido";
    }

    // PUT
    public Comanda updateByPut(Long id, Comanda comanda){
        Comanda existingComanda = this.ComandaRep.findById(id)
            .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));

        // garante que o ID do path é o que será salvo
        comanda.setId(existingComanda.getId());
        return this.ComandaRep.save(comanda);
    }

    // PATCH
    public Comanda updateByPatch(Long id, Comanda comanda){

        Comanda existingComanda = this.ComandaRep.findById(id)
            .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));

        try {
            // ignora campos null no PATCH
            this.mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

            this.mapper.updateValue(existingComanda, comanda);

            return this.ComandaRep.save(existingComanda);

        } catch (JsonMappingException e) {
            throw new RuntimeException("Erro ao aplicar PATCH", e);
        }
    }
}
