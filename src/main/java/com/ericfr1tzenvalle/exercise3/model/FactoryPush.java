package com.ericfr1tzenvalle.exercise3.model;

public class FactoryPush implements FactoryNotificacao {
    @Override
    public Notificacao criarNotificacao() {
        return new Push();
    }
}
