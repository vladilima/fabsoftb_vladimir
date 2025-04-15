package br.univille.projfabsoft_despesas.entity;

import java.util.ArrayList;
import java.util.List;

public class GrupoFamiliar {
    private long id;
    private String nome;
    private List<Usuario> usuarios = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}