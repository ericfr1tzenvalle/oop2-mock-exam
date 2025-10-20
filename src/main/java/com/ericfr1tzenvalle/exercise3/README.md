# Sistema de Notificações de Pedidos

Este exercício implementa um **sistema de notificações** para uma plataforma de pedidos online, aplicando os padrões de projeto **Observer**, **Factory Method** e **Singleton**. 

## Enunciado
Uma empresa deseja desenvolver um sistema de notificações para pedidos online. O sistema deve permitir que diferentes tipos de serviços de notificação (como e-mail, SMS e push) sejam criados dinamicamente conforme a necessidade.

Além disso, sempre que um novo pedido for realizado ou tiver seu status alterado, todos os observadores registrados devem ser notificados automaticamente.

O sistema também precisa de uma classe central responsável por gerenciar as notificações e o registro dos observadores, garantindo que exista apenas uma instância global desse gerenciador durante toda a execução do programa.

Implemente a arquitetura necessária para representar esse comportamento. 


---

## Objetivos

- Permitir a criação dinâmica de diferentes **tipos de notificação** (E-mail, SMS, Push).  
- Garantir que **todas as notificações** sejam enviadas automaticamente quando um pedido for criado ou tiver seu status alterado.  
- Manter uma **única instância central** responsável por gerenciar notificações e pedidos.  

---

## Fluxo Geral do Sistema

1. O **Gerenciador** (Singleton) controla a criação e o processamento de pedidos.  
2. Cada pedido é criado através de uma **fábrica de notificações** (Factory Method), que instancia o tipo de notificação desejado.  
3. O **Pedido** atua como **Subject**, permitindo o registro de **Observers** interessados em receber atualizações.  
4. Sempre que o status de um pedido muda, todos os **Observadores** são notificados automaticamente via o método `update()`.  

---

## Padrões de Projeto Utilizados

### 1. Factory Method
Define uma interface para criação de objetos de notificação, permitindo que subclasses decidam qual tipo concreto instanciar (`Email`, `Sms`, `Push`).

### 2. Observer
Implementa a comunicação reativa entre pedidos e notificadores: quando o estado do pedido muda, os observadores são automaticamente atualizados.

### 3. Singleton
Garante que apenas uma instância do `Gerenciador` exista, centralizando o controle de pedidos e notificações.

---

## Estrutura

| Função no Padrão | Classe/Interface | Descrição |
|------------------|------------------|------------|
| **Subject** | `Pedido` | Mantém a lista de observadores e notifica mudanças de status. |
| **Observer** | `Notificacao` | Interface base para todos os tipos de notificação. |
| **Concrete Observers** | `Email`, `Sms`, `Push` | Implementam o envio específico de notificação. |
| **Factory (Creator)** | `FactoryNotificacao` | Define o método de fábrica para criar notificações. |
| **Concrete Factories** | `FactoryEmail`, `FactorySms`, `FactoryPush` | Criam instâncias concretas de notificações. |
| **Singleton** | `Gerenciador` | Controla o fluxo do sistema e gerencia pedidos. |
| **Enum** | `StatusPedido` | Representa os diferentes estágios de um pedido. |

---

## Regras de Negócio Implementadas

- Um pedido é criado sempre com status **AGUARDANDO_PAGAMENTO**.  
- Quando o status muda, todos os observadores são notificados.  
- O `Gerenciador` é o ponto de entrada do sistema, sendo responsável por criar pedidos e processá-los.  
- Novos tipos de notificação podem ser adicionados facilmente implementando a interface `Notificacao` e criando uma nova `Factory`.

---

## Tecnologias Utilizadas

- Java 17+
- Padrões de Projeto GoF (Observer, Factory, Singleton)

---
``` mermaid
---
config:
  theme: redux-dark
  look: neo
---
classDiagram
   Sms ..|> Notificacao: Implementa
   Push ..|> Notificacao: Implementa
   Email ..|> Notificacao: Implementa
   Notificacao ..|> Observer : Implementa
   FactorySms ..|> FactoryNotificacao: Implementa
   FactoryEmail ..|> FactoryNotificacao: Implementa
   FactoryPush ..|> FactoryNotificacao: Implementa
   FactoryNotificacao ..> Notificacao : Depende
   Gerenciador ..> FactoryNotificacao : Gerencia
   Gerenciador ..> Pedido : Realiza
   Pedido *-- StatusPedido : Composição
   Pedido ..|> Subject : Implementa
   class Sms{
   }
   class Push{
   }
   class Email{
   }
   class Notificacao{
    <<interface>>
    + enviar() void
   }
   class FactoryNotificacao{
    <<interface>>
    + criarNotificacao() Notificacao
   }
   class FactorySms{
   }
   class FactoryEmail{
   }
   class FactoryPush{
   }
   class Gerenciador{
    <<singleton>>
    - Gerenciador instancia$
    + getInstancia()$ Gerenciador
    + realizarPedido(FactoryNotificao factory) Pedido
    + processarPedido(Pedido pedido) void
    + run() void
   }
   class StatusPedido{
    <<enumeration>>
    AGUARDANDO_PAGAMENTO [1]
    PAGO [2]
    ENVIADO [3]
    EM_TRANSITO [4]
    SAIU_PARA_ENTREGA [5]
    ENTREGUE [6]
    - int statusCode
    + getDescricao() String
    + setStatusCode() void
    + getForCode(int code) int
   }
   class Pedido{
    - int proximoId$
    - int id
    - StatusPedido status
    - List<Observers> observers
    - Notificacao notificao
    + processarPedido() void
    + setNotificacao(Notificao notificao) void 
   }
   class Subject{
    <<interface>>
    + addObserver(Observer o) void
    + removeObserver(Observer o) void
    + notifyObservers() void
    + getUpdate() Object
   }
   class Observer{
    <<interface>>
    + setSubject(Subject s) void
    + update() void
   }

```
