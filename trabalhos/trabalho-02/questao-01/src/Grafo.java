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

public class Grafo {
    private List<Vertice> vertices;

    public Grafo(int[][] matrizAdj) throws IllegalArgumentException {
        this.setVertices(new ArrayList<>());
        this.addMatrizAdjacencia(matrizAdj);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("-");

        if (!this.getVertices().isEmpty()) {
            int[][] matrizAdj = this.getMatrizAdjacencia();

            for (int[] aMatrizAdj : matrizAdj) {
                builder.append("\n");
                for (int j = 0; j < aMatrizAdj.length; j++) {
                    builder.append(aMatrizAdj[j]).append(((j + 1) < aMatrizAdj.length) ? ", " : "");
                }
                builder.append("\n-");
            }
        }

        return builder.toString();
    }

    public int[][] getMatrizAdjacencia() {
        int[][] matrizAdj = new int[this.getVertices().size()][this.getVertices().size()];

        for (int i = 0; i < matrizAdj.length; i++) {
            for (int j = 0; j < matrizAdj[i].length; j++) {
                Aresta a = this.getAresta(i, j);

                matrizAdj[i][j] = (a != null) ? a.getValor() : 0;
            }
        }

        return matrizAdj;
    }

    private void addMatrizAdjacencia(int[][] matrizAdj) {
        if (this.getVertices().isEmpty()) {
            for (int i = 0; i < matrizAdj.length; i++) {
                if (matrizAdj[i].length != matrizAdj.length) {
                    new IllegalArgumentException("Número de colunas deve ser igual ao número de linhas");
                }
                for (int j = 0; j < matrizAdj[i].length; j++) {
                    if (matrizAdj[i][j] > 0) {
                        this.addAresta(matrizAdj[i][j], i, j);
                    }
                }
            }
        }
    }

    private void addAresta(int valor, int origem, int destino) {
        this.addAresta(valor, this.verificaVertice(origem), this.verificaVertice(destino));
    }

    public void addAresta(int valor, Vertice origem, Vertice destino) {
        Aresta aresta = null;

        for (Aresta a : origem.getArestas()) {
            if (destino == a.getDestino()) {
                aresta = a;
            }
        }

        if (aresta == null) {
            aresta = new Aresta(valor);

            aresta.setOrigem(origem);
            aresta.setDestino(destino);

            origem.getArestas().add(aresta);
            destino.getArestas().add(aresta);
        }
    }

    private Aresta getAresta(int origem, int destino) {
        return this.getAresta(this.getVertice(origem), this.getVertice(destino));
    }

    private Aresta getAresta(Vertice origem, Vertice destino) {
        if (origem != null && destino != null) {
            for (Aresta a : origem.getArestas()) {
                if (a.getOrigem() == origem)
                    if (a.getDestino() == destino) return a;

            }
        }
        return null;
    }

    private Vertice getVertice(int valor) {
        if (!this.getVertices().isEmpty()) {
            for (Vertice v : this.getVertices()) {
                if (v.getValor() == valor)
                    return v;
            }
        }
        return null;
    }

    private Vertice verificaVertice(int valor) {
        Vertice v = this.getVertice(valor);

        if (v == null) {
            v = new Vertice(valor);
            this.getVertices().add(v);
        }

        return v;
    }

    public List<Vertice> getVertices() {
        return vertices;
    }

    private void setVertices(List<Vertice> vertices) {
        this.vertices = vertices;
    }
}
