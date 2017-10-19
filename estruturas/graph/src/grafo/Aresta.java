package grafo;

public class Aresta implements Comparable{
    // Custo da aresta
    private float valor;

    // Vértice de origem
    private Vertice origem;

    // Vértice de destino
    private Vertice destino;

    public Aresta(float valor, Vertice origem, Vertice destino) {
        this.setValor(valor);
        this.setOrigem(origem);
        this.setDestino(destino);

        origem.getArestas().add(this);
        destino.getArestas().add(this);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
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

    @Override
    public int compareTo(Object o) {
        Aresta a = (Aresta)o;

        return this.getValor() > a.getValor() ? 1 : (this.getValor() == a.getValor() ? 0 : -1) ;
    }

    @Override
    public String toString() {
        return "Valor: " + this.getValor() + " | origem: " + this.getOrigem().getValor() + " destino: " + this.getDestino().getValor();
    }
}
