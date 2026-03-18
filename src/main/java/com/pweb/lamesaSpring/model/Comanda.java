package com.pweb.lamesaSpring.model;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "comandas", schema = "public")
public class Comanda {       
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "numero")
    private int numero;

    @Column(name= "aberta")
    private boolean aberta;

    @Column(name = "created_at",insertable = false,updatable = false)
    private OffsetDateTime createdat;

    public OffsetDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(OffsetDateTime createdat) {
        this.createdat = createdat;
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
    public boolean isAberta() {
        return aberta;
    }
    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }    
}

