package com.ericfr1tzenvalle.exercise1.model;

public interface Observer {
    void setSubject(Subject s);
    void update();
}
