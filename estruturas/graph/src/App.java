/**
 * Created by fabio.fischer on 28/07/2017.
 */
public class App {
    public static void main(String[] args) {
        Graph<String, Integer> graph = new Graph<>();

        graph.getNodes().add(new Node<>("A"));
        graph.getNodes().add(new Node<>("B"));
        graph.getNodes().add(new Node<>("C"));
        graph.getNodes().add(new Node<>("D"));

        graph.addEdge(3, "A", "B");
        graph.addEdge(5, "A", "C");
        graph.addEdge(7, "B", "C");
        graph.addEdge(1, "C", "C");
        graph.addEdge(5, "D", "C");
        graph.addEdge(2, "D", "A");

        System.out.println(graph.toString());
    }
}
