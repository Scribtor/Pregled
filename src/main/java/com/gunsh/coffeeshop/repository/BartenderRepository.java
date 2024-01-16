package com.gunsh.coffeeshop.repository;

import com.gunsh.coffeeshop.model.Bartender;

import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface BartenderRepository {

    void save(Bartender bartender);

    Bartender findById(String name);

    List<Bartender> findAll();

    void update(Bartender bartender);

    void delete(String name);
}
