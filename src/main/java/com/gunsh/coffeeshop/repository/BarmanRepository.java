package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Barman;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BarmanRepository {

    void save(Barman bartender);

    List<Barman> findAll();
}
