package busca;

import grafo.Grafo;
import grafo.Vertice;

import java.util.Stack;

public class BreadthFirstSearch {
    /**
     *
     */
    private Grafo g;

    /**
     *
     */
    private Stack<Vertice> Q;

    /**
     *
     * @param g
     * @param s
     */
    public BreadthFirstSearch(Grafo g, Vertice s) {
        if (g == null || s == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.bfs(g, s);
    }

    /**
     *
     * @param g
     * @param s
     */
    private void bfs(Grafo g, Vertice s) {
        this.g = g;
        this.Q = new Stack<>();

        if (s != null) initializeSingleSource(this.Q, this.g, s);

        while (!Q.isEmpty()) {
            Vertice u = Q.pop();

            for (Vertice v : u.getAdjacencias()) {
                if (v.getEstado() == Vertice.Estado.BRANCO) {
                    Q.push(v);
                    v.setEstado(Vertice.Estado.CINZA);
                    v.setPai(u);
                    v.setDescobrimento(u.getDescobrimento() + 1);
                }
            }

            u.setEstado(Vertice.Estado.PRETO);
        }
    }

    /**
     *
     * @param Q
     * @param g
     * @param s
     */
    private void initializeSingleSource(Stack Q, Grafo g, Vertice s) {
        for (Vertice v : this.g.getVertices()) {
            v.setEstado(Vertice.Estado.BRANCO);
            v.setPai(null);
            v.setDistancia(Float.MAX_VALUE);
        }

        s.setDescobrimento(0);
        s.setEstado(Vertice.Estado.CINZA);
        Q.push(s);
    }

    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        for (Vertice v : this.g.getVertices()) {
            strBuilder.append("\nv: " + v.getId() + ", Cor: " + v.getEstado() + ", Tempo Descobrimento: " + v.getDescobrimento());
        }

        return strBuilder.toString();
    }
}
