# Padrões de Projeto em Java (Simulado)

Este repositório contém a resolução de **dois exercícios** de Programação Orientada a Objetos (POO) em Java, focados na aplicação de **Padrões de Projeto (Design Patterns)**.  
Cada exercício possui sua própria pasta exercise e um `README.md` detalhado (incluindo diagrama UML).

---

## Exercício 1 – Sistema de Pedidos para Restaurante
**Padrão Utilizado:** Observer

**Objetivo:**  
Gerenciar o ciclo de vida dos pedidos em um restaurante, permitindo que `Garcom`, `Cozinheiro` e `Conta` sejam notificados automaticamente sobre mudanças de status (AGUARDANDO → PRONTO → ENTREGUE).

**Papel das classes:**  
- `Pedido` = Subject  
- `Garcom`, `Cozinheiro`, `Conta` = Observers

> ⚠️ Observação: a pasta `exercise1/` contém um `README.md` com explicação detalhada do fluxo, código e o diagrama UML em Mermaid.

---

## Exercício 2 – Sistema de Logística
**Padrão Utilizado:** Factory Method

**Objetivo:**  
Permitir a criação de diferentes tipos de entrega (`Caminhao`, `Navio`, `Drone`) de forma flexível e desacoplada, mantendo o cliente (`Logistica`) independente das implementações concretas.

**Papel das classes:**  
- `Transporte` = Product (interface)  
- `Caminhao`, `Navio`, `Drone` = Concrete Products  
- `FactoryTransporte` = Creator (interface)  
- `FactoryCaminhao`, `FactoryNavio`, `FactoryDrone` = Concrete Creators

**Regras de negócio (implementadas nas classes de transporte):**

- **Caminhão**
  - Tempo: `distanciaKm / 60.0`
  - Custo: `1.8 * distanciaKm + 200`

- **Navio**
  - Tempo: `distanciaKm / 30.0 + 240`
  - Custo: `0.9 * distanciaKm + 800`

- **Drone**
  - Tempo: `distanciaKm / 100.0`
  - Custo: `5.0 * distanciaKm`

> ⚠️ Observação: a pasta `exercise2/` contém um `README.md` com explicação detalhada do padrão, exemplos de uso, e o diagrama UML em Mermaid.

