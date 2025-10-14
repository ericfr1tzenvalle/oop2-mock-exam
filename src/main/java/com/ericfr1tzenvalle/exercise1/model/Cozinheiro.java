package com.ericfr1tzenvalle.exercise1.model;

public class Cozinheiro extends Funcionario{
    private Subject subject;

    public Cozinheiro(String nome) {
        super(nome);
    }

    @Override
    public void setSubject(Subject s) {
        this.subject = s;

    }

    @Override
    public void update() {
        if(subject instanceof Pedido pedido){
            if(pedido.getUpdate().equals(StatusPedido.AGUARDANDO)){
                System.out.println("Preparando o pedido...");
                pedido.setStatusPedido(StatusPedido.PRONTO);
                System.out.println("Pedido pronto.");
                pedido.notifyObservers();
            }
        }

    }
}
