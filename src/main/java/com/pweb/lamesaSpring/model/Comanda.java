package com.pweb.lamesaSpring.model;

import java.time.OffsetDateTime;
import java.util.List;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.pweb.lamesaSpring.config.JsonbConverter;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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

    @Column(name= "products", columnDefinition="jsonb")
    @JdbcTypeCode(SqlTypes.JSON)
    @Convert(converter = JsonbConverter.class)
    private List<Produto> produtos;

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
    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public boolean isAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    
}

