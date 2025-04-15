package br.univille.projfabsoft_despesas.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Despesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000)
    private String descricao;
    private Double valor;
    private LocalDate dataVencimento;
    private List<Usuario> usuariosResponsaveis = new ArrayList<>();
    // TIPO DE DESPESA (CONTA, ALIMENTACAO, LAZER, SAUDE, TRANSPORTE, OUTROS)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public List<Usuario> getUsuariosResponsaveis() {
        return usuariosResponsaveis;
    }

    public void setUsuariosResponsaveis(List<Usuario> usuariosResponsaveis) {
        this.usuariosResponsaveis = usuariosResponsaveis;
    }
}