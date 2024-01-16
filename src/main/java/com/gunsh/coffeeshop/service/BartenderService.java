package com.gunsh.coffeeshop.service;

import com.gunsh.coffeeshop.model.Bartender;
import com.gunsh.coffeeshop.repository.BartenderRepository;

import java.util.List;

public class BartenderService {

    private final BartenderRepository bartenderRepository;

    public BartenderService(BartenderRepository bartenderRepository) {
        this.bartenderRepository = bartenderRepository;
    }

    public void hireBartender(Bartender bartender) {
        bartenderRepository.save(bartender);
    }

    public Bartender getBartenderByName(String name) {
        return bartenderRepository.findById(name);
    }

    public List<Bartender> getAllBartenders() {
        return bartenderRepository.findAll();
    }

    public void updateBartender(Bartender bartender) {
        bartenderRepository.update(bartender);
    }

    public void fireBartender(String name) {
        bartenderRepository.delete(name);
    }
}
