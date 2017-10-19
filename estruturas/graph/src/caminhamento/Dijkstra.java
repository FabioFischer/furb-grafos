package caminhamento;

import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dijkstra {

    private final float INFINITO = Float.MAX_VALUE;

    // Grafo
    private Grafo g;

    // Vertice inicial
    private Vertice s;

    // Lista de vértices pendentes
    private List<Vertice> Q;

    // Lista de vértices cujo caminho mínimo ja foi cauculado
    private List<Vertice> S;

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
                    this.relax(u, v);
                }
            }
        }
    }

    // Inicialização dos atributos dos vértices
    private void initializeSingleSource (Grafo g, Vertice s) {
        for (Vertice v : g.getVertices()) {
            v.setDistancia(this.INFINITO);
            v.setPai(null);
        }
        s.setDistancia(0);
    }

    // Verifica se podemos melhorar a estimativa atual de caminho mínimo até o vértice v, incluindo o vértice v no caminho
    private void relax (Vertice u, Vertice v) {
        if (v.getDistancia() > (u.getDistancia() + u.getMinAresta(v).getValor())) {
            v.setDistancia(u.getDistancia() + u.getMinAresta(v).getValor());
            v.setPai(u);
        }
    }

    // Busca o vértice com menor distancia da lista Q
    private Vertice extractMin (List<Vertice> Q) {
        return Collections.min(Q);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n ------------ Dijkstra ------------ ");

        str.append("\n\n- Q");

        for (Vertice v : this.Q) {
            str.append("\nv: " + v.getValor() + " - d: " + v.getDistancia() +  ", ∏: " + ((v.getPai() == null) ? "nulo" : v.getPai().getValor()));
        }

        str.append("\n\n- S");

        for (Vertice v : this.S) {
            str.append("\nv: " + v.getValor() + " - d: " + v.getDistancia() + ", ∏: " + ((v.getPai() == null) ? "nulo" : v.getPai().getValor()));
        }

        return str.toString();
    }
}
