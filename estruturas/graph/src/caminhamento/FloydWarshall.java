package caminhamento;

import grafo.Grafo;

/**
 * Created by fabio.fischer on 02/11/2017.
 */
public class FloydWarshall {

    /**
     * Grafo em que o algorítmo será executado
     */
    private Grafo g;

    /**
     * Matriz de custo do grafo
     */
    private Float[][] W;

    /**
     * Número de vértices do grafo
     */
    private int n;

    /**
     * Matriz de distância do algorítmo
     */
    private Float[][] D;

    /**
     * Matriz de roteamento do algorítmo.
     */
    private Integer[][] R;

    /***
     * Dado um grafo valorado G=(V,E), queremos encontrar os caminhos mínimos entre todos os pares de vértices.
     * Este algorítmo calcula esses caminhos através de operaç~es recursivas em matrizes de distância (D), de tamanho n x n.
     * Os caminhos são armazenados em uma matriz de roteamento (R), construída a partir da matriz de distancia.
     *
     * @param g Grafo em que o algorítmo será executado
     */
    public FloydWarshall(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.g = g;
        this.initializeSingleSource();
        this.floydW();
    }

    /**
     *  Matriz de Distância (D):
     *          D[i][j] =   se k = 0,                       Wij
     *                      se k >= 1,                      min {Dij, Dik + Dkj)
     *
     *  Matriz de Roteamento (R):
     *      Inicialização:
     *          R[i][j] =   se Vi == Vj ou Wij = null,      null
     *                      se Vi != Vj e Wij < null,       Vi
     *
     *      Demais matrizes:
     *          R[i][j] =   se Dij <= Dik + Dkj,            Rij
     *                      se Dij > Dik + Dkj,             Rkj
     */
    private void floydW() {
        for(int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                D[i][j] = (W[i][j] != null) ? W[i][j] : Float.MAX_VALUE;
                R[i][j] = (i != j && W[i][j] != null) ? i : null;
            }
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // k será o pivô
                    if ((D[i][k] + D[k][j]) < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                        R[i][j] = R[k][j];
                    }
                }
            }
        }
    }

    /**
     * Inicializa as variáveis que o algorítmo irá consumir
     */
    private void initializeSingleSource() {
        this.W = g.getMatrizAdjacencia();
        this.n = g.getVertices().size();
        this.D = new Float[this.n][this.n];
        this.R = new Integer[this.n][this.n];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("\nMatriz de Distância (D):");

        if (this.D != null) {
            for (Float[] d : this.D) {
                builder.append("\n\t");
                for (int j = 0; j < d.length; j++) {
                    builder.append((d[j] == Float.MAX_VALUE) ? "MAX" : d[j]).append(((j + 1) < d.length) ? ", " : "");
                }
            }
        }

        builder.append("\n\nMatriz de Roteamento (R):");

        if (this.R != null) {
            for (Integer[] r : this.R) {
                builder.append("\n\t");
                for (int j = 0; j < r.length; j++) {
                    builder.append(r[j]).append(((j + 1) < r.length) ? ", " : "");
                }
            }
        }

        return builder.toString();
    }
}
