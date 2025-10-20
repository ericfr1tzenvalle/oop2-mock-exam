# Simulado

Este repositório contém a resolução de **dois exercícios** focados na aplicação de **Padrões de Projeto (Design Patterns)** referentes ao Simulado da Disciplina de POO II.
Cada exercício possui sua própria pasta exercise e um `README.md` detalhado (incluindo diagrama UML).
> ⚠️ Observação: O repositório também conta com um **exercíco bônus** que aborda (Observer, Factory e Singleton) juntos.


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

---

## Exercício 3 – Sistema de Notificações
**Padrões Utilizados:** Observer, Factory, Singleton

**Objetivo:**  
Criar um sistema de notificações que possa enviar mensagens por diferentes canais (`Email`, `Push`, `Sms`) de forma flexível e desacoplada.  
O sistema também mantém o histórico de pedidos e notifica automaticamente os interessados sobre mudanças de status.

**Papel das classes:**  
- `Pedido` = Subject (Observer)  
- `Gerenciador` = Singleton responsável por gerenciar as notificações  
- `Notificacao` = Interface de notificação  
- `Email`, `Push`, `Sms` = Implementações concretas de `Notificacao`  
- `FactoryNotificacao` / `FactoryEmail` / `FactoryPush` / `FactorySms` = Criação desacoplada de notificações (Factory Method)

**Fluxo resumido:**  
1. Um `Pedido` é criado e registrado no `Gerenciador`.  
2. Quando o status do pedido muda, todos os observadores (notificações) são acionados automaticamente.  
3. O `Gerenciador` garante que apenas uma instância do sistema de notificações exista (Singleton).  
4. Novos tipos de notificações podem ser adicionados sem alterar o código existente (Factory Method).

> ⚠️ Observação: a pasta `exercise3/` contém um `README.md` com explicação detalhada do padrão, exemplos de uso e o diagrama UML em Mermaid.
---
