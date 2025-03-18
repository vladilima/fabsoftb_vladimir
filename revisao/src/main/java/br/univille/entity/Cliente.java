package br.univille.entity;

import java.util.ArrayList;

public class Cliente {
    //variável ou atributo
    private long id; //ctrl ponto
    private String nome;
    private String endereco;

    private Cidade cidade;
    private ArrayList listaPokemon = new ArrayList();

    public ArrayList getListaPokemon() {
        return listaPokemon;
    }
    public void setListaPokemon(ArrayList listaPokemon) {
        this.listaPokemon = listaPokemon;
    }

    //construtor = mesmo nome da classe e sem um retorno
    // func = inicializar atributos
    // obrigar a passagem de valores
    public Cliente(String nome) {
        this.nome = nome;
    }
    //polimorfismo - varias formas de existir a mesma coisa
    public Cliente(){
    
    }
    //metodo
    //sobre-escrita de metodo ( meu pai me deu pronto e eu reescrevi)
    @Override
    public String toString(){
        return getNome();
    }

    
    // GET-SET ID
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    
    // GET-SET NOME
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
    // GET-SET ENDEREÇO
    public String getEndereco() {
        return endereco;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // GET-SET CIDADE
    public Cidade getCidade() {
        return cidade;
    }
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
    // encapsulamento = responder a implementacao dentro do objeto
}