package com.ericfr1tzenvalle.exercise2.model;

public class FactoryDrone implements FactoryTransporte{
    @Override
    public Transporte criarTransporte() {
        return new Drone();
    }
}
