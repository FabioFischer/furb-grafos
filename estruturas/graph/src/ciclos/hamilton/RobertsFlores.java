package ciclos.hamilton;

import grafo.Grafo;
import grafo.Vertice;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @author fabio.fischer
 */
public class RobertsFlores {

    /**
     * Grafo ao qual o algorítmo será executado
     */
    private Grafo g;

    /**
     * Lista de caminhos hamiltonianos que serão encontrados em tempo de execução
     */
    private ArrayList<Stack<Vertice>> P;

    /**
     * Construtor do algorítmo
     * @param g Grafo em que o algorítmo será executado
     */
    public RobertsFlores(Grafo g) {
        if (g == null) {
            throw new IllegalArgumentException("Qualé mano, ta me zoando?? \nVai popular essas porra antes de me criar!");
        }
        this.g = g;
        this.P = new ArrayList<>();
        RobertsFlores();
    }

    /**
     * Cria uma pilha responsável por guardar o caminhamento entre os vértices do grafo.
     * O algoritmo parte de um vértice inicial e determina um caminho, se possível, que leva até o próximo vértice.
     * O objetivo é percorrer todas as subárvores do grafo.
     */
    private void RobertsFlores() {
        Stack<Vertice> S = new Stack<>();

        for (Vertice v1 : g.getVertices()) {
            S.push(v1);
            getSubSet(S, v1);
        }
    }

    /**
     * Se um vértice viável é encontrado, o mesmo é adicionado na pilha S e a busca reinicia a partir deste vértice por meio de recursão
     * Senão, realiza uma operação de backtracking na tentativa de encontrar um caminho possível.
     * @param S Pilha contendo a sequencia de vértices visitados
     * @param v Vértice da iteração
     */
    private void getSubSet(Stack<Vertice> S, Vertice v) {
        if (isHamiltonianCicle(S)) {
            P.add((Stack<Vertice>)S.clone());
        }
        for (Vertice a : v.getAdjacencias()) {
            if (!S.contains(a)) {
                S.push(a);
                getSubSet(S, a);
            }
        }
        S.pop();
    }

    /**
     * O caminho será hamiltoniano quando todos vértices do grafo se encontrarem no ciclo atual e o vértice do topo da pilha possuir adjascencia ao vértice inicial
     * @param S Pilha contendo a sequencia de vértices visitados
     * @return true, se a pilha S conter um ciclo hamiltoniano
     */
    private boolean isHamiltonianCicle(Stack<Vertice> S) {
        for (Vertice v : g.getVertices()) {
            if (!S.contains(v))
                return false;
        }
        return S.peek().getAdjacencias().contains(S.firstElement());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n\n\tCaminhos hamiltonianos:\n\n\t\t");

        for (Stack<Vertice> p : P) {
            stringBuilder.append(p.toString()).append("\n\t\t");
        }
        return stringBuilder.toString();
    }
}
