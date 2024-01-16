package com.gunsh.coffeeshop.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gunsh.coffeeshop.model.CustomUser;

public class UserRepositoryImpl implements UserRepository {

    private static final String FILE_PATH = "src/data/users.txt";

    @Override
    public List<CustomUser> findAll() {
        List<CustomUser> users = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    users.add(new CustomUser(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public Optional<CustomUser> findByUsername(String username) {
        return findAll().stream()
                .filter(user -> user.getUsername().equals(username))
                .findFirst();
    }

    @Override
    public void save(CustomUser user) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) {
            writer.write(user.getUsername() + "," + user.getPassword() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

