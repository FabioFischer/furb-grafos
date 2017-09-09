import java.util.ArrayList;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 01
 *
 *   Fábio Luiz Fischer
 *
 **/

public class Grafo {
    private ArrayList<Vertice> vertices;

    public Grafo(int[][] matrizAdj) throws IllegalArgumentException {
        this.setVertices(new ArrayList<>());
        this.addMatrizAdjacencia(matrizAdj);
    }

    public boolean eDirigido() {
        for (Vertice v1 : this.getVertices()) {
            for (Vertice v2 : v1.getAdjacencias()) {
                Aresta a1 = getAresta(v1, v2);
                Aresta a2 = getAresta(v2, v1);

                if (a2 == null || a1.getValor() != a2.getValor()) return true;
            }
        }
        return false;
    }

    public boolean eSimples() {
        for (Vertice v1 : this.getVertices()) {
            if (v1.getAdjacencias().contains(v1)) return false;

            for (Vertice v2 : v1.getAdjacencias()) {
                Aresta a1 = getAresta(v1, v2);
                Aresta a2 = getAresta(v2, v1);

                if (a2 == null || a1.getValor() != a2.getValor()) return false;
            }
        }

        return true;
    }

    public boolean eRegular() {
        int grau = 0;

        if (!this.getVertices().isEmpty()) {
            for (Vertice v : this.getVertices()) {
                if (grau == 0) {
                    grau = v.getAdjacencias().size();
                } else {
                    if (grau != v.getAdjacencias().size()) return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean eCompleto() {
        if (!this.getVertices().isEmpty()) {
            for (Vertice v : this.getVertices()) {
                for (Vertice v2 : this.getVertices()) {
                    if (!v.getAdjacencias().contains(v2)) return false;
                }
            }
            return true;
        }
        return false;
    }

    public boolean eNulo() {
        for (Vertice v : this.getVertices()) {
            if (!v.getArestas().isEmpty()) return false;
        }
        return true;
    }

    public boolean eBipartido() {
        for (Vertice v1 : this.getVertices()) {
            for (Vertice v2 : v1.getAdjacencias()) {
                for (Vertice v3 : v2.getAdjacencias()) {
                    if (v1.getAdjacencias().contains(v3)) return false;
                }
            }
        }
        return false;
    }

    public ArrayList<Aresta> getArestas() {
        ArrayList<Aresta> arestas = new ArrayList<>();

        if (!this.getVertices().isEmpty()) {
            for (Vertice v : this.getVertices()) {
                for (Aresta a : v.getArestas()) {
                    if (!arestas.contains(a)) arestas.add(a);
                }
            }
        }

        return arestas;
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
            if (a.getOrigem() == origem && a.getDestino() == destino) aresta = a;
        }

        if (aresta == null) new Aresta(valor, origem, destino);
    }

    private Vertice verificaVertice(int valor) {
        Vertice v = this.getVertice(valor);

        if (v == null) {
            v = new Vertice(valor);
            this.getVertices().add(v);
        }

        return v;
    }

    private Aresta getAresta(int origem, int destino) {
        return this.getAresta(this.getVertice(origem), this.getVertice(destino));
    }

    private Aresta getAresta(Vertice origem, Vertice destino) {
        if (origem != null && destino != null) {
            for (Aresta a : origem.getArestas()) {
                if (a.getOrigem() == origem && a.getDestino() == destino) return a;
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

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    private void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
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
}
