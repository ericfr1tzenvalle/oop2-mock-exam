package com.ericfr1tzenvalle.exercise1.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pedido implements Subject{
    private Prato prato;
    private StatusPedido status;
    private Mesa mesa;
    private List<Observer> observers = new ArrayList<>();

    public Pedido(Prato prato) {
        this.prato = prato;
    }

    public void setStatusPedido(StatusPedido sp){
        this.status = sp;
    }

    @Override
    public void addObserver(Observer o) {
        if(o != null && !observers.contains(o)){
            o.setSubject(this);
            observers.add(o);
        }

    }

    @Override
    public void removeObserver(Observer o) {
        if(o != null && observers.contains(o)){
            o.setSubject(null);
            observers.remove(o);
        }

    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers){
            o.update();
        }

    }

    @Override
    public Object getUpdate() {
        return status;
    }
}
