package com.bank.manager.controler;

import com.bank.manager.dto.ContaRequestDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.model.Conta;
import com.bank.manager.service.AgenciaService;
import com.bank.manager.service.ClienteService;
import com.bank.manager.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conta")
public class ContaController {  //recebe requisições HTTP, Chama o Service e Retorna Status HTTP.
    @Autowired
    private ContaService contaService;

    @PostMapping //CRIA DADOS
    public ResponseEntity<String> add(@RequestBody ContaRequestDTO contaDTO){

        contaService.add(contaDTO);
        return ResponseEntity.status(201).build();
    }
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List<Conta>> findAll(){
        List <Conta> contas = contaService.findAll();
        return ResponseEntity.ok(contas);
    }
    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id){
        if (contaService.getById(id).isPresent()) {
            contaService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity <String> update(@PathVariable Long id, @RequestBody ContaRequestDTO conta){
        if (contaService.getById(id).isPresent()) {
            contaService.update(id, conta);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Conta> getById (@PathVariable Long id){
        return contaService.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/contasDeCliente/{cpf}")
    public ResponseEntity<List<Conta>> findByClienteCpf(@PathVariable String cpf){
        return ResponseEntity.ok(contaService.findByClienteCpf(cpf));
    }
}
