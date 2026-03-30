package com.bank.manager.controler;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.dto.ClienteRequestDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Cliente;
import com.bank.manager.service.AgenciaService;
import com.bank.manager.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/cliente") //TODO VALIDAR DE STATUS
public class ClienteController {
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
        if (clienteService.getById(id).isPresent()) {
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity <String> update(@PathVariable Long id, @RequestBody Cliente cliente){
        if (clienteService.getById(id).isPresent()) {
            clienteService.update(id, cliente);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getById (@PathVariable Long id){
        return clienteService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    }

