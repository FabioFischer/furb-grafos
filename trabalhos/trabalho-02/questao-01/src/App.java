import java.util.ArrayList;
import java.util.Collections;

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
        Grafo g = new Grafo(matrizAdj);

        return "\n ------------ tipoDoGrafo ------------ " +
                "\n " + ((g.eDirigido()) ? "Dirigido" : "Não-dirigido") +
                ((g.eSimples()) ? ", Simples" : ", Multigrafo") +
                ((g.eRegular()) ? ", Regular" : "") +
                ((g.eCompleto()) ? ", Completo" : "") +
                ((g.eNulo()) ? ", Nulo" : "") +
                ((g.eBipartido()) ? ", Bipartido" : "");
    }

    public static String arestasDoGrafo(int[][] matrizAdj) {
        Grafo g = new Grafo(matrizAdj);
        ArrayList<Aresta> arestas = g.getArestas();
        StringBuilder strBuilder = new StringBuilder("\n ------------ arestasDoGrafo ------------ " + "\n  Grafo possui " + arestas.size() + " arestas");

        if (!arestas.isEmpty()) {
            for (Aresta a : arestas) {
                strBuilder.append("\n ").append(a.toString());
            }
        }

        return strBuilder.toString();
    }

    public static String grausDoVertice(int[][] matrizAdj) {
        Grafo g = new Grafo(matrizAdj);
        ArrayList<Vertice> vertices = g.getVertices();
        ArrayList<Integer> graus = new ArrayList<>();

        StringBuilder strBuilder = new StringBuilder("\n ------------ grausDoVertice ------------ ");

        if (!vertices.isEmpty()) {
            for (Vertice v : vertices) {
                strBuilder.append("\nVertice ").append(v.getValor()).append(", grau ").append(v.getGrau());
                graus.add(v.getGrau());
            }

            graus.sort(Collections.reverseOrder());
            strBuilder.append("\n\nConjunto de Graus: ");

            for (Integer grau : graus) {
                strBuilder.append(grau).append(", ");
            }
        } else {
            strBuilder.append("Grafo não possui vértices.");
        }

        return strBuilder.toString();
    }

    public static void main(String[] args) {
        int[][] matrizAdj = {
                {0, 3, 0, 0},
                {9, 0, 7, 0},
                {0, 0, 4, 2},
                {0, 0, 1, 0}};

        System.out.println(tipoDoGrafo(matrizAdj));
        System.out.println(arestasDoGrafo(matrizAdj));
        System.out.println(grausDoVertice(matrizAdj));
    }
}