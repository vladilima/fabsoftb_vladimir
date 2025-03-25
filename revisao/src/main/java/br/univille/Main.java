package br.univille;

import br.univille.entity.Cidade;
import br.univille.entity.Cliente;
import br.univille.entity.Pokemon;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");

        Cidade pallet = new Cidade();
        pallet.setNome("Pallet");
        pallet.setEstado("Kanto");

        Pokemon pikachu = new Pokemon("Pikachu");
        Pokemon porygon = new Pokemon("Porygon");

        Cliente zezinho = new Cliente("Ash");
        zezinho.setNome("Ash Ketchum");
        zezinho.setCidade(pallet);

        zezinho.getListaPokemon().add(pikachu);
        zezinho.getListaPokemon().add(porygon);


        for (var umPokemon : zezinho.getListaPokemon()) {
            System.out.println(umPokemon);
        }

        System.out.println(zezinho);
    }
}