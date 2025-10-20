package com.ericfr1tzenvalle.exercise3.model;

import lombok.Getter;

@Getter
public enum StatusPedido {
    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    EM_TRANSITO(4),
    SAIU_PARA_ENTREGA(5),
    ENTREGUE(6);
    private int statusCode;
    StatusPedido(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescricao() {
        return switch (this) {
            case AGUARDANDO_PAGAMENTO -> "Aguardando Pagamento";
            case PAGO -> "Pago";
            case ENVIADO -> "Enviado";
            case EM_TRANSITO -> "Em Trânsito";
            case SAIU_PARA_ENTREGA -> "Saiu para Entrega";
            case ENTREGUE -> "Entregue";
            default -> "Status Desconhecido";
        };
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public StatusPedido getForCode(int code){
        for(StatusPedido status : StatusPedido.values()){
            if(status.getStatusCode() == code){
                return status;
            }
        }
        return null;
    }
}
