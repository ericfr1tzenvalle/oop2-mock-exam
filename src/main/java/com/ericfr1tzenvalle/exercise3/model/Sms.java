package com.ericfr1tzenvalle.exercise3.model;

import com.ericfr1tzenvalle.exercise1.model.Subject;

public class Sms implements Notificacao{
    Subject subject;
    @Override
    public void enviar(String mensagem) {
        System.out.println("Enviando SMS..." + mensagem);
    }

    @Override
    public void update() {
        if(subject !=null){
            if(subject instanceof Pedido pedido){
                StatusPedido status = pedido.getStatus();
                System.out.println("SMS Notification - Atualização de Pedido");
                enviar("O status do seu pedido [" + pedido.getId() + "] foi atualizado para: " + pedido.getStatus());
            }
        }
    }

    @Override
    public void setSubject(Subject s) {
        this.subject = s;
    }


    @Override
    public String toString() {
        return "SMS Notification";
    }
}
