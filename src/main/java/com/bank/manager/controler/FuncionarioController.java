package com.bank.manager.controler;

import com.bank.manager.dto.ChangePasswordDTO;
import com.bank.manager.dto.LoginDTO;

import com.bank.manager.model.Funcionario;

import com.bank.manager.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {  //recebe requisições HTTP, Chama o Service e Retorna Status HTTP.
    @Autowired
    private FuncionarioService funcionarioService;

    @PostMapping //CRIA DADOS //cadastro liberado para todos
    public ResponseEntity<String> add(@RequestBody Funcionario funcionario) {
        funcionarioService.add(funcionario);
        return ResponseEntity.status(201).build();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE', 'DIRETOR')")
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List<Funcionario>> findAll() {
        List<Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id) {
        if (funcionarioService.getById(id).isPresent()) {
            funcionarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        if (funcionarioService.getById(id).isPresent()) {
            funcionarioService.update(id, funcionario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'GERENTE', 'DIRETOR')")
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById(@PathVariable Long id) {
        return funcionarioService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login-user") //login liberado para todos
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        return ResponseEntity.ok(funcionarioService.login(loginDTO));
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String admin() {
        return "ok";
    }
    @PreAuthorize("hasRole('GERENTE')")
    @GetMapping("/gerente")
    public String gerente() {
        return "ok";
    }
    @PreAuthorize("hasRole('DIRETOR')")
    @GetMapping("/diretor")
    public String diretor() {
        return "ok";
    }
    @PreAuthorize("hasRole('ANALISTA')")
    @GetMapping("/analista")
    public String analista() {
        return "ok";
    }

    //@PreAuthorize("permitAll()")
    @PostMapping("/password/change/{cpf}")
    //@PreAuthorize("hasAnyRole('ADMIN', 'GERENTE', 'DIRETOR')")
    public ResponseEntity<Void> changePassword(
            @PathVariable String cpf,
            @RequestBody ChangePasswordDTO request) {

        funcionarioService.changePassword(cpf, request.newPassword());
        return ResponseEntity.ok().build();
    }
}
