import java.util.ArrayList;

/**
 * *   FURB - Bacharelado em Ciências da Computação
 * *   Teoria dos Grafos
 * *   Trabalho 01 - Questão 05
 * *
 * *   Fábio Luiz Fischer
 **/

public class BinaryTree implements IBinaryTree {
    private Node root;
    private ArrayList<Pile> piles;

    public BinaryTree() {
        this.setPiles(new ArrayList<>());
    }

    public BinaryTree(int[] keys) {
        this.add(keys);
        this.setPiles(new ArrayList<>());
    }

    public boolean isEmpty() {
        return this.getRoot() == null;
    }

    @Override
    public void add(Node node) {
        if (!this.isEmpty()) {
            this.getRoot().addChild(this.getPiles(), node);
        } else {
            Pile pile = new Pile(0);
            pile.add(node);
            node.setPile(pile);
            this.setRoot(node);
            this.getPiles().add(pile);
        }
    }

    @Override
    public void add(Node parent, Node node, Node.NodeDirection direction) {
        if (!this.isEmpty()) {
            if (!parent.addChild(this.getPiles(), node, direction)) {
                throw new IllegalArgumentException("Não é possível adicionar um filho a este nó na direção especificada.");
            }
        }
    }

    private void add(int[] keys) {
        for (int key : keys) {
            this.add(new Node(key));
        }
    }

    @Override
    public void remove(int key) {
        if (!this.isEmpty()) {
            if (this.getRoot().getKey() == key) {
                Node aux = new Node(0);
                aux.setLeftNode(this.getRoot());
                this.getRoot().remove(key, aux);
                this.setRoot(aux.getLeftNode());
            } else {
                this.getRoot().remove(key);
            }
        }
    }

    @Override
    public int size() {
        if (this.getRoot() != null) {
            return 1 + this.countChildren(this.getRoot());
        }
        return 0;
    }

    @Override
    public String printSum() {
        this.getPiles().sort((o1, o2) -> (o1.getId() < o2.getId()) ? -1 : ((o1.getId() > o2.getId()) ? +1 : 0));
        StringBuilder str = new StringBuilder();

        for (Pile pile : this.getPiles()) {
            str.append("\nPilha ").append(pile.getId()).append(": ").append(pile.getSum());
        }

        return str.toString();
    }

    private int countChildren(Node node) {
        return ((node.getLeftNode() == null) ? 0 : countChildren(node.getLeftNode()) + 1)
                + ((node.getRightNode() == null) ? 0 : countChildren(node.getRightNode()) + 1);
    }

    public String toStringPreOrder() {
        if (!this.isEmpty()) {
            return toStringPreOrder(this.getRoot());
        }
        return null;
    }

    private String toStringPreOrder(Node node) {
        if (node != null) {
            return ("| " + node.getKey() + ":" + node.getPile().getId() + toStringPreOrder(node.getLeftNode()) + toStringPreOrder(node.getRightNode()));
        } else {
            return "";
        }
    }

    public String toStringInOrder() {
        if (!this.isEmpty()) {
            return toStringInOrder(this.getRoot());
        }
        return null;
    }

    private String toStringInOrder(Node node) {
        if (node != null) {
            return toStringInOrder(node.getLeftNode()) + ("| " + node.getKey() + ":" + node.getPile().getId() + toStringInOrder(node.getRightNode()));
        } else {
            return "";
        }
    }

    public String toStringPostOrder() {
        if (!this.isEmpty()) {
            return toStringPostOrder(this.getRoot());
        }
        return null;
    }

    private String toStringPostOrder(Node node) {
        if (node != null) {
            return toStringPostOrder(node.getLeftNode()) + toStringPostOrder(node.getRightNode()) + ("| " + node.getKey() + ":" + node.getPile().getId());
        } else {
            return "";
        }
    }

    public ArrayList<Pile> getPiles() {
        return piles;
    }

    public void setPiles(ArrayList<Pile> piles) {
        this.piles = piles;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
