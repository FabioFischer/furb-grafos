import java.util.ArrayList;
import java.util.List;


/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 03
 *
 *   Fábio Luiz Fischer
 *
 **/

public class Vertice {
    private int valor;
    private List<Aresta> arestas;

    public Vertice(int valor) {
        this.setArestas(new ArrayList<>());
        this.setValor(valor);
    }

    public ArrayList<Vertice> getAdjacencias() {
        ArrayList<Vertice> adj = new ArrayList<>();

        for (Aresta a : this.getArestas()) {
            if (a.getOrigem() == this) {
                adj.add(a.getDestino());
            }
        }

        return adj;
    }

    public int getGrau() {
        return this.getAdjacencias().size();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }
}
