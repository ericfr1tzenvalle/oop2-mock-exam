package com.ericfr1tzenvalle.exercise3.model;

import com.ericfr1tzenvalle.exercise1.model.Observer;
import com.ericfr1tzenvalle.exercise1.model.Subject;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Pedido implements Subject {
    private static int proximoId = 0;
    private final int id;
    private StatusPedido status;
    private List<Observer> observers;
    private Notificacao notificacao;

    public Pedido() {
        proximoId++;
        this.id = proximoId;
        this.status = StatusPedido.AGUARDANDO_PAGAMENTO;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer o) {
        if(o != null && !observers.contains(o)) {
            o.setSubject(this);
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        if(o != null) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update();
        }

    }
    @Override
    public Object getUpdate() {
        return status;
    }

    public void setNotificacao(Notificacao notificacao) {
        this.notificacao = notificacao;
        addObserver(notificacao);
    }
    public void processarPedido(){
        int statusCode = status.getStatusCode();
        if(statusCode < 6){
            StatusPedido newStatus = getStatus().getForCode(statusCode + 1);
            setStatus(newStatus);
            notifyObservers();
        }else{
            System.out.println("O pedido " + getId() + " já foi entregue.");
        }

    }
}
