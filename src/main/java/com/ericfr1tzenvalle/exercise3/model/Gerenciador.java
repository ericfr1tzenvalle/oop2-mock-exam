package com.ericfr1tzenvalle.exercise3.model;

public class Gerenciador {
    private static Gerenciador instancia;

    public static Gerenciador getInstancia(){
        if(instancia == null){
            instancia = new Gerenciador();
        }
        return instancia;
    }

    public Pedido realizarPedido(FactoryNotificacao factoryNotificacao){
        Notificacao notificacao = factoryNotificacao.criarNotificacao();
        Pedido pedido = new Pedido();
        pedido.setNotificacao(notificacao);
        System.out.println("Pedido ID: " + pedido.getId() + " criado com a notificacão por: " + pedido.getNotificacao().toString() + " STATUS: " +  pedido.getStatus());
        return pedido;
    }
    public void processarPedido(Pedido pedido){
       pedido.processarPedido();
    }

    public void run(){
        FactoryNotificacao factoryEmail = new FactoryEmail();
        Pedido pedidoEmail = realizarPedido(factoryEmail);

        FactoryNotificacao factorySms = new FactorySms();
        Pedido pedidoSms = realizarPedido(factorySms);

        FactoryNotificacao factoryPush = new FactoryPush();
        Pedido pedidoPush = realizarPedido(factoryPush);

        // Segunda etapa: Pago
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);
        // Terceira etapa: Enviado
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);
        // Quarta etapa: Em trânsito
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);
        // Quinta etapa: Saiu para entrega
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);
        // Sexta etapa: Entregue
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);

        // Pedido finalizados
        System.out.println("Pedido ID: " + pedidoEmail.getId() + " finalizado com status: " + pedidoEmail.getStatus());
        System.out.println("Pedido ID: " + pedidoSms.getId() + " finalizado com status: " + pedidoSms.getStatus());
        System.out.println("Pedido ID: " + pedidoPush.getId() + " finalizado com status: " + pedidoPush.getStatus());

        // Conferindo se chamar novamente não altera o status
        processarPedido(pedidoEmail);
        processarPedido(pedidoSms);
        processarPedido(pedidoPush);

        // Fim do processamento
    }


}
