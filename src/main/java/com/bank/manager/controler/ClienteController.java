package com.bank.manager.controler;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.dto.ClienteRequestDTO;
import com.bank.manager.dto.LoginDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Cliente;
import com.bank.manager.service.AgenciaService;
import com.bank.manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController { //recebe requisições HTTP, Chama o Service e Retorna Status HTTP.
    @Autowired
    private ClienteService clienteService;

    @PostMapping //CRIA DADOS
    public ResponseEntity<String> add(@RequestBody Cliente cliente){
        clienteService.add(cliente);
        return ResponseEntity.status(201).build();
    }
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List<Cliente>> findAll(){
        List <Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente) {

        clienteService.update(id, cliente);
        return ResponseEntity.ok().build();

    }

    @GetMapping("/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.getById(id);
    }


    @PostMapping("/login-user")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        //Cliente cliente = clienteService.login(loginDTO);
        //return ResponseEntity.ok(cliente);
        return ResponseEntity.ok(clienteService.login(loginDTO));

    }
}

