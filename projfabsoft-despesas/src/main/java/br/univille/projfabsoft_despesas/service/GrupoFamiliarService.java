package br.univille.projfabsoft_despesas.service;

import java.util.List;

import br.univille.projfabsoft_despesas.entity.GrupoFamiliar;

public interface GrupoFamiliarService {
    GrupoFamiliar save(GrupoFamiliar grupoFamiliar);
    List<GrupoFamiliar> getAll();
    GrupoFamiliar getById(long id);
    void delete(long id);
}