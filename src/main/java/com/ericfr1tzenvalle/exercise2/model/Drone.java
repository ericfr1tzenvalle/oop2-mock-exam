package com.ericfr1tzenvalle.exercise2.model;

public class Drone implements Transporte {
    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        return distanciaKm / 100;
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return 5.0 * distanciaKm;
    }
    @Override
    public void entregar(String destino){
        System.out.println("Carga enviada por Drone para " + destino + ". Rota aérea direta.");
    }
}
