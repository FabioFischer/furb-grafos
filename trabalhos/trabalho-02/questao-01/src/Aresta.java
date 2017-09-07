
/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Teoria dos Grafos
 *   Trabalho 02 - Questão 01
 *
 *   Fábio Luiz Fischer
 *
**/

public class Aresta<E> {
    private E valor;
    private Vertice origem;
    private Vertice destino;

    public Aresta(E key) {
        this.setValor(key);
    }

    public E getValor() {
        return valor;
    }

    public void setValor(E valor) {
        this.valor = valor;
    }

    public Vertice getOrigem() {
        return origem;
    }

    public void setOrigem(Vertice origem) {
        this.origem = origem;
    }

    public Vertice getDestino() {
        return destino;
    }

    public void setDestino(Vertice destino) {
        this.destino = destino;
    }
}
