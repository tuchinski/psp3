package org.example;

public class No {
    private No noProximo;
    private Double dado1;
    private Double dado2;

    public No() {
    }

    public No(Double dado1, Double dado2) {
        this.dado1 = dado1;
        this.dado2 = dado2;
        this.noProximo = null;
    }

    public No(No noProximo, Double dado1, Double dado2) {
        this.noProximo = noProximo;
        this.dado1 = dado1;
        this.dado2 = dado2;
    }

    public No getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(No noProximo) {
        this.noProximo = noProximo;
    }

    public Double getDado1() {
        return dado1;
    }

    public void setDado1(Double dado1) {
        this.dado1 = dado1;
    }

    public Double getDado2() {
        return dado2;
    }

    public void setDado2(Double dado2) {
        this.dado2 = dado2;
    }
}
