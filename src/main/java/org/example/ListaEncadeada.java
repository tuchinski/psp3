package org.example;

public class ListaEncadeada {
    private No cabeca;
    private No cauda;
    private int tamanho;

    public int getTamanho() {
        return tamanho;
    }

    public ListaEncadeada() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanho = 0;
    }

    public void adicionaFim(No no){
        if (this.cabeca == null){
            this.cabeca = no;
        }
        else{
            this.cauda.setNoProximo(no);
            no.setNoProximo(null);
        }
        this.cauda = no;
        this.tamanho++;
    }

    public No getCabeca() {
        return cabeca;
    }


    public void imprimeLista(){
        No no = this.cabeca;
        while (no != null){
            System.out.print("Dado1: "  + no.getDado1());
            System.out.println(" | Dado2: "  + no.getDado1());
            no = no.getNoProximo();
        }
    }

}
