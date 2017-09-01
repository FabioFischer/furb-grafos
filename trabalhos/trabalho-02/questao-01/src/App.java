/**
 * Created by fabio.fischer on 28/07/2017.
 */
public class App {
    public static void main(String[] args) {
        Grafo<String, Integer> grafo = new Grafo<>();

        grafo.getVertices().add(new Vertice<>("A"));
        grafo.getVertices().add(new Vertice<>("B"));
        grafo.getVertices().add(new Vertice<>("C"));
        grafo.getVertices().add(new Vertice<>("D"));

        grafo.addAresta(3, "A", "B");
        grafo.addAresta(5, "A", "C");
        grafo.addAresta(7, "B", "C");
        grafo.addAresta(1, "C", "C");
        grafo.addAresta(5, "D", "C");
        grafo.addAresta(2, "D", "A");

        System.out.println(grafo.toString());
    }
}
