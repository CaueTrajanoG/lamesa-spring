package com.pweb.lamesaSpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Comanda {       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private Integer produtos;

    public Comanda(Long id, int numero, Integer produtos) {
        this.id = id;
        this.numero = numero;
        this.produtos = produtos;
    }
    public Comanda() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public Integer getProdutos() {
        return produtos;
    }
    public void setProdutos(Integer produtos) {
        this.produtos = produtos;
    }

    
}

