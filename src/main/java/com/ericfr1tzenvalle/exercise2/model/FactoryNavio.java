package com.ericfr1tzenvalle.exercise2.model;

public class FactoryNavio implements FactoryTransporte {
    @Override
    public Transporte criarTransporte() {
        return new Navio();
    }
}
