package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barista;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public interface BaristaRepository {

    void save(Barista barista);
    List<Barista> findAll();
}
