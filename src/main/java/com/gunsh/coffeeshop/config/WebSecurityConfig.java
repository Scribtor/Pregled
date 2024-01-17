package com.gunsh.coffeeshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gunsh.coffeeshop.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomUserDetailsService userDetailsService;

    public WebSecurityConfig(CustomUserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/admin/**").hasRole("admin")
                .antMatchers("/home").authenticated()
                .antMatchers("/error").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/**").hasRole("USER")
            .and()
            .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .permitAll()
            .and()
            .exceptionHandling()
                .accessDeniedPage("/error")
            .and()
            .csrf().disable() // Disable CSRF for simplicity, but don't do this in production
            .logout()
            .logoutUrl("/logout") // Specify the URL for logout
            .logoutSuccessUrl("/") // Redirect to login page after logout
            .invalidateHttpSession(true)
            .deleteCookies("JSESSIONID")
            .and()
            .sessionManagement().maximumSessions(1).expiredUrl("/login?expired"); 
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // NoOpPasswordEncoder: Passwords are stored in plain text
        return NoOpPasswordEncoder.getInstance();
    }
}

