
public class Node {
    private int key;
    private Node leftNode;
    private Node rightNode;

    public Node(int key) {
        this.setKey(key);
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
                this.setLeftNode(node);
            } else {
                this.getLeftNode().addChild(node);
            }
        } else {
            if (this.getRightNode() == null) {
                this.setRightNode(node);
            } else {
                this.getRightNode().addChild(node);
            }
        }
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
}
