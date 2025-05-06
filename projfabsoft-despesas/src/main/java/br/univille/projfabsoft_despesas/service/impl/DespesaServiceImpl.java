package br.univille.projfabsoft_despesas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft_despesas.entity.Despesa;
import br.univille.projfabsoft_despesas.repository.DespesaRepository;
import br.univille.projfabsoft_despesas.service.DespesaService;

@Service
public class DespesaServiceImpl implements DespesaService {

    @Autowired
    private DespesaRepository repository;

    @Override
    public Despesa save(Despesa despesa) {
        return repository.save(despesa);
    }

    @Override
    public List<Despesa> getAll() {
        return repository.findAll();
    }

    @Override
    public Despesa getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}