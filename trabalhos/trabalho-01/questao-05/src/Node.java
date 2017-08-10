import java.util.ArrayList;

/**
 * *   FURB - Bacharelado em Ciências da Computação
 * *   Teoria dos Grafos
 * *   Trabalho 01 - Questão 05
 * *
 * *   Fábio Luiz Fischer
 **/

public class Node {
    private int key;
    private Node leftNode;
    private Node rightNode;

    private Pile pile;

    public static final class NodeDirection {
        final static NodeDirection LEFT_NODE = new NodeDirection();
        final static NodeDirection RIGHT_NODE = new NodeDirection();
    }

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

    public void addChild(ArrayList<Pile> piles, Node node) {
        if (node.getKey() <= this.getKey()) {
            if (this.getLeftNode() == null) {
                Pile pile = (this.getPile(piles, this.getPile().getId() - 1));
                if (pile == null) {
                    pile = new Pile(this.getPile().getId() - 1);
                    pile.add(node);
                    piles.add(pile);

                    node.setPile(pile);
                } else {
                    pile.add(node);
                    node.setPile(pile);
                }
                this.setLeftNode(node);
            } else {
                this.getLeftNode().addChild(piles, node);
            }
        } else {
            if (this.getRightNode() == null) {
                Pile pile = (this.getPile(piles, this.getPile().getId() + 1));
                if (pile == null) {
                    pile = new Pile(this.getPile().getId() + 1);
                    pile.add(node);
                    piles.add(pile);

                    node.setPile(pile);
                } else {
                    pile.add(node);
                    node.setPile(pile);
                }
                this.setRightNode(node);
            } else {
                this.getRightNode().addChild(piles, node);
            }
        }
    }

    public boolean addChild(ArrayList<Pile> piles, Node node, NodeDirection direction) {
        if (direction.equals(NodeDirection.LEFT_NODE)) {
            if (this.getLeftNode() == null) {
                Pile pile = (this.getPile(piles, this.getPile().getId() - 1));
                if (pile == null) {
                    pile = new Pile(this.getPile().getId() - 1);
                    pile.add(node);
                    piles.add(pile);

                    node.setPile(pile);
                } else {
                    pile.add(node);
                    node.setPile(pile);
                }
                this.setLeftNode(node);
                return true;
            }
        } else if (direction.equals(NodeDirection.RIGHT_NODE)) {
            if (this.getRightNode() == null) {
                Pile pile = (this.getPile(piles, this.getPile().getId() + 1));
                if (pile == null) {
                    pile = new Pile(this.getPile().getId() + 1);
                    pile.add(node);
                    piles.add(pile);

                    node.setPile(pile);
                } else {
                    pile.add(node);
                    node.setPile(pile);
                }
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

    private Pile getPile(ArrayList<Pile> piles, int id) {
        for (Pile pile : piles) {
            if (pile.getId() == id)
                return pile;
        }
        return null;
    }

    public Pile getPile() {
        return pile;
    }

    public void setPile(Pile pile) {
        this.pile = pile;
    }
}
