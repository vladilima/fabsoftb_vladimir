package br.univille.projfabsoft_despesas.service;

import java.util.List;

import br.univille.projfabsoft_despesas.entity.Notificacao;

public interface NotificacaoService {
    Notificacao save(Notificacao notificacao);
    List<Notificacao> getAll();
    Notificacao getById(long id);
    Notificacao delete(long id);

}
