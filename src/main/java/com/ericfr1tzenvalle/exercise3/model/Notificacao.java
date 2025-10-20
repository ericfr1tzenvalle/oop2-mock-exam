package com.ericfr1tzenvalle.exercise3.model;

import com.ericfr1tzenvalle.exercise1.model.Observer;

public interface Notificacao extends Observer {

    default void enviar(String mensagem){
        System.out.println("Enviando notificação: " + mensagem);
    }
    void update();
}
