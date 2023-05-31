package org.example;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {

        if (args.length != 1){
            System.out.println("Atenção!\nPara executar o programa, informe o caminho absoluto do arquivo com os dados na seguinte formatação" +
                    "\n<variavel_x1>;<variavel_y1>" +
                    "\n<variavel_x2>;<variavel_y2>" +
                    "\n<variavel_xn>;<variavel_yn>");
            return;
        }
        BufferedReader buff;
        RegressaoLinear r = new RegressaoLinear();

        String caminhoArquivos = args[0];

        try {
            buff = new BufferedReader(new FileReader(caminhoArquivos));
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        while(true) {
            try {
                String[] linha = buff.readLine().split(";");
                r.addNoLista(new No(Double.parseDouble(linha[0]), Double.parseDouble(linha[1])));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NullPointerException e){
                break;
            }
        }

        System.out.println("Regressão: " + r.calculaRegressao());
        System.out.println("MedidaCorrelacao: " + r.medidaCorrelacao());

        Scanner s = new Scanner(System.in);

        System.out.println("Digite o valor para o calculo da estimativa: ");
        double estimativa = s.nextDouble();
        System.out.println("Calculo Estimativa = " + r.calculoEstimativa(estimativa));

        while(true){
            System.out.println("Caso queira outra estimativa, informar o valor. Caso contrário, digite qualquer letra.");
            try {
                estimativa = s.nextDouble();
                System.out.println("Calculo Estimativa = " + r.calculoEstimativa(estimativa));
            } catch (InputMismatchException ex){
                break;
            }
        }







    }
}
