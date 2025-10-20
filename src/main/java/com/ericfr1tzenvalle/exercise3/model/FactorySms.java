package com.ericfr1tzenvalle.exercise3.model;

public class FactorySms implements FactoryNotificacao {
    @Override
    public Notificacao criarNotificacao() {
        return new Sms();
    }
}
