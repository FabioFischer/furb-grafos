
/**
 **   FURB - Bacharelado em Ciências da Computação
 **   Teoria dos Grafos
 **   Trabalho 01 - Questão 04
 **
 **   Fábio Luiz Fischer
 *
 **/

public class Node {
    private int key;
    private Node leftNode;
    private Node rightNode;

    private int pile;

    public static final class NodeDirection {
        final static NodeDirection LEFT_NODE = new NodeDirection();
        final static NodeDirection RIGHT_NODE = new NodeDirection();
    }

    public Node(int key) {
        this.setKey(key);
        this.setPile(0);
    }

    public int getKey() {
        return key;
    }

    public int getMinValue() {
        if (this.getLeftNode() != null) {
            return this.getLeftNode().getMinValue();
        } else {
            return this.getKey();
        }
    }

    public int getMaxValue() {
        if (this.getLeftNode() != null) {
            return this.getLeftNode().getMaxValue();
        } else {
            return this.getKey();
        }
    }

    public void addChild(Node node) {
        if (node.getKey() <= this.getKey()) {
            if (this.getLeftNode() == null) {
                node.setPile(this.getPile() - 1);
                this.setLeftNode(node);
            } else {
                this.getLeftNode().addChild(node);
            }
        } else {
            if (this.getRightNode() == null) {
                node.setPile(this.getPile() + 1);
                this.setRightNode(node);
            } else {
                this.getRightNode().addChild(node);
            }
        }
    }

    public boolean addChild(Node node, NodeDirection direction) {
        if (direction.equals(NodeDirection.LEFT_NODE)) {
            if (this.getLeftNode() == null) {
                node.setPile(this.getPile() - 1);
                this.setLeftNode(node);
                return true;
            }
        } else if (direction.equals(NodeDirection.RIGHT_NODE)) {
            if (this.getRightNode() == null) {
                node.setPile(this.getPile() + 1);
                this.setRightNode(node);
                return true;
            }
        }
        return false;
    }

    public void remove(int key) {
        this.remove(key, null);
    }

    public void remove(int key, Node parent) {
        if (key < this.getKey()) {
            if (this.getLeftNode() != null)
                this.getLeftNode().remove(key, this);

        } else if (key > this.getKey()) {
            if (this.getRightNode() != null)
                this.getRightNode().remove(key, this);

        } else {
            if (this.getLeftNode() != null && this.getRightNode() != null) {
                this.setKey(this.getRightNode().getMinValue());
                this.getRightNode().remove(this.getKey(), this);

            } else if (parent.getLeftNode() == this) {
                parent.setLeftNode((this.getLeftNode() != null) ? this.getLeftNode() : this.getRightNode());

            } else if (parent.getRightNode() == this) {
                parent.setRightNode((this.getLeftNode() != null) ? this.getLeftNode() : this.getRightNode());

            }
        }
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    public int getPile() {
        return pile;
    }

    public void setPile(int pile) {
        this.pile = pile;
    }
}
