package com.ericfr1tzenvalle.exercise3.model;

public class FactoryNotificacaoEmail implements FactoryNotificacao {
    @Override
    public Notificacao criarNotificacao() {
        return new Email();
    }
}
