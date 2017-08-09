import java.util.ArrayList;

/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 05
 **
 **   Fábio Luiz Fischer
 *
 **/

public class Pile {
    private int id;
    private ArrayList<Node> nodes;

    public Pile(int id) {
        this.setId(id);
        this.setNodes(new ArrayList<>());
    }

    public void add(Node node) {
        if (!this.getNodes().contains(node)) {
            this.getNodes().add(node);
        }
    }

    public int getSum() {
        int result = 0;

        for (Node node: this.getNodes()) {
            result += node.getKey();
        }
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Node> getNodes() {
        return nodes;
    }

    public void setNodes(ArrayList<Node> nodes) {
        this.nodes = nodes;
    }
}
