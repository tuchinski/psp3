package org.example;


public class App 
{
    public static void main( String[] args )
    {
        RegressaoLinear r = new RegressaoLinear();

        r.addNoLista(new No(130d,15d));
        r.addNoLista(new No(650d,69.9));
        r.addNoLista(new No(99d,6.5));
        r.addNoLista(new No(150d,22.4));
        r.addNoLista(new No(128d,28.4));
        r.addNoLista(new No(302d,65.9));
        r.addNoLista(new No(95d,19.4));
        r.addNoLista(new No(945d,198.7));
        r.addNoLista(new No(368d,38.8));
        r.addNoLista(new No(961d,138.2));


        System.out.println(r.calculaRegressao());

        System.out.println("r.medidaCorrelacao() = " + r.medidaCorrelacao());

        System.out.println("r.calculoEstimativa(386d) = " + r.calculoEstimativa(386d));

    }
}
