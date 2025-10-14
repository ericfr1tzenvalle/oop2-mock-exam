package com.ericfr1tzenvalle.exercise1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Mesa {
    private int numero;
    private Conta conta;

    public Mesa(int numero, Conta conta) {
        this.numero = numero;
        this.conta = conta;
    }



   public void realizarPedido(List<Prato> p, Garcom g){
       g.realizarPedido(p, this);
   }


}
