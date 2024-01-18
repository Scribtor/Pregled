package com.gunsh.coffeeshop.service;

import com.gunsh.coffeeshop.model.Barman;
import com.gunsh.coffeeshop.repository.BarmanRepository;

import java.util.List;

public class BarmanService {

    private final BarmanRepository barmanRepository;

    public BarmanService(BarmanRepository barmanRepository) {
        this.barmanRepository = barmanRepository;
    }

    public void hireBartender(Barman barman) {
        barmanRepository.save(barman);
    }
    
    public List<Barman> getAllBarman() {
        return barmanRepository.findAll();
    }
}
