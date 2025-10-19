package com.ericfr1tzenvalle.exercise2.model;

public class Navio implements Transporte{
    @Override
    public double calcularTempoEntrega(double distanciaKm) {
        return distanciaKm/ 30.0 + 24;
    }

    @Override
    public double calcularCusto(double distanciaKm) {
        return 0.9 * distanciaKm + 800;
    }
    @Override
    public void entregar(String destino){
        System.out.println("Carga enviada por Navio para " + destino + ". Rota Maritíma");;
    }
}
