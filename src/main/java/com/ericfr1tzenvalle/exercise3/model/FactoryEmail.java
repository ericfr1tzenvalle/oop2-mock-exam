package com.ericfr1tzenvalle.exercise3.model;

public class FactoryEmail implements FactoryNotificacao {
    @Override
    public Notificacao criarNotificacao() {
        return new Email();
    }
}
