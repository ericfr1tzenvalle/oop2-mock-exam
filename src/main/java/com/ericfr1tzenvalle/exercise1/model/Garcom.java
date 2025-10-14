package com.ericfr1tzenvalle.exercise1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter @Setter
public class Garcom extends Funcionario {
    private Subject subject;
    private Cozinheiro cozinheiro;


    public Garcom(String nome) {
        super(nome);
    }

    @Override
    public void setSubject(Subject s) {
        this.subject = s;

    }

    @Override
    public void update() {
        Pedido pedido = (Pedido) subject;
        if(pedido.getUpdate().equals(StatusPedido.PRONTO)){
            System.out.println("Entregando o pedido...");
            pedido.setStatusPedido(StatusPedido.ENTREGUE);
            System.out.println("Pedido entregue.");
            pedido.notifyObservers();
        }

    }
    public void realizarPedido(List<Prato> pratosPedidos, Mesa mesa){
        for(Prato prato: pratosPedidos){
            Pedido p = new Pedido(prato);
            p.setMesa(mesa);
            p.addObserver(mesa.getConta());
            p.addObserver(this);
            p.setStatusPedido(StatusPedido.AGUARDANDO);
            p.addObserver(getCozinheiro());
            p.notifyObservers();
        }

    }
}
