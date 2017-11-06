package ciclosEulerianos;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.Collection;
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
     * Lista de arestas pendentes
     */
    private ArrayList<Aresta> A;

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
        this.g = g;
        this.A = g.getArestas();

        execute(g.getVertice(0));
    }

    /**
     * Comece em qualquer vértice e percorra as arestas de forma aleatória, seguindo sempre as seguintes regras:
     *
     * Regra I: apague as arestas depois de passar por elas
     * Regra II: se aparecer algum vértice isolado, apague-o também
     * Regra III: passe por uma ponte somente se não houver outra alternativa
     *
     * @param v
     */
    private void execute(Vertice v) {
        Aresta a = getAresta(v);

        if (a != null) {
            do {
                this.d += a.getValor();
            } while ((a = this.getAresta(a.getDestino())) != null);
        }

        if (!isEulerian()) {
            this.d = 0f;
        }
    }

    /**
     *
     * @param origem
     * @return
     */
    private ArrayList<Aresta> getArestas(Vertice origem) {
        ArrayList<Aresta> arestas = new ArrayList<>();

        if (!this.g.getVertices().isEmpty()) {
            for (Aresta a : origem.getArestas()) {
                if (!arestas.contains(a) && this.A.contains(a))
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
            for (Aresta a : r) {
                if (s != null) {
                    // Verifica se aresta 'a' é uma ponte
                    if (!Collections.disjoint(origem.getAdjacencias(), a.getDestino().getAdjacencias())) {
                        p.push(a);
                    } else {
                        s = a;
                    }
                }
            }
            s = (s == null) ? p.pop() : s;

            if (s != null) {
                this.A.remove(s);
            }
        }
        return s;
    }

    /**
     *
     * @return
     */
    private boolean isEulerian() {
        return this.A != null && !this.A.isEmpty();
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
        StringBuilder strBuilder = new StringBuilder("");

        return strBuilder.toString();
    }
}
