package busca;

import grafo.Grafo;
import grafo.Vertice;

/**
 *
 */
public class DepthFirstSearch {

    /**
     * Variavel utilizada para sinalizar os tempos de abertura (descobrimento) e fechamento dos vértices.
      */
    private int tempo = 0;

    /**
     * Algoritmo de busca.
     * A DFS explora todos os vértices de um grafo, usando como critério o vértice visitado mais recentemente e não marcado.
     * Utiliza recursividade para guiar a busca.
     *
     * @param g Grafo onde a busca será realizada
     */
    public DepthFirstSearch(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("");
        }
        this.dfs(g);
    }

    /**
     * Inicializa o grafo para, então, iniciar o algoritmo para cada vértice do grafo.
     *
     * @param g Grafo onde a busca será realizada
     */
    private void dfs(Grafo g) {
        for (Vertice v : g.getVertices()) {
            v.setEstado(Vertice.Estado.BRANCO);
        }
        tempo = 0;

        for (Vertice u : g.getVertices()) {
            if (u.getEstado().equals(Vertice.Estado.BRANCO))
                dfsVisit(u);
        }
    }

    /**
     * Quando todas arestas adjascentes ao Vértice v tiverem sido exploradas, a busca "anda para trás" para explorar vértices do qual v foi descoberto.
     *
     * Se todos os vértices já foram descobertos, então o algorítmo chega ao fim.
     * Caso contrário o processo continua a partir de um novo vértice de origem ainda não descoberto, de forma que grafos deconexos sejam considerados.
     *
     * @param u Vértice
     */
    private void dfsVisit(Vertice u) {
        u.setEstado(Vertice.Estado.CINZA);
        tempo++;
        u.setDescobrimento(tempo);

        for (Vertice v : u.getAdjacencias()) {
            if (v.getEstado().equals(Vertice.Estado.BRANCO))
                dfsVisit(v);
        }
        u.setEstado(Vertice.Estado.PRETO);
        u.setFechamento(tempo);
    }
}
