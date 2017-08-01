/**
 * Created by fabio.fischer on 28/07/2017.
 */
public class BinaryTree implements IBinaryTree {
    private Node root;

    public BinaryTree() {}

    public BinaryTree(int[] keys) {
        this.add(keys);
    }

    public boolean isEmpty() {
        return this.getRoot() == null;
    }

    @Override
    public void add(int key) {
        if (!this.isEmpty()) {
            this.getRoot().addChild(new Node(key));
        } else {
            this.setRoot(new Node(key));
        }
    }

    private void add(int [] keys) {
        for (int key : keys) {
            this.add(key);
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
    public int minValue() {
        if (!this.isEmpty()) {
            return this.getRoot().getMinValue();
        }
        return 0;
    }

    @Override
    public int maxValue() {
        if (!this.isEmpty()) {
            return this.getRoot().getMaxValue();
        }
        return 0;
    }

    @Override
    public int size() {
        if (this.getRoot() != null) {
            return 1 + this.countChildren(this.getRoot());
        }
        return 0;
    }

    private int countChildren(Node node) {
        return ((node.getLeftNode() == null) ? 0 : countChildren(node.getLeftNode()) + 1)
                + ((node.getRightNode() == null) ? 0 : countChildren(node.getRightNode()) + 1);
    }

    @Override
    public String toStringPreOrder() {
        if (!this.isEmpty()) {
            return toStringPreOrder(this.getRoot());
        }
        return null;
    }

    private String toStringPreOrder(Node node) {
        if (node != null) {
            return ("| " + node.getKey() + toStringPostOrder(node.getLeftNode()) + toStringPostOrder(node.getRightNode()));
        } else {
            return "";
        }
    }

    @Override
    public String toStringInOrder() {
        if (!this.isEmpty()) {
            return toStringInOrder(this.getRoot());
        }
        return null;
    }

    private String toStringInOrder(Node node) {
        if (node != null) {
            return toStringPostOrder(node.getLeftNode()) + ("| " + node.getKey() + toStringPostOrder(node.getRightNode()));
        } else {
            return "";
        }
    }

    @Override
    public String toStringPostOrder() {
        if (!this.isEmpty()) {
            return toStringPostOrder(this.getRoot());
        }
        return null;
    }

    private String toStringPostOrder(Node node) {
        if (node != null) {
            return toStringPostOrder(node.getLeftNode()) + toStringPostOrder(node.getRightNode()) + ("| " + node.getKey());
        } else {
            return "";
        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }
}
