package busca;

import grafo.Grafo;
import grafo.Vertice;

/**
 *
 */
public class DepthFirstSearch {

    /**
     * Grafo  onde a busca será realizada
     */
    private Grafo g;

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
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.dfs(g, null);
    }

    /**
     * Algoritmo de busca.
     * A DFS explora todos os vértices de um grafo, usando como critério o vértice visitado mais recentemente e não marcado.
     * Utiliza recursividade para guiar a busca.
     *
     * @param g Grafo onde a busca será realizada
     * @param s Vértice inicial do algorítmo
     */
    public DepthFirstSearch(Grafo g, Vertice s) {
        if (g == null || s == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.dfs(g, s);
    }

    /**
     * Inicializa o grafo para, então, iniciar o algoritmo para cada vértice do grafo.
     *
     * @param g Grafo onde a busca será realizada
     * @param s Vértice inicial do algorítmo. Caso seja nulo, o vértice inicial será random.
     */
    private void dfs(Grafo g, Vertice s) {
        this.g = g;
        this.tempo = 0;

        for (Vertice v : g.getVertices()) {
            v.setEstado(Vertice.Estado.BRANCO);
        }

        if (s != null) dfsVisit(s);

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

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        for (Vertice v : this.g.getVertices()) {
            strBuilder.append("\nv: " + v.getId() + ", Cor: " + v.getEstado() + ", Tempo Abertura: " + v.getDescobrimento() + ", Tempo Fechamento: " + v.getFechamento());
        }

        return strBuilder.toString();
    }
}
