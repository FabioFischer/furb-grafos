import java.util.List;

public class Graph<T, E> {
    private List<Node<T, E>> nodes;

    public Graph() {}

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < this.getNodes().size(); i++) {
            for (int j = 0; j < this.getNodes().size(); j++) {

            }
        }

        return builder.toString();
    }

    public int[][] getAdjascencyMatrix() {
        int[][] adjMatrix = new int[this.getNodes().size()][this.getNodes().size()];

        for (int i = 0; i < this.getNodes().size(); i++) {
            for (int j = 0; j < this.getNodes().size(); j++) {

            }
        }
        return adjMatrix;
    }

    public void addEdge(E key, T source, T destination) {
        this.addEdge(key, this.getNode(source), this.getNode(destination));
    }

    public void addEdge(E key, Node<T, E> source, Node<T, E> destination) {
        Edge<E> edge = new Edge<>(key);

        edge.setSource(source);
        edge.setDestination(source);

        source.getEdges().add(edge);
        destination.getEdges().add(edge);
    }

    public Node<T, E> getNode(T key) {
        if (!this.getNodes().isEmpty()) {
            for (Node<T, E> node : this.getNodes()) {
                if (node.getKey() == key)
                    return node;
            }
        } return null;
    }

    public List<Node<T, E>> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node<T, E>> nodes) {
        this.nodes = nodes;
    }
}
