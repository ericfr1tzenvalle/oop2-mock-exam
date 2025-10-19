package com.ericfr1tzenvalle.exercise2.model;

public class Logistica {
    public static void run(){
        FactoryTransporte factoryCaminhao = new FactoryCaminhao();
        Transporte caminhao = factoryCaminhao.criarTransporte();
        double distancia1 = 150.0; // Distância em km
        System.out.println("Caminhão:");
        System.out.println("Tempo de entrega: " + caminhao.calcularTempoEntrega(distancia1) + " horas");
        System.out.println("Custo: R$ " + caminhao.calcularCusto(distancia1));
        caminhao.entregar("São Paulo");

        System.out.println();

        FactoryTransporte factoryDrone = new FactoryDrone();
        Transporte drone = factoryDrone.criarTransporte();
        double distancia2 = 20.0; // Distância em km
        System.out.println("Drone:");
        System.out.println("Tempo de entrega: " + drone.calcularTempoEntrega(distancia2) + " horas");
        System.out.println("Custo: R$ " + drone.calcularCusto(distancia2));
        drone.entregar("Rio de Janeiro");

        System.out.println();

        FactoryTransporte factoryNavio = new FactoryNavio();
        Transporte navio = factoryNavio.criarTransporte();
        double distancia3 = 500.0; // Distância em km
        System.out.println("Navio:");
        System.out.println("Tempo de entrega: " + navio.calcularTempoEntrega(distancia3) + " horas");
        System.out.println("Custo: R$ " + navio.calcularCusto(distancia3));
        navio.entregar("Salvador");



    }
}
