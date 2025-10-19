package com.ericfr1tzenvalle.exercise2.model;

public class Caminhao implements Transporte {
    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        return distanciaKm / 60.0;
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return 1.8 * distanciaKm + 200;
    }
    @Override
    public void entregar(String destino){
        System.out.println("Carga enviada por Caminhão para " + destino + ". Rota terrestre.");;
    }
}
