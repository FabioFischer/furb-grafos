import busca.BreadthFirstSearch;
import busca.DepthFirstSearch;
import caminhamento.Dijkstra;
import caminhamento.FloydWarshall;
import conexidade.DisjointSets;
import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;

public class Algoritmos {

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String tipoDoGrafo(Integer[][] matrizAdj) {
        Grafo g = new Grafo(matrizAdj);

        return "\n ------------ tipoDoGrafo ------------ " +
                "\n " + ((g.eDirigido()) ? "Dirigido" : "Não-dirigido") +
                ((g.eSimples()) ? ", Simples" : ", Multigrafo") +
                ((g.eRegular()) ? ", Regular" : "") +
                ((g.eCompleto()) ? ", Completo" : "") +
                ((g.eNulo()) ? ", Nulo" : "") +
                ((g.eBipartido()) ? ", Bipartido" : "");
    }

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String arestasDoGrafo(Integer[][] matrizAdj) {
        Grafo g = new Grafo(matrizAdj);
        ArrayList<Aresta> arestas = g.getArestas();
        StringBuilder strBuilder = new StringBuilder("\n ------------ arestasDoGrafo ------------ "
                + "\n  Grafo possui " + arestas.size() + " arestas");

        if (!arestas.isEmpty()) {
            for (Aresta a : arestas) {
                strBuilder.append("\n ").append(a.toString());
            }
        }

        return strBuilder.toString();
    }

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String grausDoVertice(Integer[][] matrizAdj) {
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

    /**
     *
     * @param matrizAdj
     * @param verticeInicial
     * @return
     */
    public static String bfs(Integer[][] matrizAdj, int verticeInicial) {
        Grafo g = new Grafo(matrizAdj);

        StringBuilder strBuilder = new StringBuilder("\n ------------   BFS   ------------ ");
        strBuilder.append(new BreadthFirstSearch(g, g.getVertice(verticeInicial)).toString());

        return strBuilder.toString();
    }

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String dfs(Integer[][] matrizAdj) {
        StringBuilder strBuilder = new StringBuilder("\n ------------   DFS   ------------ ");

        strBuilder.append(new DepthFirstSearch(new Grafo(matrizAdj)).toString());

        return strBuilder.toString();
    }

    /**
     *
     * @param matrizAdj
     * @param verticeInicial
     * @return
     */
    public static String dijkstra(Integer[][] matrizAdj, int verticeInicial) {
        Grafo g = new Grafo(matrizAdj);
        new Dijkstra(g, g.getVertice(verticeInicial));

        StringBuilder strBuilder = new StringBuilder("\n ------------ Dijkstra ------------ ");
        String vertices = "", pais = "", distancias = "";

        for (Vertice v : g.getVertices()) {
            vertices += v.getValor() + "\t\t";
            pais += (v.getPai() == null) ? "nil\t\t" : v.getPai().getValor() + "\t\t";
            distancias += (v.getPai() == null) ? "-\t\t" : v.getDistancia() + "\t\t";
        }

        strBuilder.append("\n").append(vertices);
        strBuilder.append("\n").append(pais);
        strBuilder.append("\n").append(distancias);

        return strBuilder.toString();
    }

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String floydWarshall(Integer[][] matrizAdj) {
        StringBuilder strBuilder = new StringBuilder("\n ------------ Floyd Warshall ------------ ");

        strBuilder.append(new FloydWarshall(new Grafo(matrizAdj)).toString());

        return  strBuilder.toString();
    }

    /**
     *
     * @param matrizAdj
     * @return
     */
    public static String conjuntosDisjuntos(Integer[][] matrizAdj) {
        Grafo g = new Grafo(matrizAdj);
        DisjointSets ds = new DisjointSets(g);

        StringBuilder strBuilder = new StringBuilder("\n ------------   DS   ------------ ");
        strBuilder.append(ds.toString());
        strBuilder.append("\n\nGrafo").append(ds.isConnected() ? " é " : " não é ").append("conexo");

        return strBuilder.toString();
    }
}
