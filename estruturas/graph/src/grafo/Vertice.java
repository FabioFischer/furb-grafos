package grafo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Vertice implements Comparable{
    // ID do vertice
    private int valor;

    // Conjunto de arestas do vértice
    private List<Aresta> arestas;

    // Vértice pai - utilizado nos algoritmos de caminhamento do grafo
    private Vertice pai;

    // Distancia até determinado vértice - utilizado nos algoritmos de caminhamento do grafo
    private float distancia;

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

    public Aresta getMinAresta(Vertice v) {
        ArrayList<Aresta> adj = new ArrayList<>();

        for (Aresta a : this.getArestas()) {
            if (a.getOrigem() == this && a.getDestino() == v)
                adj.add(a);
        }

        return Collections.min(adj);
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

    public Vertice getPai() {
        return pai;
    }

    public void setPai(Vertice pai) {
        this.pai = pai;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    @Override
    public int compareTo(Object o) {
        Vertice v = (Vertice)o;

        return this.getDistancia() > v.getDistancia() ? 1 : (this.getDistancia() == ((Vertice) o).getDistancia() ? 0 : -1);
    }
}
