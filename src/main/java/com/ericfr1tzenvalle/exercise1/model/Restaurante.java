package com.ericfr1tzenvalle.exercise1.model;

import java.util.List;

public interface  Restaurante {
    static void run(){
        System.out.println("Restaurante iniciado");
        Garcom g1 = new Garcom("João");
        g1.setCozinheiro(new Cozinheiro("Cornelios"));
        Mesa mesa = new Mesa(1, new Conta());
        Prato prato = new Prato("Sanduiche com algas", 29.90);
        mesa.realizarPedido(List.of(prato),g1);

    }
}
