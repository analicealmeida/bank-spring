package com.bank.manager.studies;

import com.bank.manager.model.Cliente;

import java.util.ArrayList;
import java.util.List;

public class TesteStreamEMap {

    public static void main(String[] args) {

        Cliente c1 = new Cliente();
        c1.setNome("Maria");
        Cliente c2 = new Cliente();
        c2.setNome("Cristina");
        Cliente c3 = new Cliente();
        c3.setNome("Patricia");
        Cliente c4 = new Cliente();
        c4.setNome("Joana");


        List<Cliente> lista = List.of(c1, c2, c3);

        List<String> nomes =
                lista.stream()
                        .map(cliente -> cliente.getNome())
                        .toList();

        System.out.println(nomes);




    }
}
