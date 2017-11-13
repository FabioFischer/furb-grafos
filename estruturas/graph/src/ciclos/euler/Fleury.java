package ciclos.euler;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by fabio.fischer on 06/11/2017.
 */
public class Fleury {

    /**
     * Grafo em que o algorítmo será executado
     */
    private Grafo g;

    /**
     * Pilha dos vértices explorados
     */
    private Stack<Vertice> Q;

    /**
     * Lista de arestas pendentes
     */
    private ArrayList<Aresta> A;

    /**
     * Vertice de origem do algorítmo
     */
    private Vertice v;

    /**
     * Custo total de percorrimento do grafo
     */
    private Float d = 0f;

    /**
     *
     * @param g
     */
    public Fleury(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.initializeSingleSource(g, g.getVertice(0));
        this.execute();
    }

    /**
     *
     * @param g
     * @param v
     */
    public Fleury(Grafo g, Vertice v) {
        if (g == null || v == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.initializeSingleSource(g, v);
        this.execute();
    }

    /**
     * Executa o algorítmo
     */
    private void execute() {
        Aresta a = getAresta(this.v);

        if (a != null) {
            do {
                this.d += a.getValor();
                this.Q.push(a.getDestino());
            } while ((a = this.getAresta(a.getDestino())) != null);
        }

//        if (!isSemiEulerian()) {
//            this.d = 0f;
//        }
    }

    /**
     * Comece em qualquer vértice e percorra as arestas de forma aleatória, seguindo sempre as seguintes regras:
     *
     * Regra I: apague as arestas depois de passar por elas
     * Regra II: se aparecer algum vértice isolado, apague-o também
     * Regra III: passe por uma ponte somente se não houver outra alternativa
     *
     * @param origem
     * @return
     */
    private ArrayList<Aresta> getArestas(Vertice origem) {
        ArrayList<Aresta> arestas = new ArrayList<>();

        if (!this.g.getVertices().isEmpty()) {
            for (Aresta a : origem.getArestas()) {
                if (!arestas.contains(a) && this.A.contains(a) && a.getOrigem() == origem)
                    arestas.add(a);
            }
        }
        return arestas;
    }

    /**
     *
     * @param origem
     * @return
     */
    private Aresta getAresta(Vertice origem) {
        ArrayList<Aresta> r = this.getArestas(origem);
        Aresta s = null;

        if (r != null) {
            // Lista de arestas que formam uma ponte.
            Stack<Aresta> p = new Stack<>();

            //Itera todas as arestas adjascentes a origem que ainda estão na lista de arestas do algorítmo (A)
            for (Aresta a : r) {
                if (s == null) {
                    // Verifica se aresta 'a' é uma ponte
                    if (isUniquelyConnected(origem, a.getDestino(), a)) {
                        p.push(a);
                    } else {
                        s = a;
                    }
                }
            }
            if (s == null)
                s = p.size() > 0 ? p.pop() : null;
            if (s != null)
                // Se o grafo não é dirigido, deve remover as duas referências da aresta: 'origem x destino' e 'destino x origem'
                if (!this.g.eDirigido())
                    this.A.remove(g.getAresta(s.getDestino(), s.getOrigem()));
                this.A.remove(s);
        }
        return s;
    }

    /**
     *
     * @param i
     * @param u
     * @param a
     * @return
     */
    private boolean isUniquelyConnected(Vertice i, Vertice u, Aresta a) {
        return !Collections.disjoint(getDisjointAdjascency(i, a), getDisjointAdjascency(u, a));
    }

    /**
     *
     * @param v
     * @param s
     * @return
     */
    private ArrayList<Vertice> getDisjointAdjascency(Vertice v, Aresta s) {
        ArrayList<Vertice> adj = new ArrayList<>();

        for (Aresta a : v.getArestas()) {
            if (a != s && a.getOrigem() == v) {
                adj.add(a.getDestino());
            }
        }
        return adj;
    }

    /**
     *
     */
    private void initializeSingleSource(Grafo g, Vertice v) {
        this.g = g;
        this.Q = new Stack<>();
        this.A = g.getArestas();
        this.v = v;

        this.Q.push(v);
    }

    /**
     *
     * @return
     */
    public boolean isSemiEulerian() {
        return this.A != null && this.A.isEmpty() && this.v != Q.peek();
    }

    /**
     *
     * @return
     */
    public boolean isEulerian() {
        return this.A != null && this.A.isEmpty() && this.v == Q.peek();
    }

    /**
     *
     * @return
     */
    public Float getCustoTotal() {
        return this.d;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();

        if (this.isEulerian()) {
            strBuilder.append("\n\tGrafo é euleriano\n\tCusto total: ").append(this.getCustoTotal().toString());
            strBuilder.append("\n\tCaminho: " + Q.toString());
        } else if (this.isSemiEulerian()) {
            strBuilder.append("\n\tGrafo é semi-euleriano\n\tCusto total: ").append(this.getCustoTotal().toString());
            strBuilder.append("\n\tCaminho: " + Q.toString());
        } else {
            strBuilder.append("\n\tGrafo não é euleriano\n\tCusto Total: ").append(this.getCustoTotal().toString());
        }

        return strBuilder.toString();
    }
}
