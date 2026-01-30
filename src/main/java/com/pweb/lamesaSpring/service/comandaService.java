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


    //posting a new order
    public String save(Comanda novaComanda){
        ComandaRep.save(novaComanda);
        return "Comanda criada com sucesso!";
    }


    //Delete
    public String deleteById(Long id) {
        Comanda comanda = this.ComandaRep.findById(id).orElse(null);
        
        if(comanda == null) return "Objeto inexistente";

        this.ComandaRep.deleteById(id);
        return "Objeto removido";
    }

    //PUT

    public String updateByPut(Long id,Comanda comanda){

        if (comanda != null){
            comanda.setId(id);
            this.ComandaRep.save(comanda);
            return "Comanda atualizada com sucesso!";
        }
        return "Comanda invalida";
    }

    //Pach

    public String updateByPatch(Long id, Comanda comanda){
        Comanda existingComanda = this.ComandaRep.findById(id).orElse(null);   
        
        if(existingComanda != null){
        try {
                this.mapper.setDefaultPropertyInclusion(JsonInclude.Include.NON_NULL);

                Comanda updatedComanda = this.mapper.updateValue(existingComanda, comanda);

                this.ComandaRep.save(updatedComanda);
            } catch(JsonMappingException jme) {
                System.out.println("Erro na desserialização!");
            }
            return "Comanda atualizada via patch";
        }
        return "Erro na atualização da comanda via patch";
    }
}
