package com.ericfr1tzenvalle.exercise1.model;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
    Object getUpdate();
}
