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

import br.univille.projfabsoft_despesas.entity.GrupoFamiliar;
import br.univille.projfabsoft_despesas.service.DespesaService;
import br.univille.projfabsoft_despesas.service.GrupoFamiliarService;

@RestController
@RequestMapping("/api/v1/grupos-familiares")
public class GrupoFamiliarController {

    @Autowired
    private GrupoFamiliarService service;
    @Autowired
    private DespesaService despesaService;

    @GetMapping
    public ResponseEntity<List<GrupoFamiliar>> getGruposFamiliares() {
        var listaGruposFamiliares = service.getAll();
        return new ResponseEntity<>(listaGruposFamiliares, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GrupoFamiliar> postGrupoFamiliar(@RequestBody GrupoFamiliar grupoFamiliar) {
        if (grupoFamiliar == null) {
            return ResponseEntity.badRequest().build();
        }
        if (grupoFamiliar.getId() == 0) {
            service.save(grupoFamiliar);
            return new ResponseEntity<>(grupoFamiliar, HttpStatus.CREATED);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoFamiliar> putGrupoFamiliar(@PathVariable("id") Long id, @RequestBody GrupoFamiliar grupoFamiliar) {
        var grupoFamiliarExistente = service.getById(id);
        if (grupoFamiliarExistente == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the contents of the existing list instead of replacing it
        grupoFamiliarExistente.getDespesas().clear();
        grupoFamiliarExistente.getDespesas().addAll(grupoFamiliar.getDespesas());

        grupoFamiliarExistente.setNome(grupoFamiliar.getNome());
        grupoFamiliarExistente.setUsuarios(grupoFamiliar.getUsuarios());

        service.save(grupoFamiliarExistente);
        return new ResponseEntity<>(grupoFamiliarExistente, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGrupoFamiliar(@PathVariable("id") Long id) {
        var grupoFamiliarExistente = service.getById(id);
        if (grupoFamiliarExistente == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")	
    public ResponseEntity<GrupoFamiliar> getGrupoFamiliarId(@PathVariable Long id){
        var grupoFamiliar = service.getById(id);

        return new ResponseEntity<GrupoFamiliar>(grupoFamiliar, HttpStatus.OK);
    }
}