package com.bank.manager.controler;

import com.bank.manager.dto.AgenciaRequestDTO;
import com.bank.manager.model.Agencia;
import com.bank.manager.service.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agencia")
public class AgenciaController { //recebe requisições HTTP, Chama o Service e Retorna Status HTTP.
    @Autowired
    private AgenciaService agenciaService;
    @PostMapping //CRIA DADOS
    public ResponseEntity<String> add(@RequestBody Agencia agencia){
        agenciaService.add(agencia);
        return ResponseEntity.status(201).build();   //201 = CRIADO
    }
    @GetMapping //RETORNA DADOS
    public ResponseEntity<List <Agencia>> findAll(){
        List <Agencia> agencias = agenciaService.findAll();
        return ResponseEntity.ok(agencias);
    }
    @DeleteMapping("/{id}") //DELETA DADOS
    public ResponseEntity<Long> delete(@PathVariable Long id){
        if(agenciaService !=null){
            agenciaService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}") //ATUALIZA DADOS
    public ResponseEntity <String> update(@PathVariable Long id, @RequestBody AgenciaRequestDTO agencia){



        if (agenciaService != null) {
            agenciaService.update(id, agencia);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
    @GetMapping("/{id}")
    public ResponseEntity<Agencia> getById (@PathVariable Long id){
        Agencia agencia = agenciaService.getById(id);

        if(agencia != null){
            return ResponseEntity.ok(agencia);
        }

        return ResponseEntity.notFound().build();
    }

}
