package com.pweb.lamesaSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pweb.lamesaSpring.model.Comanda;

@Repository
public interface  comandaRepository extends JpaRepository<Comanda, Long>{

    
}
