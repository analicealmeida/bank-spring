package com.bank.manager;

import com.bank.manager.controler.ClienteController;
import com.bank.manager.model.Cliente;
import com.bank.manager.repository.ClienteRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class ManagerApplication { //RUN

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}




}
