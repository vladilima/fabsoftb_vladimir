package br.univille.entity;

public class Cidade {
    //variável ou atributo
    private long id; //ctrl ponto
    private String nome;
    private String estado;
    
    //construtor = mesmo nome da classe e sem um retorno
    // func = inicializar atributos
    // obrigar a passagem de valores
    public Cidade(String nome) {
        this.nome = nome;
    }
    //polimorfismo - varias formas de existir a mesma coisa
    public Cidade(){}
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
    
    // GET-SET ESTADO
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    // encapsulamento = responder a implementacao dentro do objeto
}