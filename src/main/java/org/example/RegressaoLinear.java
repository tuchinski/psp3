package org.example;

import java.util.HashMap;

public class RegressaoLinear {

    private ListaEncadeada listaDados;

    public RegressaoLinear() {
        this.listaDados = new ListaEncadeada();
    }

    public RegressaoLinear(ListaEncadeada listaDados) {
        this.listaDados = listaDados;
    }

    public void addNoLista(No no){
        this.listaDados.adicionaFim(no);
    }

    public HashMap<String, Double> calculaRegressao(){
        //Criando variaveis para facilitar o trabalho
        double somatorioX = 0d;
        double somatorioY = 0d;
        double somatorioXQuadrado = 0d;
        double somatorioXmultiplicadoY = 0d;
        int dadosTamanho = this.listaDados.getTamanho();

        No atual = this.listaDados.getCabeca();

        while(atual != null){
            somatorioX += atual.getDado1();
            somatorioY += atual.getDado2();
            somatorioXQuadrado += Math.pow(atual.getDado1(),2);
            somatorioXmultiplicadoY += atual.getDado1()* atual.getDado2();

            atual = atual.getNoProximo();
        }

        Double sxx = somatorioXQuadrado - (Math.pow(somatorioX,2)/ dadosTamanho);
        Double sxy = somatorioXmultiplicadoY - ((somatorioX*somatorioY)/ dadosTamanho);

        // regressao linear
        double b1 = sxy/sxx;
        Double b0 = (somatorioY/ dadosTamanho) - b1*(somatorioX/ dadosTamanho); //mediaY - b1*mediaX

        HashMap<String, Double> retorno = new HashMap<>();
        retorno.put("b0", b0);
        retorno.put("b1", b1);

        return retorno;


    }

    public HashMap<String, Double> medidaCorrelacao(){
        //Criando variaveis para facilitar o trabalho
        double somatorioX = 0d;
        double somatorioY = 0d;
        double somatorioXQuadrado = 0d;
        double somatorioYQuadrado = 0d;
        double somatorioXmultiplicadoY = 0d;
        int dadosTamanho = this.listaDados.getTamanho();

        No atual = this.listaDados.getCabeca();

        while(atual != null){
            somatorioX += atual.getDado1();
            somatorioY += atual.getDado2();
            somatorioXQuadrado += Math.pow(atual.getDado1(),2);
            somatorioYQuadrado += Math.pow(atual.getDado2(),2);
            somatorioXmultiplicadoY += atual.getDado1()* atual.getDado2();

            atual = atual.getNoProximo();
        }

        // medidas de correlação
        Double dividendoRxy = ((dadosTamanho*somatorioXmultiplicadoY) - (somatorioX*somatorioY));
        Double divisorRxy = Math.sqrt( ((dadosTamanho*somatorioXQuadrado) - Math.pow(somatorioX,2)) * ((dadosTamanho*somatorioYQuadrado) - Math.pow(somatorioY,2)));


        Double rxy = dividendoRxy/divisorRxy;
        HashMap<String, Double> retorno = new HashMap<>();
        retorno.put("rxy", rxy);
        retorno.put("rˆ2", rxy * rxy);

        return retorno;
    }

    public Double calculoEstimativa(Double valorEstimativa){
        HashMap<String,Double> valoresRegressao = this.calculaRegressao();

        return valoresRegressao.get("b0") + (valoresRegressao.get("b1") *valorEstimativa);

    }
}
