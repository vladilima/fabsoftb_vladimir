package br.univille.projfabsoft_despesas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projfabsoft_despesas.entity.GrupoFamiliar;
import br.univille.projfabsoft_despesas.repository.GrupoFamiliarRepository;
import br.univille.projfabsoft_despesas.service.GrupoFamiliarService;

@Service
public class GrupoFamiliarServiceImpl implements GrupoFamiliarService {

    @Autowired
    private GrupoFamiliarRepository repository;

    @Override
    public GrupoFamiliar save(GrupoFamiliar grupoFamiliar) {
        return repository.save(grupoFamiliar);
    }

    @Override
    public List<GrupoFamiliar> getAll() {
        return repository.findAll();
    }

    @Override
    public GrupoFamiliar getById(long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}