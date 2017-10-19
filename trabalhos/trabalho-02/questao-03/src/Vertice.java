import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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

    public int qtdArvores() {
        if (!this.getAdjacencias().isEmpty()) {
            return 1 + qtdArvores(this.getAdjacencias(), this);
        }
        return 1;
    }

    private int qtdArvores(ArrayList<Vertice> adjacencias, Vertice pai) {
        if (!adjacencias.isEmpty()) {
            for (Vertice v : adjacencias) {
                for (Vertice v1: v.getAdjacencias()) {
                    if (v != v1) System.out.println("Hi " + v1.getValor() + " dad: " + v.getValor());
                }
//                if (v != pai) return (adjacencias.size()+1) + qtdArvores(v.getAdjacencias(), v);
            }
        }
        return 1;
    }
}
