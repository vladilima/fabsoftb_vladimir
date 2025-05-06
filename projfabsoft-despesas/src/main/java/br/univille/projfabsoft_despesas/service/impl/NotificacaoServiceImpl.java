package br.univille.projfabsoft_despesas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft_despesas.entity.Notificacao;
import br.univille.projfabsoft_despesas.repository.NotificacaoRepository;
import br.univille.projfabsoft_despesas.service.NotificacaoService;

@Service
public class NotificacaoServiceImpl implements NotificacaoService {


    @Autowired
    private NotificacaoRepository repository;

    @Override
    public Notificacao save(Notificacao notificacao) {
        repository.save(notificacao);
        return notificacao;
    }

    @Override
    public List<Notificacao> getAll() {
        return repository.findAll();
    }

    @Override
    public Notificacao getById(long id) {
        var retorno = repository.findById(id);
        if(retorno.isPresent())
            return retorno.get();
        return null;
    }

    @Override
    public Notificacao delete(long id) {
        var notificacao = getById(id);
        if(notificacao != null)
            repository.deleteById(id);
        return notificacao;
    }

}
