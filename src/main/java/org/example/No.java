package org.example;

public class No {
    private No noProximo;
    private float dado;

    public No() {
    }

    public No(float dado) {
        this.dado = dado;
    }

    public No(No noProximo, float dado) {
        this.noProximo = noProximo;
        this.dado = dado;
    }

    public No getNoProximo() {
        return noProximo;
    }

    public void setNoProximo(No noProximo) {
        this.noProximo = noProximo;
    }

    public float getDado() {
        return dado;
    }

    public void setDado(float dado) {
        this.dado = dado;
    }
}
