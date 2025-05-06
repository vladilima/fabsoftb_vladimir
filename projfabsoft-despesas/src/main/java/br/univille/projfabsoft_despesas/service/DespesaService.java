package br.univille.projfabsoft_despesas.service;

import java.util.List;

import br.univille.projfabsoft_despesas.entity.Despesa;

public interface DespesaService {
    Despesa save(Despesa despesa);
    List<Despesa> getAll();
    Despesa getById(long id);
    void delete(long id);
}