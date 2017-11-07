package conexidade;

import grafo.Aresta;
import grafo.Grafo;
import grafo.Vertice;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DisjointSets {

    /**
     * Grafo em que o algorítmo será executado
     */
    private Grafo g;

    /**
     * Lista principal contendo todos os subconjuntos do grafo
     */
    private ArrayList<ArrayList<Vertice>> s;

    /**
     *
     * @param g
     */
    public DisjointSets(Grafo g) {
        if (g == null)
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");

        this.g = g;
        this.dS();
    }

    /**
     * Executa o algorítmo
     */
    private void dS() {
        initializeSingleSource();

        for (Aresta a : this.g.getArestas()) {
            ArrayList<Vertice> ar1 = getSubset(a.getOrigem());
            ArrayList<Vertice> ar2 = getSubset(a.getDestino());

            if (ar1 != null && ar2 != null && ar1 != ar2) {
                joinLists(ar1, ar2);
            }
        }
    }

    /**
     * Cria um subconjunto para cada Vertice do grafo e os adiciona a lista principal
     */
    private void initializeSingleSource() {
        this.s = new ArrayList<>();

        for (Vertice v : this.g.getVertices()) {
            ArrayList<Vertice> t = new ArrayList<>();
            t.add(v);
            this.s.add(t);
        }
    }

    /**
     * Busca primeiro subconjunto que possue o vértice informado como parâmetro
     * @param v
     * @return
     */
    @Nullable
    private ArrayList<Vertice> getSubset(Vertice v) {
        for (ArrayList<Vertice> ar : this.s) {
            if (ar.contains(v))
                return ar;
        }
        return null;
    }

    /**
     * Realiza a união de dois conjuntos. Todos os elementos de ar2, se já não existirem, serão armazenados em ar1.
     * Ao final da execução, o parâmetro ar1 estará vazio e não será mais referenciado na lista main
     * @param ar1
     * @param ar2
     */
    private void joinLists(ArrayList<Vertice> ar1, ArrayList<Vertice> ar2) {
        for (Vertice v : ar2) {
            if (!ar1.contains(v)) {
                ar1.add(v);
            }
        }
        ar2.clear();
        this.s.remove(ar2);
    }

    /**
     * Ao final do algorítmo, caso exista mais de um subconjunto em s, sabe-se que o grafo não é conexo
     * @return
     */
    public boolean isConnected() {
        return (this.s != null) && (this.s.size() == 1);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("\n\nSubconjuntos de g:\n");
        int id = 1;

        for (ArrayList<Vertice> ar : this.s) {
            str.append("\nsubconjunto ").append(id).append(":  ");

            for (Vertice v : ar) {
                str.append(v.getId()).append(", ");
            }

            id++;
        }

        return str.toString();
    }
}
