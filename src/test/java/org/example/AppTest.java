package org.example;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.HashMap;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    private void templateCaso(ListaEncadeada listaValores, double b0, double b1, double rxy, double rquadrado, double xEstimado){
        RegressaoLinear r = new RegressaoLinear(listaValores);

        HashMap<String, Double> resultRegressao = r.calculaRegressao();

        // valida tamanho do hashmap
        assertEquals(resultRegressao.size(),2);

        // valida valores da regressao
        for (Map.Entry<String, Double> entry : resultRegressao.entrySet()){
            switch (entry.getKey()) {
                case "b1":
                    assertEquals(entry.getValue(), b1, 0.01 );
                    break;
                case "b0":
                    assertEquals(entry.getValue(), b0, 0.01 );
                    break;
                default:
                    System.out.println(entry.getKey());
                    fail("erro no nome da chave do calculaRegressao()");
            }
        }

        HashMap<String, Double> resultCorrelacao = r.medidaCorrelacao();

        // valida tamanho do hashmap
        assertEquals(resultCorrelacao.size(),2);

        // valida valores da regressao
        for (Map.Entry<String, Double> entry : resultCorrelacao.entrySet()){
            switch (entry.getKey()) {
                case "rxy":
                    assertEquals(entry.getValue(), rxy, 0.01 );
                    break;
                case "rˆ2":
                    assertEquals(entry.getValue(),rquadrado, 0.01 );
                    break;
                default:
                    fail("erro no nome da chave do medidaCorrelacao()");
            }
        }

        assertEquals(xEstimado, r.calculoEstimativa(386d),0.01);

    }

    public void testCaso1(){
        // Tamanho estimado do proxy por Tamanho efetivo das adições e modificações
        ListaEncadeada lista = new ListaEncadeada();

        lista.adicionaFim(new No(130d, 186d));
        lista.adicionaFim(new No(650d, 699d));
        lista.adicionaFim(new No(99d, 132d));
        lista.adicionaFim(new No(150d, 272d));
        lista.adicionaFim(new No(128d, 291d));
        lista.adicionaFim(new No(302d, 331d));
        lista.adicionaFim(new No(95d, 199d));
        lista.adicionaFim(new No(945d, 1890d));
        lista.adicionaFim(new No(368d, 788d));
        lista.adicionaFim(new No(961d, 1601d));

        this.templateCaso(lista, -22.55, 1.7279, 0.9545, 0.9111, 644.429);
    }

    public void testCaso2(){
        // Tamanho estimado do proxy por Tempo efetivo de desenvolvimento (em horas)

        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionaFim(new No(130d, 15d));
        lista.adicionaFim(new No(650d, 69.9));
        lista.adicionaFim(new No(99d, 6.5));
        lista.adicionaFim(new No(150d, 22.4));
        lista.adicionaFim(new No(128d, 28.4));
        lista.adicionaFim(new No(302d, 65.9));
        lista.adicionaFim(new No(95d, 19.4));
        lista.adicionaFim(new No(945d, 198.7));
        lista.adicionaFim(new No(368d, 38.8));
        lista.adicionaFim(new No(961d, 138.2));

        this.templateCaso(lista, -4.039, 0.1681, 0.9333, 0.8711, 60.858);
    }

    public void testCaso3(){
        // Tamanho planejado de adições e modificações por Tamanho efetivo das adições e modificações

        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionaFim(new No(163d,186d ));
        lista.adicionaFim(new No(765d,699d ));
        lista.adicionaFim(new No(141d,132d ));
        lista.adicionaFim(new No(166d,272d ));
        lista.adicionaFim(new No(137d,291d ));
        lista.adicionaFim(new No(355d,331d ));
        lista.adicionaFim(new No(136d,199d ));
        lista.adicionaFim(new No(1206d,1890d ));
        lista.adicionaFim(new No(433d,788d ));
        lista.adicionaFim(new No(1130d,1601d ));

        this.templateCaso(lista, -23.92, 1.43097, 0.9631, 0.9276, 528.4294);
    }

    public void testCaso4(){
        // Tamanho planejado de adições e modificações por Tempo efetivo de desenvolvimento (em horas)

        ListaEncadeada lista = new ListaEncadeada();
        lista.adicionaFim(new No(163d,15.0 ));
        lista.adicionaFim(new No(765d,69.9 ));
        lista.adicionaFim(new No(141d,6.5 ));
        lista.adicionaFim(new No(166d,22.4 ));
        lista.adicionaFim(new No(137d,28.4 ));
        lista.adicionaFim(new No(355d,65.9 ));
        lista.adicionaFim(new No(136d,19.4 ));
        lista.adicionaFim(new No(1206d,198.7 ));
        lista.adicionaFim(new No(433d,38.8 ));
        lista.adicionaFim(new No(1130d,138.2 ));

        this.templateCaso(lista, -4.604, 0.140164, 0.9480, 0.8988, 49.4994);
    }
}
