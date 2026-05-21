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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

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
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List<Cliente>> findAll(){
        List <Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        clienteService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Cliente cliente) {

        clienteService.update(id, cliente);
        return ResponseEntity.ok().build();

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getById/{id}")
    public Cliente getById(@PathVariable Long id) {
        return clienteService.getById(id);
    }


    @PostMapping("/login-user") //todos terão acesso
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO){
        //Cliente cliente = clienteService.login(loginDTO);
        //return ResponseEntity.ok(cliente);
        return ResponseEntity.ok(clienteService.login(loginDTO));

    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllNames")
    public ResponseEntity<List <String>> getAllNames(){
        return ResponseEntity.ok(clienteService.getAllNames());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getByCpf/{cpf}")
    public Cliente findByCpf(@PathVariable String cpf){
        return clienteService.findByCpf(cpf);

    }
    @GetMapping("/getUserLogin") //todos terão acesso
    public ResponseEntity<Cliente> getUserLogin (){
       return ResponseEntity.ok(clienteService.getUser());
}

}

