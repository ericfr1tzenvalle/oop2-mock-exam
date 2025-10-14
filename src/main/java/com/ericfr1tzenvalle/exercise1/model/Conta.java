package com.ericfr1tzenvalle.exercise1.model;

public class Conta implements Observer {
    private double total;
    private Subject subject;

    @Override
    public void setSubject(Subject s) {
        this.subject = s;

    }

    @Override
    public void update() {
        if(subject instanceof Pedido pedido){
            if(pedido.getUpdate().equals(StatusPedido.ENTREGUE)) {
                total += pedido.getPrato().getPreco();
                System.out.println("Conta atualizada: R$ " + total);
            }
        }

    }
}
