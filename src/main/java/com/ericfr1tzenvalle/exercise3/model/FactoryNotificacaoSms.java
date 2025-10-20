package com.ericfr1tzenvalle.exercise3.model;

public class FactoryNotificacaoSms implements FactoryNotificacao {
    @Override
    public Notificacao criarNotificacao() {
        return new Sms();
    }
}
