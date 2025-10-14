package com.ericfr1tzenvalle.exercise1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public abstract class Funcionario implements Observer {
    private String nome;


}
