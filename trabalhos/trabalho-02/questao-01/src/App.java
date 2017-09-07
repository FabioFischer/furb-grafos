
/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 01
 *
 *   Fábio Luiz Fischer
 *
 *     Dada a matriz de adjacência do grafo de ordem n, você deve implementar um programa que responda as seguintes perguntas:
 *          a. Qual é o tipo do grafo (dirigido ou não, simples ou multigrafo, regular, completo, nulo ou bipartido)
 *              nome do método: tipoDoGrafo
 *              parâmetro de entrada: matriz de adjacência
 *              retorno: String contendo o tipo do grafo
 *
 *          b.Quantas arestas esse grafo possui? Liste o conjunto de arestas.
 *              nome do método: arestasDoGrafo
 *              parâmetro de entrada: matriz de adjacência
 *              retorno: String com a quantidade e o conjunto de arestas
 *
 *          c.Qual é o grau de cada vértice. Liste a sequência de graus.
 *              nome do método: grausDoVertice
 *              parâmetro de entrada: matriz de adjacência
 *              retorno: String identificando o grau de cada vértice e por fim, a sequência de graus
 *
 **/

public class App {

    public static String tipoDoGrafo(int[][] matrizAdj) {
        return "";
    }

    public static String arestasDoGrafo(int[][] matrizAdj) {
        return "";
    }

    public static String grausDoVertice(int[][] matrizAdj) {
        return "";
    }

    public static void main(String[] args) {
        int[][] matrizAdj = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 1, 1},
                {0, 0, 1, 0}};

        Grafo g = new Grafo(matrizAdj);

        System.out.println(g.toString());
    }
}
