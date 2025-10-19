package com.ericfr1tzenvalle.exercise2.model;

public interface Transporte {
    double calcularTempoEntrega(double distanciaKm);
    double calcularCusto(double distanciaKm);
    default void entregar(String destino){
        System.out.println("Carga enviada por " + getClass().getSimpleName() + " para " + destino);
    }
}
