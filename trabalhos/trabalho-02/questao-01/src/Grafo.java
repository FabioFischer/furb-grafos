import java.util.ArrayList;
import java.util.List;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 01
 *
 *   Fábio Luiz Fischer
 *
 **/

public class Grafo<T, E> {
    private List<Vertice<T, E>> vertices;

    public Grafo() {
        this.setVertices(new ArrayList<>());
    }

    

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.getVertices().size(); i++) {
            for (int j = 0; j < this.getVertices().size(); j++) {

            }
        }

        return builder.toString();
    }

    public int[][] getAdjascencyMatrix() {
        int[][] adjMatrix = new int[this.getVertices().size()][this.getVertices().size()];

        for (int i = 0; i < this.getVertices().size(); i++) {
            for (int j = 0; j < this.getVertices().size(); j++) {
                // TODO
            }
        }
        return adjMatrix;
    }

    public void addAresta(E key, T source, T destination) {
        this.addAresta(key, this.getVertice(source), this.getVertice(destination));
    }

    public void addAresta(E key, Vertice<T, E> source, Vertice<T, E> destination) {
        Aresta<E> edge = new Aresta<>(key);

        edge.setOrigem(source);
        edge.setDestino(source);

        source.getArestas().add(edge);
        destination.getArestas().add(edge);
    }

    public Vertice<T, E> getVertice(T key) {
        if (!this.getVertices().isEmpty()) {
            for (Vertice<T, E> node : this.getVertices()) {
                if (node.getValor() == key)
                    return node;
            }
        } return null;
    }

    public List<Vertice<T, E>> getVertices() {
        return vertices;
    }

    public void setVertices(List<Vertice<T, E>> vertices) {
        this.vertices = vertices;
    }
}
