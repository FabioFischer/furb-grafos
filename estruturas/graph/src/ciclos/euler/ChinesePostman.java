package ciclos.euler;

import caminhamento.Dijkstra;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by fabio.fischer on 07/11/2017.
 */
public class ChinesePostman {

    /**
     * Grafo em que o algorítmo será executado
     */
    private Grafo g;

    /**
     * Lista de vértices de grau ímpar
     */
    private ArrayList<Vertice> o;

    /**
     * Matriz de distância dos grafos de grau ímpar (o)
     */
    private Float[][] D;

    /**
     *
     * @param g
     */
    public ChinesePostman(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }

        this.g = g;
        this.o = new ArrayList<>();

        this.initializeSingleSource(g);
        this.chinesePostman();
    }

    /**
     * Executa algorítmo de Fleury  e verifica estado atual do grafo
     * O grafo deve ser estritamente semi-euleriano
     * @return
     */
    private boolean isValidGraph() {
        return new Fleury(this.g).isSemiEulerian();
    }

    /**
     *
     */
    private void chinesePostman() {
        for (Vertice v1 : o) {
            //
            new Dijkstra(g, v1);

            for (Vertice v2 : o) {
                D[v1.getId()][v2.getId()] = v2.getDistancia();
            }
        }
    }

    /**
     * Inicializa variáveis globais e adiciona os vértices de grau ímpar de 'g' na lista 'o'
     *
     * @param g
     */
    private void initializeSingleSource(Grafo g) {
        for (Vertice v : this.g.getVertices()) {
            if ((v.getGrau() % 2 != 0))
                if (!o.contains(v))
                    o.add(v);
        }
        this.D = new Float[g.getVertices().size()][g.getVertices().size()];
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        strBuilder.append("\n\t" + Arrays.deepToString(D));

        return strBuilder.toString();
    }
}
