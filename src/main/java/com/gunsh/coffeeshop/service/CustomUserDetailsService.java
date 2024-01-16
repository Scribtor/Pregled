package com.gunsh.coffeeshop.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	private final String USERS_FILE_PATH = "src/data/users.txt";

	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            List<String> lines = Files.readAllLines(Paths.get(USERS_FILE_PATH));

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3 && parts[0].equals(username)) {
                    String storedUsername = parts[0];
                    String storedPassword = parts[1];
                    String role = parts[2].trim();  // Assuming single role

                    // Create a UserDetails object with plain-text password
                    return org.springframework.security.core.userdetails.User
                            .withUsername(storedUsername)
                            .password(storedPassword)
                            .roles(role)
                            .build();
                }
            }

            throw new UsernameNotFoundException("User not found with username: " + username);
        } catch (IOException e) {
            throw new RuntimeException("Error reading user file", e);
        }
    }
}
