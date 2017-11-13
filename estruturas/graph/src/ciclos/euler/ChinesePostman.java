package ciclos.euler;

import caminhamento.Dijkstra;
import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.*;

/**
 * @author fabio.fischer
 */
public class ChinesePostman {

    class NodeCombination {
        private Vertice v1;
        private Vertice v2;

        NodeCombination(Vertice v1, Vertice v2) {
            this.v1 = v1;
            this.v2 = v2;
        }

        Vertice getV1() {
            return v1;
        }

        Vertice getV2() {
            return v2;
        }

        void setV1(Vertice v1) {
            this.v1 = v1;
        }

        void setV2(Vertice v2) {
            this.v2 = v2;
        }
    }

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
     * Matriz de roteamento dos grafos de grau ímpar (o)
     */
    private Vertice[][] R;

    /**
     * Construtor do algorítmo
     * @param g Grafo em que o algorítmo será executado
     */
    public ChinesePostman(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.g = g;
        this.o = new ArrayList<>();
        if (!isValidGraph()) {
            throw new IllegalArgumentException("Mano, com esse grafo num dá.");
        }
        this.initializeSingleSource(g);
        this.chinesePostman();
    }

    /**
     * Executa algorítmo de Fleury  e verifica estado atual do grafo
     * O grafo não deve ser euleriano
     * @return true, se o grafo atende os requisitos do algorítmo
     */
    private boolean isValidGraph() {
        return !new Fleury(this.g).isEulerian();
    }

    /**
     * Executa o algorítmo de Dijsktra para cada vértice ímpar do grafo, populando as matrizes de distância e roteamento locais.
     */
    private void chinesePostman() {
        for (Vertice v1 : g.getVertices()) {
            new Dijkstra(g, v1);
            for (Vertice v2 : g.getVertices()) {
                D[v1.getId()][v2.getId()] = v2.getDistancia();
                R[v1.getId()][v2.getId()] = v2.getPai();
            }
        }
        eulerizeGraph(findOptimalMatches());
    }

    /**
     * Busca as melhores combinações de vértices ímpares do grafo, levando em consideração o menor custo encontrada pelo algorítmo de Dijkstra
     * @return lista contendo as combinações com menor custo entre os vértices de grau ímpar
     */
    private ArrayList<NodeCombination> findOptimalMatches() {
        ArrayList<NodeCombination> p = new ArrayList<>();

        while (existsUnhandledOddNodes(p)) {
            NodeCombination nC = null;
            float bC = Float.MAX_VALUE;

            for (int i = 0; i < D.length; i++) {
                for (int j = 0; j < D[i].length; j++) {
                    if (D[i][j] != null && D[i][j] != 0f) {
                        Vertice v1 = g.getVertice(i), v2 = g.getVertice(j);

                        if ((v1.getGrau() % 2 != 0) && (v2.getGrau() % 2 != 0) && (D[i][j] < bC)) {
                            if (isUnhandledOddNode(p, v1) && isUnhandledOddNode(p, v2)) {
                                bC = D[i][j];

                                if (nC == null) {
                                    nC = new NodeCombination(v1, v2);
                                } else {
                                    nC.setV1(v1);
                                    nC.setV2(v2);
                                }
                            }
                        }
                    }
                }
            }
            if (!p.contains(nC)) p.add(nC);
        }
        return p;
    }

    /**
     * Verifica se existem vértices na lista de vértices ímpares que não estão presentes na lista de combinações
     * @param p Lista de combinações de vértices ímpares
     * @return true, se existe ao menos um vértice que não esta presente na lista p
     */
    private boolean existsUnhandledOddNodes(ArrayList<NodeCombination> p) {
        for (Vertice v : o)
            if (p.stream().noneMatch(nC -> nC.getV1() == v || nC.getV2() == v)) return true;
        return false;
    }

    /**
     * Verifica se o vértice ímpar ja esta contido em uma combinação de vértices existente
     * @param p Lista de combinações de vértices ímpares
     * @param v Vértice da iteração
     * @return true, se o grafo não esta contido em nenhuma combinação da lista p
     */
    private boolean isUnhandledOddNode(ArrayList<NodeCombination> p, Vertice v) {
        return p.stream().noneMatch(nC -> nC.getV1() == v || nC.getV2() == v);
    }

    /**
     * Adiciona arestas com o objetivo de construir um caminho artificial entre os vértices de grau ímpar, v1 para v2, com o custo igual ao encontrado na matriz D e torna-los de grau par
     * @param p Lista das melhores combinações entre os vértices ímpares
     */
    private void eulerizeGraph(ArrayList<NodeCombination> p) {
        if (!p.isEmpty()) {
            for (NodeCombination nC : p) {
                Stack<Vertice> s = getOptimizedPath(nC);

                if (!s.isEmpty()) {
                    Vertice v1 = s.pop(), v2 = s.pop();
                    do {
                        if (!g.eDirigido())
                            g.addAresta(D[v1.getId()][v2.getId()], v2, v1);
                        g.addAresta(D[v1.getId()][v2.getId()], v1, v2);
                        v1 = v2;
                    } while(!s.isEmpty() && (v2 = s.pop()) != null);
                }
            }
        }
    }

    /**
     * Busca o caminho encontrado pelo algorítmo de dijkstra na matriz de roteamento R
     * @param nC Combinação de vértices da iteração
     * @return Pilha ordenada com o caminho de dijkstra entre os vértices da combinação
     */
    private Stack<Vertice> getOptimizedPath(NodeCombination nC) {
        Stack<Vertice> s = new Stack<>();
        Vertice v2 = nC.getV2(), v3;
        s.add(nC.getV2());

        while (((v3 = R[nC.getV1().getId()][v2.getId()]) != null) && v3 != nC.getV1()) {
            s.add(v3);
            v2 = v3;
        }
        s.add(nC.getV1());
        Collections.reverse(s);

        return s;
    }

    /**
     * Inicializa variáveis globais e adiciona os vértices de grau ímpar de 'g' na lista 'o'
     * @param g Grafo em que o algorítmo sera executado
     */
    private void initializeSingleSource(Grafo g) {
        this.g.getVertices().stream()
                .filter(v -> v.getGrau() % 2 != 0)
                .forEach(o::add);

        this.D = new Float[g.getVertices().size()][g.getVertices().size()];
        this.R = new Vertice[g.getVertices().size()][g.getVertices().size()];
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder("\n\tVertices de grau ímpar: \n\t\t");
        Fleury f = new Fleury(g);

        for (Vertice v : o) {
            strBuilder.append(v.getId()).append(", ");
        }
        strBuilder.append("\n\tFleury: ").append(f.toString());

        return strBuilder.toString();
    }
}
