
/**
 * Created by fabio.fischer on 28/07/2017.
 */

public class Edge<E> {
    private E key;
    private Node source;
    private Node destination;

    public Edge(E key) {
        this.setKey(key);
    }

    public E getKey() {
        return key;
    }

    public void setKey(E key) {
        this.key = key;
    }

    public Node getSource() {
        return source;
    }

    public void setSource(Node source) {
        this.source = source;
    }

    public Node getDestination() {
        return destination;
    }

    public void setDestination(Node destination) {
        this.destination = destination;
    }
}
