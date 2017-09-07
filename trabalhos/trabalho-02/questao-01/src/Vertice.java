import java.util.ArrayList;
import java.util.List;


/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 01
 *
 *   Fábio Luiz Fischer
 *
 **/

public class Vertice<T, E> {
    private T valor;
    private List<Aresta<E>> arestas;

    public Vertice(T key) {
        this.setArestas(new ArrayList<>());
        this.setValor(key);
    }

    public List<Vertice> getConnectedNodes() {
        List<Vertice> conn = new ArrayList<>();

        for (Aresta edge : arestas) {
            conn.add(((edge.getOrigem() == this) ? edge.getDestino() : edge.getOrigem()));
        }

        return conn;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public List<Aresta<E>> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta<E>> arestas) {
        this.arestas = arestas;
    }
}
