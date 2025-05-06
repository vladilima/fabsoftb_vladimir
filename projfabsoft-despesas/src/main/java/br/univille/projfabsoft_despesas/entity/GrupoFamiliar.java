package br.univille.projfabsoft_despesas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GrupoFamiliar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    // @OneToMany
    // private List<Usuario> usuarios = new ArrayList<>();

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

    // public List<Usuario> getUsuarios() {
    //     return usuarios;
    // }

    // public void setUsuarios(List<Usuario> usuarios) {
    //     this.usuarios = usuarios;
    // }
}