package com.gunsh.coffeeshop.service;

import com.gunsh.coffeeshop.model.Barista;
import com.gunsh.coffeeshop.repository.BaristaRepository;

import java.util.List;

public class BaristaService {

    private final BaristaRepository baristaRepository;

    public BaristaService(BaristaRepository baristaRepository) {
        this.baristaRepository = baristaRepository;
    }

    public void hireBarista(Barista barista) {
        baristaRepository.save(barista);
    }

    public Barista getBaristaByName(String name) {
        return baristaRepository.findById(name);
    }

    public List<Barista> getAllBaristas() {
        return baristaRepository.findAll();
    }

    public void updateBarista(Barista barista) {
        baristaRepository.update(barista);
    }

    public void fireBarista(String name) {
        baristaRepository.delete(name);
    }
}
