import caminhamento.Dijkstra;
import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;

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

    public static String matrizRoteamentoDijkstra(int[][] matrizAdj, int verticeInicial) {
        Grafo g = new Grafo(matrizAdj);

        return new Dijkstra(g, g.getVertice(verticeInicial)).toString();
    }

    public static void main(String[] args) {
        int[][] matrizAdj = {
                {0, 2, 0, 0, 10},
                {0, 0, 3, 0, 7},
                {0, 0, 0, 4, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 8, 5, 0}};

        System.out.println(tipoDoGrafo(matrizAdj));
//        System.out.println(arestasDoGrafo(matrizAdj));
//        System.out.println(grausDoVertice(matrizAdj));
        System.out.println(matrizRoteamentoDijkstra(matrizAdj, 0));
    }
}