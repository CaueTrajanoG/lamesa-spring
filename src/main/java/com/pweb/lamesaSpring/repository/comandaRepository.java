package com.pweb.lamesaSpring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pweb.lamesaSpring.model.Comanda;

@Repository
public interface  comandaRepository extends JpaRepository<Comanda, Long>{
    // O Spring gera o SQL: SELECT * FROM comanda WHERE numero = ?
    Optional<Comanda> findByNumero(Long numero);
    
}
