package com.ericfr1tzenvalle.exercise2.model;

public class FactoryCaminhao implements FactoryTransporte {
    @Override
    public Transporte criarTransporte() {
        return new Caminhao();
    }
}
