package br.univille.projfabsoft_despesas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.projfabsoft_despesas.service.NotificacaoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.univille.projfabsoft_despesas.entity.Notificacao;


@RestController
@RequestMapping("/api/v1/notificacoes")
public class NotificacaoController {

    @Autowired
    private NotificacaoService service;
    

    @GetMapping
    public ResponseEntity<List<Notificacao>> getNotificacoes(){
        var listaNotifs = service.getAll();

        return new ResponseEntity<List<Notificacao>>(listaNotifs, HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Notificacao> postNotificacao(@RequestBody Notificacao notificacao) {
        if (notificacao == null) {
            return ResponseEntity.badRequest().build();
        }
        if (notificacao.getId() == 0) {
            service.save(notificacao);
            return new ResponseEntity<Notificacao>(notificacao, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notificacao> putNotificacao(@PathVariable("id") Long id, @RequestBody Notificacao notificacao) {
        var notifExistente = service.getById(id);
        if (notifExistente == null) {
            return ResponseEntity.notFound().build();
        }
        notificacao.setId(id); // Garante que o ID não será alterado
        service.save(notificacao);
        return new ResponseEntity<>(notificacao, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotificacao(@PathVariable("id") Long id) {
        var notifExistente = service.getById(id);
        if (notifExistente == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
