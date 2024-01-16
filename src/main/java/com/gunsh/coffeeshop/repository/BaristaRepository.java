package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barista;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository

public interface BaristaRepository {

    void save(Barista barista);

    Barista findById(String name);

    List<Barista> findAll();

    void update(Barista barista);

    void delete(String name);
}
