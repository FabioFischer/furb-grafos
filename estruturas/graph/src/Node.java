import java.util.ArrayList;
import java.util.List;

/**
 * Created by fabio.fischer on 28/07/2017.
 */

public class Node<T, E> {
    private T key;
    private List<Edge<E>> edges;

    public Node(T key) {
        this.setKey(key);
    }

    public List<Node> getConnectedNodes() {
        List<Node> conn = new ArrayList<>();

        for (Edge edge : edges) {
            conn.add(((edge.getSource() == this) ? edge.getDestination() : edge.getSource()));
        }

        return conn;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public List<Edge<E>> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge<E>> edges) {
        this.edges = edges;
    }
}
