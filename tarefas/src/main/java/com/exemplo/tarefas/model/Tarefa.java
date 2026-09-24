package com.exemplo.tarefas.model;

import jakarta.persistence.*;

@Entity
public class Tarefa {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private Boolean concluida;

    protected Tarefa() {} // exigido pelo JPA

    //Constructor

    public Tarefa(String titulo) {
        this.titulo = titulo;
        this.concluida = false;
    }

    //Metodos

    public long getId() { return this.id;}
    public String getTitulo() { return this.titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public Boolean isConcluida() {return this.concluida;}
    public Boolean setConcluida(Boolean concluida) {return this.concluida = concluida;}

}