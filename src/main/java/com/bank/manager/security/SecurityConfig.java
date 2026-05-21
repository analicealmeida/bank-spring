package com.bank.manager.security;
import com.bank.manager.model.Cliente;
import com.bank.manager.repository.ClienteRepository;
import com.bank.manager.service.impl.ClienteServiceImpl;
import jakarta.websocket.ClientEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;


import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@EnableMethodSecurity
@Configuration
public class SecurityConfig { //regras (quem pode acessar o quê)

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, JwtFilter jwtFilter) throws Exception {

        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                /*.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cliente/login-user").permitAll()
                        .requestMatchers("/funcionario/login-user").permitAll()
                        .requestMatchers(HttpMethod.GET, "/cliente/**").hasAuthority("FUNCIONARIO")
                        .requestMatchers(HttpMethod.GET, "/funcionario").hasAuthority("FUNCIONARIO") //novo*********
                        .requestMatchers(HttpMethod.GET, "/cliente/getUserLogin").hasAuthority("CLIENTE") //novo********* //TODO TEM QUE PERMITIR
                        .requestMatchers(HttpMethod.POST, "/cliente").permitAll() //novo******
                        .requestMatchers(HttpMethod.POST, "/funcionario").permitAll() //novo*********
                        .requestMatchers(HttpMethod.PUT, "/funcionario/**").hasAuthority("FUNCIONARIO") //novo*********
                        .requestMatchers(HttpMethod.PUT, "/cliente/**").hasAuthority("CLIENTE") //novo*********
                        .requestMatchers(HttpMethod.DELETE, "/funcionario/**").hasAuthority("FUNCIONARIO") //novo*********
                        .requestMatchers(HttpMethod.DELETE, "/cliente/**").hasAuthority("ADMIN") //novo*********
                        .anyRequest().authenticated()
                )*/
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/cliente/login-user", "/funcionario/login-user", "/funcionario/change-password/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/cliente").permitAll()
                        .requestMatchers(HttpMethod.POST, "/funcionario").permitAll()
                        .requestMatchers(HttpMethod.POST, "/funcionario/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(CustomUserDetailsService service) {
        return service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}