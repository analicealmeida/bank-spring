package com.bank.manager.controler;

import com.bank.manager.model.Agencia;
import com.bank.manager.model.Funcionario;
import com.bank.manager.service.AgenciaService;
import com.bank.manager.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {  //recebe requisições HTTP, Chama o Service e Retorna Status HTTP.
    @Autowired
    private FuncionarioService funcionarioService;
    @PostMapping //CRIA DADOS
    public ResponseEntity<String> add(@RequestBody Funcionario funcionario){
        funcionarioService.add(funcionario);
        return ResponseEntity.status(201).build();
    }
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List<Funcionario>> findAll(){
        List <Funcionario> funcionarios = funcionarioService.findAll();
        return ResponseEntity.ok(funcionarios);
    }
    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id){
        if (funcionarioService.getById(id).isPresent()) {
            funcionarioService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity <String> update(@PathVariable Long id, @RequestBody Funcionario funcionario){
        if (funcionarioService.getById(id).isPresent()) {
            funcionarioService.update(id, funcionario);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> getById (@PathVariable Long id){
        return funcionarioService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
