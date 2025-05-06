package br.univille.projfabsoft_despesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft_despesas.entity.Despesa;
import br.univille.projfabsoft_despesas.service.DespesaService;

@RestController
@RequestMapping("/api/v1/despesas")
public class DespesaController {

    @Autowired
    private DespesaService service;

    @GetMapping
    public ResponseEntity<List<Despesa>> getDespesas() {
        var listaDespesas = service.getAll();
        return new ResponseEntity<>(listaDespesas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Despesa> postDespesa(@RequestBody Despesa despesa) {
        if (despesa == null) {
            return ResponseEntity.badRequest().build();
        }
        if (despesa.getId() == 0) {
            service.save(despesa);
            return new ResponseEntity<>(despesa, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Despesa> putDespesa(@PathVariable("id") Long id, @RequestBody Despesa despesa) {
        var despesaExistente = service.getById(id);
        if (despesaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        despesa.setId(id);
        service.save(despesa);
        return new ResponseEntity<>(despesa, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDespesa(@PathVariable("id") Long id) {
        var despesaExistente = service.getById(id);
        if (despesaExistente == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}