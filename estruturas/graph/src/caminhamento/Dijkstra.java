package caminhamento;

import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {
    /**
     * Lista de vértices pendentes
     */
    private List<Vertice> Q;

    /**
     * Lista de vértices cujo caminho mínimo ja foi calculado
     */
    private List<Vertice> S;

    /**
     *
     * @param g Grafo onde o algorítmo será realizado
     * @param s Vértice inicial
     */
    public Dijkstra (Grafo g, Vertice s) {
        if (g == null || s == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.initializeSingleSource(g, s);

        this.S = new ArrayList<>();
        this.Q = g.getVertices();

        while (!this.Q.isEmpty()) {
            Vertice u = this.extractMin(this.Q);
            this.Q.remove(u);
            this.S.add(u);

            for (Vertice v : u.getAdjacencias()) {
                if (!S.contains(v)) {
                    this.relax(u, v, u.getMinAresta(v).getValor());
                }
            }
        }
    }

    /**
     * Inicialização dos atributos dos vértices
     *
     * @param g Grafo onde o algorítmo será realizado
     * @param s Vértice inicial
     *          As distancias serão calculadas baseadas nessa instância
     */
    private void initializeSingleSource (Grafo g, Vertice s) {
        for (Vertice v : g.getVertices()) {
            v.setDistancia(Float.MAX_VALUE);
            v.setPai(null);
        }
        s.setDistancia(0);
    }

    /**
     * Verifica se podemos melhorar a estimativa atual de caminho mínimo até o vértice v, incluindo o vértice v no caminho
     *
     * @param u Vértice pivô
     * @param v Vértice destino
     * @param w Valor na aresta com menor custo entre os vértices u e v
     */
    private void relax (Vertice u, Vertice v, float w) {
        if (v.getDistancia() > (u.getDistancia() + w)) {
            v.setDistancia(u.getDistancia() + w);
            v.setPai(u);
        }
    }

    /**
     *
     * @param Q Fila contendo os vértices restantes
     * @return Vértice com menor valor de distancia
     */
    private Vertice extractMin (List<Vertice> Q) {
        return Collections.min(Q);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n\n  - S");

        for (Vertice v : this.S) {
            strBuilder.append("\nv: " + v.getValor() + ", d: " + v.getDistancia() + ", ∏: " + ((v.getPai() == null) ? "nulo" : v.getPai().getValor()));
        }

        return strBuilder.toString();
    }
}
