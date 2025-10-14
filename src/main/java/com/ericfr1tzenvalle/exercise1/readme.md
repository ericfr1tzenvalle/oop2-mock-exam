# Sistema de Gerenciamento de Pedidos - Restaurante

Este exercício implementa um **sistema de gerenciamento de pedidos** para um restaurante, simulando a comunicação entre **garçons**, **cozinheiros** e **mesas** de forma automatizada.  

O sistema foi desenvolvido em **Java**, seguindo os princípios da **Programação Orientada a Objetos** e aplicando o **Padrão de Projeto Observer (GoF)**.

---

## Objetivos
- Gerenciar pedidos realizados pelos clientes de um restaurante.  
- Acompanhar o **ciclo de vida de um pedido**, desde o momento em que é criado até a entrega.  
- Permitir que **diferentes entidades (Garçom, Cozinheiro e Conta)** sejam **notificadas automaticamente** quando o status de um pedido muda.

---

## Fluxo

1. O **Garçom** realiza um pedido para uma **Mesa**, com o status inicial **AGUARDANDO**.
2. O **Cozinheiro**, ao ser notificado, prepara o prato e altera o status para **PRONTO**.
3. O **Garçom** é notificado novamente, entrega o pedido ao cliente e altera o status para **ENTREGUE**.
4. A **Conta** da mesa observa as alterações e atualiza automaticamente o **total a pagar**.

---

## Padrão de Projeto: Observer

### Estrutura
- **Subject (Sujeito observado):** `Pedido`  
- **Observers (Observadores):** `Garcom`, `Cozinheiro`, `Conta`  


---

```mermaid
---
config:
  layout: elk
---
classDiagram
class Conta{
    - double total
    - Subject subject
    + getTotal() double
}
class Cozinheiro{
    - Subject subject
}
class Funcionario{
    <<abstract>>
    - String nome
}
class Garcom{
    - Subject subject
    - Cozinheiro cozinheiro
    + RealizarPedido(List<Prato> pratoPedido, Mesa mesa) void
    + setCozinheiro()void
    + getCozinheiro()Cozinheiro
}
class Mesa{
    - int numero
    - Conta conta
    + realizarPedido(List<Prato> pratoPedido, Garcom garcom)void
    + getNumero() int
    + getConta() Conta
    + setNumero() void
    + setConta() void
}
class Restaurante{
    <<interface>>
    + run()$
}
class StatusPedido{
    <<enumeration>>
    AGUARDANDO
    PRONTO
    ENTREGUE
}
class Pedido{
    - Prato prato
    - StatusPedido status
    - Mesa mesa
    - List<Observer> observadores
    + getPrato() Prato
    + getStatusPedido() StatusPedido
    + getMesa() Mesa
    + setMesa() void
    + setPrato() void
    + setStatusPedido() void
}
class Prato{
    - String nome
    - double preco
    + getNome() String
    + getPreco() double
    + setNome() void
    + setPreco() void
}
class Observer{
    <<interface>>
    + setSubject(Subject s) void
    + update() void
} 
class Subject{
    <<interface>>
    + addObserver(Observer o) void
    + removeObserver(Observer o) void
    + notifyObservers()
    + getUpdate() Object
}
Funcionario ..|> Observer: implementa
Conta ..|> Observer: implementa
Funcionario <|-- Cozinheiro: herda
Funcionario <|-- Garcom: herda
Cozinheiro --o Garcom: possui
Pedido *-- Prato: tem
Pedido o-- Mesa : possui
Pedido o-- StatusPedido : tem
Pedido ..|> Subject: implementa
Mesa ..> Garcom: realizaPedido
Garcom ..> Pedido: cria
```
