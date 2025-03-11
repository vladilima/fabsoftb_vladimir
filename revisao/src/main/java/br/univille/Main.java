package br.univille;

    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");

            Cliente zezinho = new Cliente();
            zezinho.setNome("zezinho sila");
            //variável -> é driada e moldada da forma desejada
            //Sinal = -> reia um referência para o objeto
            //tipo primitivo - ex int idade = 20
            Cliente mariazinha = new Cliente();
            mariazinha.setNome("Mariazinha");
        }
    }